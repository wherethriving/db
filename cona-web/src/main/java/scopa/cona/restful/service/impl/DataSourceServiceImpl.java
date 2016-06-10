package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataSourceManager;
import scopa.cona.database.model.DataSource;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.DataSourceService;

import javax.ws.rs.core.Response;

@Service("dataSourceServices")
public class DataSourceServiceImpl implements DataSourceService {

    public static final Logger logger = Logger.getLogger(DataSourceServiceImpl.class);

    @Autowired(required=false)
    private DataSourceManager DataSourceManager;


    @Override
    public Response getDataSourceById(Integer dataSourceId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceId");
            throw ServiceException.NO_INPUT("dataSourceId");
        }

        DataSource dataSource = null;
        try {
            dataSource  = DataSourceManager.selectDataSourceById(dataSourceId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("dataSource");
        }

        return Response.ok().entity(dataSource).build();
    }

    @Override
    public void addDataSource(DataSource dataSource) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSource) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataSource");
            throw ServiceException.NO_INPUT("DataSource");
        }

        DataSourceManager.insertDataSource(dataSource);
    }

    @Override
    public void updateDataSource(DataSource dataSource) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSource) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataSource");
            throw ServiceException.NO_INPUT("DataSource");
        }

        DataSourceManager.updateDataSource(dataSource);
    }

    @Override
    public void deleteDataSource(Integer dataSourceId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceId");
            throw ServiceException.NO_INPUT("dataSourceId");
        }

        DataSourceManager.deleteDataSource(dataSourceId);
    }
}