package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.ConfDictElementManager;
import scopa.cona.database.model.ConfDictElement;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.ConfDictElementService;

import javax.ws.rs.core.Response;

@Service("confDictElementServices")
public class ConfDictElementServiceImpl implements ConfDictElementService {

    public static final Logger logger = Logger.getLogger(ConfDictElementServiceImpl.class);

    @Autowired(required=false)
    private ConfDictElementManager ConfDictElementManager;


    @Override
    public Response getConfDictElementById(Integer confDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElementId");
            throw ServiceException.NO_INPUT("confDictElementId");
        }


        ConfDictElement confDictElement = null;
        try {
            confDictElement = ConfDictElementManager.selectConfDictElementById(
                    confDictElementId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("confDictElement");
        }

        return Response.ok().entity(confDictElement).build();
    }

    @Override
    public void addConfDictElement(ConfDictElement confDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input confDictElement");
            throw ServiceException.NO_INPUT("confDictElement");
        }

        ConfDictElementManager.insertConfDictElement(confDictElement);
    }

    @Override
    public void updateConfDictElement(ConfDictElement confDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input confDictElement");
            throw ServiceException.NO_INPUT("confDictElement");
        }

        ConfDictElementManager.updateConfDictElement(confDictElement);
    }

    @Override
    public void deleteConfDictElement(Integer confDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElementId");
            throw ServiceException.NO_INPUT("confDictElementId");
        }

        ConfDictElementManager.deleteConfDictElement(confDictElementId);
    }
}