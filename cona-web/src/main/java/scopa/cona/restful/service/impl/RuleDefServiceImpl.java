package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.RuleDefManager;
import scopa.cona.database.model.RuleDef;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.RuleDefService;

import javax.ws.rs.core.Response;

@Service("ruleDefServices")
public class RuleDefServiceImpl implements RuleDefService {

    public static final Logger logger = Logger.getLogger(RuleDefServiceImpl.class);

    @Autowired(required=false)
    private RuleDefManager RuleDefManager;


    @Override
    public Response getRuleDefyId(Integer ruleDefId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDefId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDefId");
            throw ServiceException.NO_INPUT("ruleDefId");
        }

        RuleDef ruleDef = null;
        try {
            ruleDef = RuleDefManager.selectRuleDefById(ruleDefId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("ruleDef");
        }

        return Response.ok().entity(ruleDef).build();
    }

    @Override
    public void addRuleDef(RuleDef ruleDef) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDef) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input RuleDef");
            throw ServiceException.NO_INPUT("RuleDef");
        }

        RuleDefManager.insertRuleDef(ruleDef);
    }

    @Override
    public void updateRuleDef(RuleDef ruleDef) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDef) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input RuleDef");
            throw ServiceException.NO_INPUT("RuleDef");
        }

        RuleDefManager.updateRuleDef(ruleDef);
    }

    @Override
    public void deleteRuleDef(Integer ruleDefId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleDefId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleDefId");
            throw ServiceException.NO_INPUT("ruleDefId");
        }

        RuleDefManager.deleteRuleDef(ruleDefId);
    }
}