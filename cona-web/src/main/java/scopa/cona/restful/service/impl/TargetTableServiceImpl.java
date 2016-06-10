package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.model.TargetTable;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.TargetTableService;

import javax.ws.rs.core.Response;

@Service("targetTableServices")
public class TargetTableServiceImpl implements TargetTableService {

    public static final Logger logger = Logger.getLogger(TargetTableServiceImpl.class);

    @Autowired(required=false)
    private TargetTableManager TargetTableManager;


    @Override
    public Response getTargetTableById(Integer targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTableId");
            throw ServiceException.NO_INPUT("targetTableId");
        }

        TargetTable targetTable = null;
        try {
            targetTable = TargetTableManager.selectTargetTableById(targetTableId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("targetTable");
        }

        return Response.ok().entity(targetTable).build();
    }

    @Override
    public void addTargetTable(TargetTable targetTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input TargetTable");
            throw ServiceException.NO_INPUT("TargetTable");
        }

        TargetTableManager.insertTargetTable(targetTable);
    }

    @Override
    public void updateTargetTable(TargetTable targetTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input TargetTable");
            throw ServiceException.NO_INPUT("TargetTable");
        }

        TargetTableManager.updateTargetTable(targetTable);
    }

    @Override
    public void deleteTargetTable(Integer targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetTableId");
            throw ServiceException.NO_INPUT("targetTableId");
        }

        TargetTableManager.deleteTargetTable(targetTableId);
    }
}