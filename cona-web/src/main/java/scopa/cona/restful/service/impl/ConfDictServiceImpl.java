package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.ConfDictManager;
import scopa.cona.database.model.ConfDict;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.ConfDictService;

import javax.ws.rs.core.Response;

@Service("confDictServices")
public class ConfDictServiceImpl implements ConfDictService {

    public static final Logger logger = Logger.getLogger(ConfDictServiceImpl.class);

    @Autowired(required=false)
    private ConfDictManager ConfDictManager;


    @Override
    public Response getConfDictById(Integer confDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictId");
            throw ServiceException.NO_INPUT("confDictId");
        }

        ConfDict confDict = null;

        try {
            confDict = ConfDictManager.selectConfDictById(confDictId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("confDict");
        }

        return Response.ok().entity(confDict).build();
    }

    @Override
    public void addConfDict(ConfDict confDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input ConfDict");
            throw ServiceException.NO_INPUT("ConfDict");
        }

        ConfDictManager.insertConfDict(confDict);
    }

    @Override
    public void updateConfDict(ConfDict confDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input ConfDict");
            throw ServiceException.NO_INPUT("ConfDict");
        }

        ConfDictManager.updateConfDict(confDict);
    }

    @Override
    public void deleteConfDict(Integer confDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictId");
            throw ServiceException.NO_INPUT("confDictId");
        }

        ConfDictManager.deleteConfDict(confDictId);
    }
}