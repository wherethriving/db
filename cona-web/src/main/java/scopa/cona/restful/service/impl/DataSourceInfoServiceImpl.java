package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataSourceInfoManager;
import scopa.cona.database.model.DataSourceInfo;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.DataSourceInfoService;

import javax.ws.rs.core.Response;

@Service("dataSourceInfoServices")
public class DataSourceInfoServiceImpl implements DataSourceInfoService {

    public static final Logger logger = Logger.getLogger(DataSourceInfoServiceImpl.class);

    @Autowired(required=false)
    private DataSourceInfoManager DataSourceInfoManager;


    @Override
    public Response getDataSourceInfoById(Integer dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw ServiceException.NO_INPUT("dataSourceInfoId");
        }

        DataSourceInfo dataSourceInfo = null;

        try {
            dataSourceInfo = DataSourceInfoManager.
                    selectDataSourceInfoById(dataSourceInfoId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("dataSourceInfo");
        }

        return Response.ok().entity(dataSourceInfo).build();
    }

    @Override
    public void addDataSourceInfo(DataSourceInfo dataSourceInfo) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfo) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataSourceInfo");
            throw ServiceException.NO_INPUT("DataSourceInfo");
        }

        DataSourceInfoManager.insertDataSourceInfo(dataSourceInfo);
    }

    @Override
    public void updateDataSourceInfo(DataSourceInfo dataSourceInfo) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfo) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataSourceInfo");
            throw ServiceException.NO_INPUT("DataSourceInfo");
        }

        DataSourceInfoManager.updateDataSourceInfo(dataSourceInfo);
    }

    @Override
    public void deleteDataSourceInfo(Integer dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw ServiceException.NO_INPUT("dataSourceInfoId");
        }

        DataSourceInfoManager.deleteDataSourceInfo(dataSourceInfoId);
    }
}