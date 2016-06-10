package scopa.cona.service.load;

import org.apache.log4j.Logger;
import scopa.cona.database.constant.EnumBeans;
import scopa.cona.database.manager.OTAttrMappingManager;
import scopa.cona.database.manager.OTTableMappingManager;
import scopa.cona.database.manager.OriginAttrManager;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.model.OTTableMapping;
import scopa.cona.database.model.OriginAttr;
import scopa.cona.database.model.TargetTable;
import scopa.cona.database.util.SpringContextUtil;
import scopa.cona.exception.ConaException;
import scopa.cona.exception.ServiceException;
import scopa.cona.model.JDictionary;
import scopa.cona.model.JMapping;
import scopa.cona.model.JMappingMapping;
import scopa.cona.model.JMappingMappingProperties;
import scopa.cona.util.JsonUtil;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panda on 6/9/16.
 */
public class ParseMappingJson {
    public static final Logger logger = Logger.getLogger(ParseMappingJson.class);

    private static TargetTableManager targetTableManager = SpringContextUtil.getApplicationContextFromXml().getBean(
                            EnumBeans.targetTableManager.toString(), TargetTableManager.class);

    private static OriginAttrManager originAttrManager = SpringContextUtil.getApplicationContextFromXml().getBean(
                            EnumBeans.originAttrManager.toString(), OriginAttrManager.class);

    private static OTTableMappingManager otTableMappingManager = SpringContextUtil.getApplicationContextFromXml().getBean(
            EnumBeans.otTableMappingManager.toString(), OTTableMappingManager.class);

    private static OTAttrMappingManager otAttrMappingManager = SpringContextUtil.getApplicationContextFromXml().getBean(
            EnumBeans.otAttrMappingManager.toString(), OTAttrMappingManager.class);


    public static void parseEntity(FileReader entityFileReader) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");
        JMapping jMappingEntity = getMappingFromJson(entityFileReader);
        fetchDb(jMappingEntity);

    }

    public static void parseEvent(FileReader eventFileReader) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");
        JMapping jMappingEvent = getMappingFromJson(eventFileReader);
        fetchDb(jMappingEvent);

    }

    public static void parseRelation(FileReader relationFileReader) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");
        JMapping jMappingRelation = getMappingFromJson(relationFileReader);
        fetchDb(jMappingRelation);

    }

    public static JMapping getMappingFromJson(FileReader jsonContent) {
        return JsonUtil.getObjFromFileReader(jsonContent, JMapping.class);
    }

    public static void fetchDb(JMapping jMapping) {
        String ttVersion = jMapping.getVersion();
        String ttElementType = jMapping.getElementType();
        String ttLabelEn = jMapping.getLabel().getEn();
        String ttLabelCn = jMapping.getLabel().getCn();

        TargetTable matchedTargetTable = targetTableManager.getTargetTableByLabelEnElemTypeVersion(
                ttLabelEn, ttElementType, ttVersion);
        if (null == matchedTargetTable) {
            throw new ServiceException("Target table " + ttLabelEn + " is not found in database.");
        }

        List<Map<String, String>> oTableAttrMappingList = new ArrayList<>();
        List<Map<String, String>> otTableMappingList = new ArrayList<>();
        List<Map<String, String>> otAttrEnMappingList = new ArrayList<>();
        List<Map<Map<String, String>, String>> otAttrValueMappingList = new ArrayList<>();

        for (JMappingMapping jMappingMapping : jMapping.getMapping()) {
            //targetTable originTable
            Map<String, String> otTableMapping = new HashMap<>();

            String originTableEn = jMappingMapping.getSrcTableEn();
            String originTableCn =jMappingMapping.getSrcTableCn();

            otTableMapping.put(ttLabelEn, originTableEn);
            otTableMappingList.add(otTableMapping);

            if(!checkOriginTableEnExisted(originTableEn)) {
                throw new ServiceException("OriginTableEn " + originTableEn + " is not found in origin table database.");  //todo
            }

            // originAttr targetAttr originSample
            Map<Map<String, String>, String> otAttrValueMapping = new HashMap<>();
            Map<String, String> otAttrEnMapping = new HashMap<>();

            //originTable originAttr
            Map<String, String> oTableAttrMapping = new HashMap<>();

            for(JMappingMappingProperties jMappingMappingProperties: jMappingMapping.getProperties()) {
                String targetAttrEn = jMappingMappingProperties.getDesColEn();
                String originAttrSample = jMappingMappingProperties.getSrcColExample();
                String originAttrEn = jMappingMappingProperties.getSrcColEn();

                otAttrEnMapping.put(originAttrEn, targetAttrEn);
                otAttrEnMappingList.add(otAttrEnMapping);

                otAttrValueMapping.put(otAttrEnMapping, originAttrSample);
                otAttrValueMappingList.add(otAttrValueMapping);

                oTableAttrMapping.put(originAttrEn, originAttrEn);
                oTableAttrMappingList.add(oTableAttrMapping);
            }
        }

        originAttrManager.addTableIdByTAMappingList(oTableAttrMappingList);

        otTableMappingManager.addOTTableMappingByMappingList(otTableMappingList);

        otAttrMappingManager.addOTAttrMappingValueByMappingList(otAttrValueMappingList);



    }

    public static Boolean checkOriginTableEnExisted(String originTableEn) {
        //todo
        return true;
    }
}


/**
    for (JMappingMapping jMappingMapping : jMappingRelation.getMapping()) {
        logger.info("mapping srcTableEn : " + jMappingMapping.getSrcTableEn());
        logger.info("mapping srcTableCn : " + jMappingMapping.getSrcTableCn());
        for (JMappingMappingProperties jMappingMappingProperties : jMappingMapping.getProperties()) {
        logger.info("mapping properties desColEn :" + jMappingMappingProperties.getDesColEn());
        logger.info("mapping properties srcColExample :" + jMappingMappingProperties.getSrcColExample());
        logger.info("mapping properties srcColEn :" + jMappingMappingProperties.getSrcColEn());
        }
        }

        logger.info("version : " + jMappingRelation.getVersion());
        logger.info("elementType : " + jMappingRelation.getElementType());

        logger.info("label getEn : " + jMappingRelation.getLabel().getEn() );
        logger.info("label getCn : " +  jMappingRelation.getLabel().getCn() );
 **/
