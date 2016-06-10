package scopa.cona.restful.service.impl;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.AttrConfManager;
import scopa.cona.database.model.AttrConf;
import scopa.cona.exception.ServiceException;
import scopa.cona.restful.service.AttrConfService;
import scopa.cona.util.JsonUtil;

import javax.ws.rs.core.Response;

@Service("attrConfServices")
public class AttrConfServiceImpl implements AttrConfService {

    public static final Logger logger = Logger.getLogger(AttrConfServiceImpl.class);

    @Autowired(required=false)
    private AttrConfManager AttrConfManager;


    @Override
    public Response getAttrConfById(Integer attrConfId) throws JSONException {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConfId");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(ServiceException.NO_INPUT("attrConfId").getMessage())
                    .build();
        }

        AttrConf attrConf = null;
        JSONObject json = new JSONObject();

        try {
            attrConf = AttrConfManager.selectAttrConfById(attrConfId);
        } catch (DbException ex) {
            json.put("message",  ServiceException.ENTITY_IS_NOT_FOUND("attrConf").getMessage());

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(json.toString())
                    .build();
        }

        return Response.ok()
                .entity(attrConf)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }

    @Override
    public void addAttrConf(AttrConf attrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input attrConf");
            throw ServiceException.NO_INPUT("AttrConf");
        }

        AttrConfManager.insertAttrConf(attrConf);
    }

    @Override
    public void updateAttrConf(AttrConf attrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "No input attrConf");
            throw ServiceException.NO_INPUT("AttrConf");
        }

        AttrConfManager.updateAttrConf(attrConf);
    }


    @Override
    public void deleteAttrConf(Integer attrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConfId");
            throw ServiceException.NO_INPUT("attrConfId");
        }

        AttrConfManager.deleteAttrConf(attrConfId);
    }
}