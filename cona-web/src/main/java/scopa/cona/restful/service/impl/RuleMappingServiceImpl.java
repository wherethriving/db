package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.RuleMappingManager;
import scopa.cona.database.model.RuleMapping;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.RuleMappingService;

import javax.ws.rs.core.Response;

@Service("ruleMappingServices")
public class RuleMappingServiceImpl implements RuleMappingService {

    public static final Logger logger = Logger.getLogger(RuleMappingServiceImpl.class);

    @Autowired(required=false)
    private RuleMappingManager RuleMappingManager;


    @Override
    public Response getRuleMappingById(Integer ruleMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMappingId");
            throw ServiceException.NO_INPUT("ruleMappingId");
        }

        RuleMapping ruleMapping = null;
        try {
            ruleMapping = RuleMappingManager.selectRuleMappingById(ruleMappingId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("ruleMapping");
        }

        return Response.ok().entity(ruleMapping).build();
    }

    @Override
    public void addRuleMapping(RuleMapping ruleMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input RuleMapping");
            throw ServiceException.NO_INPUT("RuleMapping");
        }

        RuleMappingManager.insertRuleMapping(ruleMapping);
    }

    @Override
    public void updateRuleMapping(RuleMapping ruleMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input RuleMapping");
            throw ServiceException.NO_INPUT("RuleMapping");
        }

        RuleMappingManager.updateRuleMapping(ruleMapping);
    }

    @Override
    public void deleteRuleMapping(Integer ruleMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == ruleMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input ruleMappingId");
            throw ServiceException.NO_INPUT("ruleMappingId");
        }

        RuleMappingManager.deleteRuleMapping(ruleMappingId);
    }
}