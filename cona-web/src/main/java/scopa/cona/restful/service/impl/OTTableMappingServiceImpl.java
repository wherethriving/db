package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OTTableMappingManager;
import scopa.cona.database.model.OTTableMapping;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.OTTableMappingService;

import javax.ws.rs.core.Response;

@Service("otTableMappingServices")
public class OTTableMappingServiceImpl implements OTTableMappingService {

    public static final Logger logger = Logger.getLogger(OTTableMappingServiceImpl.class);

    @Autowired(required=false)
    private OTTableMappingManager OTTableMappingManager;


    @Override
    public Response getOTTableMappingById(Integer otTableMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMappingId");
            throw ServiceException.NO_INPUT("otTableMappingId");
        }

        OTTableMapping otTableMapping = null;

        try {
            otTableMapping = OTTableMappingManager.selectOTTableMappingById(otTableMappingId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("otTableMapping");
        }

        return Response.ok().entity(otTableMapping).build();
    }

    @Override
    public void addOTTableMapping(OTTableMapping otTableMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OTTableMapping");
            throw ServiceException.NO_INPUT("OTTableMapping");
        }

        OTTableMappingManager.insertOTTableMapping(otTableMapping);
    }

    @Override
    public void updateOTTableMapping(OTTableMapping otTableMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OTTableMapping");
            throw ServiceException.NO_INPUT("OTTableMapping");
        }

        OTTableMappingManager.updateOTTableMapping(otTableMapping);
    }

    @Override
    public void deleteOTTableMapping(Integer otTableMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMappingId");
            throw ServiceException.NO_INPUT("otTableMappingId");
        }

        OTTableMappingManager.deleteOTTableMapping(otTableMappingId);
    }
}