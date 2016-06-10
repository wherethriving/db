package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataSourceManager;
import scopa.cona.database.mappers.DataSourceMapper;
import scopa.cona.database.model.DataSource;

/**
 * Created by panda on 5/10/16.
 */

@Service("dataSourceManager")
public class DataSourceManagerImpl implements DataSourceManager {

    public static final Logger logger = Logger.getLogger(DataSourceManagerImpl.class);

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public DataSource selectDataSourceById(int dataSourceId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataSourceId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceId");
            throw new IllegalArgumentException("failed to input dataSourceId");
        }

        DataSource dataSource = dataSourceMapper.selectDataSourceById(dataSourceId);

        if (null == dataSource)
            throw DbException.ENTITY_IS_NOT_FOUND("dataSource");

        return dataSource;
    }

    @Override
    public void insertDataSource(DataSource dataSource) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSource) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSource");
            throw new IllegalArgumentException("failed to input dataSource");
        }

        dataSourceMapper.insertDataSource(dataSource);
    }

    @Override
    public void updateDataSource(DataSource dataSource) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSource) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSource");
            throw new IllegalArgumentException("failed to input dataSource");
        }

        dataSourceMapper.updateDataSource(dataSource);
    }

    @Override
    public void deleteDataSource(int dataSourceId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataSourceId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceId");
            throw new IllegalArgumentException("failed to input dataSourceId");
        }

        dataSourceMapper.deleteDataSource(dataSourceId);
    }
}
