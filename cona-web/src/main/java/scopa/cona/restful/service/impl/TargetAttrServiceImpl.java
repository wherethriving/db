package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.model.TargetAttr;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.TargetAttrService;

import javax.ws.rs.core.Response;

@Service("targetAttrServices")
public class TargetAttrServiceImpl implements TargetAttrService {

    public static final Logger logger = Logger.getLogger(TargetAttrServiceImpl.class);

    @Autowired(required=false)
    private TargetAttrManager TargetAttrManager;


    @Override
    public Response getTargetAttrById(Integer targetAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetAttrId");
            throw ServiceException.NO_INPUT("targetAttrId");
        }

        TargetAttr targetAttr = null;

        try {
            targetAttr = TargetAttrManager.selectTargetAttrById(targetAttrId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("targetAttr");
        }

        return Response.ok().entity(targetAttr).build();
    }

    @Override
    public void addTargetAttr(TargetAttr targetAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input TargetAttr");
            throw ServiceException.NO_INPUT("TargetAttr");
        }

        TargetAttrManager.insertTargetAttr(targetAttr);
    }

    @Override
    public void updateTargetAttr(TargetAttr targetAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input TargetAttr");
            throw ServiceException.NO_INPUT("TargetAttr");
        }

        TargetAttrManager.updateTargetAttr(targetAttr);
    }

    @Override
    public void deleteTargetAttr(Integer targetAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetAttrId");
            throw ServiceException.NO_INPUT("targetAttrId");
        }

        TargetAttrManager.deleteTargetAttr(targetAttrId);
    }
}