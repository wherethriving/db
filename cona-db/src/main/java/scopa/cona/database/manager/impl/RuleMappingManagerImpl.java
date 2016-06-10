package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OTAttrMappingManager;
import scopa.cona.database.manager.RuleDefManager;
import scopa.cona.database.manager.RuleMappingManager;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.mappers.RuleMappingMapper;
import scopa.cona.database.mappers.TargetTableMapper;
import scopa.cona.database.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */

@Service("ruleMappingManager")
public class RuleMappingManagerImpl implements RuleMappingManager {

    public static final Logger logger = Logger.getLogger(RuleMappingManagerImpl.class);

    @Autowired
    private RuleMappingMapper ruleMappingMapper;

    @Autowired
    private TargetTableMapper targetTableMapper;

    @Autowired
    private TargetAttrManager TargetAttrManager;

    @Autowired
    private OTAttrMappingManager OTAttrMappingManager;

    @Autowired
    private RuleDefManager RuleDefManager;

    @Override
    public RuleMapping selectRuleMappingById(int ruleMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == ruleMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMappingId");
            throw new IllegalArgumentException("failed to input ruleMappingId");
        }

        RuleMapping ruleMapping = ruleMappingMapper.selectRuleMappingById(ruleMappingId);

        if (null == ruleMapping)
            throw DbException.ENTITY_IS_NOT_FOUND("ruleMapping");

        return ruleMapping;
    }

    @Override
    public void insertRuleMapping(RuleMapping ruleMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMapping");
            throw new IllegalArgumentException("failed to input ruleMapping");
        }

        ruleMappingMapper.insertRuleMapping(ruleMapping);
    }

    @Override
    public void updateRuleMapping(RuleMapping ruleMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMapping");
            throw new IllegalArgumentException("failed to input ruleMapping");
        }

        ruleMappingMapper.updateRuleMapping(ruleMapping);
    }

    @Override
    public void deleteRuleMapping(int ruleMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == ruleMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMappingId");
            throw new IllegalArgumentException("failed to input ruleMappingId");
        }

        ruleMappingMapper.deleteRuleMapping(ruleMappingId);
    }

    @Override
    public Map<String, RuleAttrMapping> getRuleEntityByTargetTableId(Integer targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTableId");
            throw new IllegalArgumentException("failed to input targetTableId");
        }

        OriginAttr originAttr = new OriginAttr();
        RuleAttrMapping ruleAttrMapping = new RuleAttrMapping();
        Map<String, RuleAttrMapping> ruleEntityMapping = new HashMap<>();
        List<Integer> targetAttrIds = new ArrayList<>();
        List<Integer> attrMappingIds = new ArrayList<>();

        TargetTable targetTable = targetTableMapper.selectTargetTableById(targetTableId);
        String labelen = targetTable.getLabelEn();

        List<TargetAttr> selectedTargetAttr = TargetAttrManager.getTargetAttrByTargetTableId(targetTableId);

        for (TargetAttr targetAttr : selectedTargetAttr) {
            targetAttrIds.add(targetAttr.getTargetAttrId());
        }

        List<OTAttrMapping> otAttrMappingIds = OTAttrMappingManager.getOTAttrMappingByTAttrId(targetAttrIds);

        for (OTAttrMapping otAttrMapping : otAttrMappingIds) {
            attrMappingIds.add(otAttrMapping.getAttrMappingId());
        }

        List<RuleMapping> ruleMappingList = getRuleMappingByAttrMappingId(attrMappingIds);
        List<RuleEntity> ruleEntities = convertRuleMappingToRuleEntity(ruleMappingList);

        ruleAttrMapping.setRuleEntityList(ruleEntities);
        ruleAttrMapping.setOriginAttr(originAttr);  //todo

        ruleEntityMapping.put(labelen, ruleAttrMapping);

        return ruleEntityMapping;
    }

    @Override
    public List<RuleMapping> getRuleMappingByAttrMappingId(List<Integer> attrMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrMappingId");
            throw new IllegalArgumentException("failed to input attrMappingId");
        }

        return ruleMappingMapper.selectRuleMappingByAttrMappingId(attrMappingId);
    }

    @Override
    public List<RuleEntity> convertRuleMappingToRuleEntity(List<RuleMapping> ruleMappingList) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMappingList) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMappingList");
            throw new IllegalArgumentException("failed to input ruleMappingList");
        }

        List<RuleEntity> ruleEntities = new ArrayList<>();

        for (RuleMapping ruleMapping : ruleMappingList) {
            RuleEntity ruleEntity = new RuleEntity();
            RuleDef ruleDef = RuleDefManager.selectRuleDefById(ruleMapping.getRuleDefId());
            ruleEntity.setRuleDef(ruleDef);
            ruleEntity.setRuleMapping(ruleMapping);
            ruleEntities.add(ruleEntity);
        }

        return ruleEntities;
    }

}
