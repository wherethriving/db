package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OriginTableManager;
import scopa.cona.database.model.OriginTable;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.OriginTableService;

import javax.ws.rs.core.Response;

@Service("originTableServices")
public class OriginTableServiceImpl implements OriginTableService {

    public static final Logger logger = Logger.getLogger(OriginTableServiceImpl.class);

    @Autowired(required=false)
    private OriginTableManager OriginTableManager;


    @Override
    public Response getOriginTableById(Integer originTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTableId");
            throw ServiceException.NO_INPUT("originTableId");
        }

        OriginTable originTable = null;
        try {
            originTable = OriginTableManager.selectOriginTableById(originTableId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("originTable");
        }

        return Response.ok().entity(originTable).build();
    }

    @Override
    public void addOriginTable(OriginTable originTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OriginTable");
            throw ServiceException.NO_INPUT("OriginTable");
        }

        OriginTableManager.insertOriginTable(originTable);
    }

    @Override
    public void updateOriginTable(OriginTable originTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input OriginTable");
            throw ServiceException.NO_INPUT("OriginTable");
        }

        OriginTableManager.updateOriginTable(originTable);
    }

    @Override
    public void deleteOriginTable(Integer originTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTableId");
            throw ServiceException.NO_INPUT("originTableId");
        }

        OriginTableManager.deleteOriginTable(originTableId);
    }
}