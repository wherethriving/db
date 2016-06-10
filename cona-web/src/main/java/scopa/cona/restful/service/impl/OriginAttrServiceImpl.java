package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OriginAttrManager;
import scopa.cona.database.model.OriginAttr;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.OriginAttrService;

import javax.ws.rs.core.Response;

@Service("originAttrServices")
public class OriginAttrServiceImpl implements OriginAttrService {

    public static final Logger logger = Logger.getLogger(OriginAttrServiceImpl.class);

    @Autowired(required=false)
    private OriginAttrManager OriginAttrManager;


    @Override
    public Response getOriginAttrById(Integer originAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrId");
            throw ServiceException.NO_INPUT("originAttrId");
        }

        OriginAttr originAttr = null;
        try {
            originAttr = OriginAttrManager.selectOriginAttrById(originAttrId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("originAttr");
        }

        return Response.ok().entity(originAttr).build();
    }

    @Override
    public void addOriginAttr(OriginAttr originAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OriginAttr");
            throw ServiceException.NO_INPUT("OriginAttr");
        }

        OriginAttrManager.insertOriginAttr(originAttr);
    }

    @Override
    public void updateOriginAttr(OriginAttr originAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OriginAttr");
            throw ServiceException.NO_INPUT("OriginAttr");
        }

        OriginAttrManager.updateOriginAttr(originAttr);
    }

    @Override
    public void deleteOriginAttr(Integer originAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrId");
            throw ServiceException.NO_INPUT("originAttrId");
        }

        OriginAttrManager.deleteOriginAttr(originAttrId);
    }
}