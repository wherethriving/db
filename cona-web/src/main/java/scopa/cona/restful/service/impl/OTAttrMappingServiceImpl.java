package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OTAttrMappingManager;
import scopa.cona.database.model.OTAttrMapping;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.OTAttrMappingService;

import javax.ws.rs.core.Response;

@Service("otAttrMappingServices")
public class OTAttrMappingServiceImpl implements OTAttrMappingService {

    public static final Logger logger = Logger.getLogger(OTAttrMappingServiceImpl.class);

    @Autowired(required=false)
    private OTAttrMappingManager OTAttrMappingManager;


    @Override
    public Response getOTAttrMappingById(Integer otAttrMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMappingId");
            throw ServiceException.NO_INPUT("otAttrMappingId");
        }

        OTAttrMapping otAttrMapping = null;

        try {
            otAttrMapping = OTAttrMappingManager.
                    selectOTAttrMappingById(otAttrMappingId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("otAttrMapping");
        }

        return Response.ok().entity(otAttrMapping).build();
    }

    @Override
    public void addOTAttrMapping(OTAttrMapping otAttrMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OTAttrMapping");
            throw ServiceException.NO_INPUT("OTAttrMapping");
        }

        OTAttrMappingManager.insertOTAttrMapping(otAttrMapping);
    }

    @Override
    public void updateOTAttrMapping(OTAttrMapping otAttrMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OTAttrMapping");
            throw ServiceException.NO_INPUT("OTAttrMapping");
        }

        OTAttrMappingManager.updateOTAttrMapping(otAttrMapping);
    }

    @Override
    public void deleteOTAttrMapping(Integer otAttrMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMappingId");
            throw ServiceException.NO_INPUT("otAttrMappingId");
        }

        OTAttrMappingManager.deleteOTAttrMapping(otAttrMappingId);
    }
}