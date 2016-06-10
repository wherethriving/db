package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataDictManager;
import scopa.cona.database.model.DataDict;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.DataDictService;

import javax.ws.rs.core.Response;

@Service("dataDictServices")
public class DataDictServiceImpl implements DataDictService {

    public static final Logger logger = Logger.getLogger(DataDictServiceImpl.class);

    @Autowired(required=false)
    private DataDictManager DataDictManager;


    @Override
    public Response getDataDictById(Integer dataDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConfId");
            throw ServiceException.NO_INPUT("dataDictId");
        }

        DataDict dataDict = null;

        try {
            dataDict = DataDictManager.selectDataDictById(dataDictId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("dataDict");
        }

        return Response.ok().entity(dataDict).build();
    }

    @Override
    public void addDataDict(DataDict dataDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataDict");
            throw ServiceException.NO_INPUT("DataDict");
        }

        DataDictManager.insertDataDict(dataDict);
    }

    @Override
    public void updateDataDict(DataDict dataDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataDict");
            throw ServiceException.NO_INPUT("DataDict");
        }

        DataDictManager.updateDataDict(dataDict);
    }

    @Override
    public void deleteDataDict(Integer dataDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictId");
            throw ServiceException.NO_INPUT("dataDictId");
        }

        DataDictManager.deleteDataDict(dataDictId);
    }
}