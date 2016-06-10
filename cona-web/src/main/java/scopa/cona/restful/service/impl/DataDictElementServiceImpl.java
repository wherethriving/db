package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataDictElementManager;
import scopa.cona.database.model.DataDictElement;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.DataDictElementService;

import javax.ws.rs.core.Response;

@Service("dataDictElementServices")
public class DataDictElementServiceImpl implements DataDictElementService {

    public static final Logger logger = Logger.getLogger(DataDictElementServiceImpl.class);

    @Autowired(required=false)
    private DataDictElementManager DataDictElementManager;


    @Override
    public Response getDataDictElementById(Integer dataDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElementId");
            throw ServiceException.NO_INPUT("dataDictElementId");
        }

        DataDictElement dataDictElement = null;

        try {
            dataDictElement = DataDictElementManager.
                    selectDataDictElementfById(dataDictElementId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("dataDictElement");
        }

        return Response.ok().entity(dataDictElement).build();
    }

    @Override
    public void addDataDictElement(DataDictElement dataDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataDictElement");
            throw ServiceException.NO_INPUT("DataDictElement");
        }

        DataDictElementManager.insertDataDictElement(dataDictElement);
    }

    @Override
    public void updateDataDictElement(DataDictElement dataDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input DataDictElement");
            throw ServiceException.NO_INPUT("DataDictElement");
        }

        DataDictElementManager.updateDataDictElement(dataDictElement);
    }

    @Override
    public void deleteDataDictElement(Integer dataDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElementId");
            throw ServiceException.NO_INPUT("dataDictElementId");
        }

        DataDictElementManager.deleteDataDictElement(dataDictElementId);
    }
}