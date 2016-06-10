package scopa.cona.service.load;

import org.apache.log4j.Logger;
import scopa.cona.database.constant.AttrConfName;
import scopa.cona.database.constant.AttrConfNameId;
import scopa.cona.database.constant.EnumBeans;
import scopa.cona.database.manager.TAttrNAttrConfManager;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.model.TargetAttr;
import scopa.cona.database.model.TargetTable;
import scopa.cona.database.util.SpringContextUtil;
import scopa.cona.model.JDictionary;
import scopa.cona.model.JDictionaryProperty;
import scopa.cona.model.JDictionaryType;
import scopa.cona.util.JsonUtil;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panda on 6/9/16.
 */
public class ParseDictJson {
    public static final Logger logger = Logger.getLogger(ParseDictJson.class);

    static TargetTableManager targetTableManager = SpringContextUtil.getApplicationContextFromXml().getBean(EnumBeans.targetTableManager.toString(), TargetTableManager.class);

    static TargetAttrManager targetAttrManager = SpringContextUtil.getApplicationContextFromXml().getBean(EnumBeans.targetAttrManager.toString(), TargetAttrManager.class);

    static TAttrNAttrConfManager tAttrNAttrConfManager = SpringContextUtil.getApplicationContextFromXml().getBean(EnumBeans.tAttrNAttrConfManager.toString(), TAttrNAttrConfManager.class);

    public static void parseEntity(FileReader entityFileReader) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");



        JDictionary jDictionaryEntity = getDictionaryEntityFromJson(entityFileReader);
        fetchDb(jDictionaryEntity);
    }

    public static void parseEvent(FileReader eventFileReader) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        JDictionary jDictionaryEvent = getDictionaryEntityFromJson(eventFileReader);
        fetchDb(jDictionaryEvent);
    }

    public static void parseRelation(FileReader relationshipFileReader) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        JDictionary jDictionaryRelation = getDictionaryEntityFromJson(relationshipFileReader);
        fetchDb(jDictionaryRelation);
    }

    public static JDictionary getDictionaryEntityFromJson(FileReader jsonContent) {
        return JsonUtil.getObjFromFileReader(jsonContent, JDictionary.class);
    }

    public static void fetchDb(JDictionary jDictionary) {
        String ttElementType = jDictionary.getElementType();
        String ttVersion = jDictionary.getVersion();
        String ttLabelEn = jDictionary.getLabel().getEn();
        String ttLabelCn = jDictionary.getLabel().getCn();

        for (JDictionaryType jDictionaryType : jDictionary.getType()) {
            jDictionaryType.getCn();
            jDictionaryType.getEn();  //todo
        }

        TargetTable targetTable = new TargetTable();
        targetTable.setElementType(ttElementType);
        targetTable.setVersion(ttVersion);
        targetTable.setLabelCn(ttLabelCn);
        targetTable.setLabelEn(ttLabelEn);

        targetTableManager.insertTargetTable(targetTable);

        TargetTable insertedTargetTable = targetTableManager.getTargetTableByLabelEnElemTypeVersion(
                                                                    ttLabelEn, ttElementType, ttVersion);

        Integer taTargetTableId = insertedTargetTable.getTargetTableId();

        List<Map<Integer, Map<Integer, Object>>> attrConfList = new ArrayList<>();

        for (JDictionaryProperty jDictionaryProperty : jDictionary.getProperty()) {
            TargetAttr targetAttr = new TargetAttr();
            String taAttrNameCn = jDictionaryProperty.getCn();
            String taAttrNameEn = jDictionaryProperty.getEn();
            String taDataType = jDictionaryProperty.getDataType();
            targetAttr.setAttrNameCn(taAttrNameCn);
            targetAttr.setAttrNameEn(taAttrNameEn);
            targetAttr.setColumnType(taDataType);
            targetAttr.setTargetTableId(taTargetTableId);

            targetAttrManager.insertTargetAttr(targetAttr);

            TargetAttr insertedTargetAttr = targetAttrManager.getTargetAttrByTableIdAndAttrNameEn(taTargetTableId, taAttrNameEn);

            HashMap<Integer, Map<Integer, Object>> acAttrConfMap = new HashMap<>();

            Map<Integer, Object> attrConfValueMap = new HashMap<>();
            attrConfValueMap.put(AttrConfNameId.primaryName.toInt(), jDictionaryProperty.getPrimaryType());
            attrConfValueMap.put(AttrConfNameId.searchType.toInt(), jDictionaryProperty.getSearchType());
            attrConfValueMap.put(AttrConfNameId.isUniqueKey.toInt(), jDictionaryProperty.getIsUniqueKey());
            attrConfValueMap.put(AttrConfNameId.des.toInt(), jDictionaryProperty.getDes());
            attrConfValueMap.put(AttrConfNameId.primary.toInt(), jDictionaryProperty.getPrimary());
            attrConfValueMap.put(AttrConfNameId.isLongString.toInt(), jDictionaryProperty.getIsLongString());
            attrConfValueMap.put(AttrConfNameId.isCommonKey.toInt(), jDictionaryProperty.getIsCommonKey());
            attrConfValueMap.put(AttrConfNameId.primaryName.toInt(), jDictionaryProperty.getPrimaryName());
            attrConfValueMap.put(AttrConfNameId.offset.toInt(), jDictionaryProperty.getOffset());
            attrConfValueMap.put(AttrConfNameId.timeFormat.toInt(), jDictionaryProperty.getTimeFormat());
            attrConfValueMap.put(AttrConfNameId.isSearchKey.toInt(), jDictionaryProperty.getIsSearchKey());
            attrConfValueMap.put(AttrConfNameId.isPrimary.toInt(), jDictionaryProperty.getIsPrimary());
            attrConfValueMap.put(AttrConfNameId.reference.toInt(), jDictionaryProperty.getReference());

            acAttrConfMap.put(insertedTargetAttr.getTargetAttrId(), attrConfValueMap);
            attrConfList.add(acAttrConfMap);
        }

        tAttrNAttrConfManager.addBatchAttrConfValueByTAttrIdAndAttrConfValueMap(attrConfList);

    }
}


/**
        logger.info("jDictionary getElementType===============" + jDictionaryRelation.getElementType());
        for (JDictionaryProperty jDictionaryProperty : jDictionaryRelation.getProperty()) {
            logger.info("*************************" + jDictionaryRelation.getElementType());
            logger.info("property getPrimaryName : " + jDictionaryProperty.getPrimaryName() );
            logger.info("property getEn : " + jDictionaryProperty.getEn() );
            logger.info("property getCn : " + jDictionaryProperty.getCn() );
            logger.info("property getSearchType : " + jDictionaryProperty.getSearchType() );
            logger.info("property getDataType : " + jDictionaryProperty.getDataType() );
            logger.info("property getIsUniqueKey : " + jDictionaryProperty.getIsUniqueKey() );
            logger.info("property getDes : " + jDictionaryProperty.getDes() );
            logger.info("property getPrimary : " + jDictionaryProperty.getPrimary() );
            logger.info("property getIsLongString : " + jDictionaryProperty.getIsLongString() );
            logger.info("property getIsCommonKey : " + jDictionaryProperty.getIsCommonKey() );
            logger.info("property getPrimaryName : " + jDictionaryProperty.getPrimaryName() );
            logger.info("property getOffset : " + jDictionaryProperty.getOffset() );
            logger.info("property getTimeFormat : " + jDictionaryProperty.getTimeFormat() );
            logger.info("property getIsSearchKey : " + jDictionaryProperty.getIsSearchKey() );
            logger.info("property getIsPrimary : " + jDictionaryProperty.getIsPrimary() );
            logger.info("property getReference : " + jDictionaryProperty.getReference() );
        }

        for (JDictionaryType jDictionaryType : jDictionaryRelation.getType()) {
            logger.info("type getEn" + jDictionaryType.getEn() );
            logger.info("type getCn" + jDictionaryType.getCn() );
        }

        logger.info("version" + jDictionaryRelation.getVersion());

        logger.info("label getEn" + jDictionaryRelation.getLabel().getEn() );
        logger.info("label getCn" +  jDictionaryRelation.getLabel().getCn() );

 **/