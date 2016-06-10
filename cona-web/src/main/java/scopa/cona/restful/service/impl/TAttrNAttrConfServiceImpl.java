package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TAttrNAttrConfManager;
import scopa.cona.database.model.TAttrNAttrConf;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.TAttrNAttrConfService;

import javax.ws.rs.core.Response;

@Service("tAttrNAttrConfServices")
public class TAttrNAttrConfServiceImpl implements TAttrNAttrConfService {

    public static final Logger logger = Logger.getLogger(TAttrNAttrConfServiceImpl.class);

    @Autowired(required=false)
    private TAttrNAttrConfManager TAttrNAttrConfManager;


    @Override
    public Response getTAttrNAttrConfById(Integer tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == tAttrNAttrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input tAttrNAttrConfId");
            throw ServiceException.NO_INPUT("tAttrNAttrConfId");
        }

        TAttrNAttrConf tAttrNAttrConf = null;
        try {
            tAttrNAttrConf = TAttrNAttrConfManager.
                    selectTAttrNAttrConfById(tAttrNAttrConfId);
        } catch (DbException ex) {
            throw ServiceException.ENTITY_IS_NOT_FOUND("tAttrNAttrConf");
        }

        return Response.ok().entity(tAttrNAttrConf).build();
    }

    @Override
    public void addTAttrNAttrConf(TAttrNAttrConf tAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == tAttrNAttrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input tAttrNAttrConf");
            throw ServiceException.NO_INPUT("tAttrNAttrConf");
        }

        TAttrNAttrConfManager.insertTAttrNAttrConf(tAttrNAttrConf);
    }

    @Override
    public void updateTAttrNAttrConf(TAttrNAttrConf tAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == tAttrNAttrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input tAttrNAttrConf");
            throw ServiceException.NO_INPUT("tAttrNAttrConf");
        }

        TAttrNAttrConfManager.updateTAttrNAttrConf(tAttrNAttrConf);
    }

    @Override
    public void deleteTAttrNAttrConf(Integer tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == tAttrNAttrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input tAttrNAttrConfId");
            throw ServiceException.NO_INPUT("tAttrNAttrConfId");
        }

        TAttrNAttrConfManager.deleteTAttrNAttrConf(tAttrNAttrConfId);
    }
}