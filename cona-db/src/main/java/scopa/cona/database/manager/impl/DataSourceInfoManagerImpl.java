package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataSourceInfoManager;
import scopa.cona.database.mappers.DataSourceInfoMapper;
import scopa.cona.database.model.DataSourceInfo;

/**
 * Created by panda on 5/10/16.
 */

@Service("dataSourceInfoManager")
public class DataSourceInfoManagerImpl implements DataSourceInfoManager {

    public static final Logger logger = Logger.getLogger(DataSourceInfoManagerImpl.class);

    @Autowired
    private DataSourceInfoMapper dataSourceInfoMapper;

    @Override
    public DataSourceInfo selectDataSourceInfoById(int dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw new IllegalArgumentException("failed to input dataSourceInfoId");
        }

        DataSourceInfo dataSourceInfo = dataSourceInfoMapper.selectDataSourceInfoById(dataSourceInfoId);

        if (null == dataSourceInfo)
            throw DbException.ENTITY_IS_NOT_FOUND("dataSourceInfo");

        return dataSourceInfo;
    }

    @Override
    public void insertDataSourceInfo(DataSourceInfo dataSourceInfo) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfo) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfo");
            throw new IllegalArgumentException("failed to input dataSourceInfo");
        }

        dataSourceInfoMapper.insertDataSourceInfo(dataSourceInfo);
    }

    @Override
    public void updateDataSourceInfo(DataSourceInfo dataSourceInfo) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfo) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfo");
            throw new IllegalArgumentException("failed to input dataSourceInfo");
        }

        dataSourceInfoMapper.updateDataSourceInfo(dataSourceInfo);
    }

    @Override
    public void deleteDataSourceInfo(int dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw new IllegalArgumentException("failed to input dataSourceInfoId");
        }

        dataSourceInfoMapper.deleteDataSourceInfo(dataSourceInfoId);
    }

    @Override
    public DataSourceInfo selectDataSourceInfoByUrl(String dataSourceUrl) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceUrl) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceUrl");
            throw new IllegalArgumentException("failed to input dataSourceUrl");
        }

        DataSourceInfo dataSourceInfo = dataSourceInfoMapper.selectDataSourceInfoByUrl(dataSourceUrl);

        if (null == dataSourceInfo)
            throw DbException.ENTITY_IS_NOT_FOUND("dataSourceInfo");

        return dataSourceInfo;
    }
}
