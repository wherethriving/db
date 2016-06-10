package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.RuleDefManager;
import scopa.cona.database.mappers.RuleDefMapper;
import scopa.cona.database.model.RuleDef;

/**
 * Created by panda on 5/10/16.
 */

@Service("ruleDefManager")
public class RuleDefManagerImpl implements RuleDefManager {

    public static final Logger logger = Logger.getLogger(RuleDefManagerImpl.class);

    @Autowired
    private RuleDefMapper ruleDefMapper;

    @Override
    public RuleDef selectRuleDefById(int ruleDefId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == ruleDefId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDefId");
            throw new IllegalArgumentException("failed to input ruleDefId");
        }

        RuleDef ruleDef = ruleDefMapper.selectRuleDefById(ruleDefId);

        if (null == ruleDef)
            throw DbException.ENTITY_IS_NOT_FOUND("ruleDef");

        return ruleDef;
    }

    @Override
    public void insertRuleDef(RuleDef ruleDef) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDef) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDef");
            throw new IllegalArgumentException("failed to input ruleDef");
        }

        ruleDefMapper.insertRuleDef(ruleDef);
    }

    @Override
    public void updateRuleDef(RuleDef ruleDef) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDef) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDef");
            throw new IllegalArgumentException("failed to input ruleDef");
        }

        ruleDefMapper.updateRuleDef(ruleDef);
    }

    @Override
    public void deleteRuleDef(int ruleDefId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == ruleDefId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDefId");
            throw new IllegalArgumentException("failed to input ruleDefId");
        }

        ruleDefMapper.deleteRuleDef(ruleDefId);
    }
}
