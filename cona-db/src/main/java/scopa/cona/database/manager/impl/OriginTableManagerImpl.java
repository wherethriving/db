package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OriginTableManager;
import scopa.cona.database.mappers.OriginTableMapper;
import scopa.cona.database.model.OriginTable;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */

@Service("originTableManager")
public class OriginTableManagerImpl implements OriginTableManager {

    public static final Logger logger = Logger.getLogger(OriginTableManagerImpl.class);

    @Autowired
    private OriginTableMapper originTableMapper;

    @Override
    public void insertOriginTable(OriginTable originTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTable");
            throw new IllegalArgumentException("failed to input originTable");
        }

        originTableMapper.insertOriginTable(originTable);
    }

    @Override
    public void updateOriginTable(OriginTable originTable) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTable) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTable");
            throw new IllegalArgumentException("failed to input originTable");
        }

        originTableMapper.updateOriginTable(originTable);
    }

    @Override
    public void deleteOriginTable(int originTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == originTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTableId");
            throw new IllegalArgumentException("failed to input originTableId");
        }

        originTableMapper.deleteOriginTable(originTableId);
    }

    @Override
    public List<OriginTable> getOriginTableByDataSourceInfoId(Integer dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw new IllegalArgumentException("failed to input dataSourceInfoId");
        }

        List<OriginTable> originTableList = originTableMapper.selectOTableByDSInfoId(dataSourceInfoId);

        if (null == originTableList)
            throw DbException.ENTITY_IS_NOT_FOUND("originTableList");

        return originTableList;
    }

    @Override
    public OriginTable selectOriginTableById(int originTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == originTableId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTableId");
            throw new IllegalArgumentException("failed to input originTableId");
        }

        OriginTable originTable = originTableMapper.selectOriginTableById(originTableId);

        if (null == originTable)
            throw DbException.ENTITY_IS_NOT_FOUND("originTable");

        return originTable;
    }

    @Override
    public OriginTable selectOriginTableByName(String originTableName) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originTableName) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originTableName");
            throw new IllegalArgumentException("failed to input originTableName");
        }

        OriginTable originTable = originTableMapper.selectOriginTableByName(originTableName);

        if (null == originTable)
            throw DbException.ENTITY_IS_NOT_FOUND("originTable");

        return originTable;
    }


}
