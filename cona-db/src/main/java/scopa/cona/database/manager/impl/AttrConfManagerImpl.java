package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.AttrConfManager;
import scopa.cona.database.mappers.AttrConfMapper;
import scopa.cona.database.model.AttrConf;

/**
 * Created by panda on 5/10/16.
 */

@Service("attrConfManager")
public class AttrConfManagerImpl implements AttrConfManager {

    public static final Logger logger = Logger.getLogger(AttrConfManagerImpl.class);

    @Autowired
    private AttrConfMapper attrConfMapper;

    @Override
    public AttrConf selectAttrConfById(int attrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == attrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConfId");
            throw new IllegalArgumentException("failed to input attrConfId");
        }

        AttrConf attrConf = attrConfMapper.selectAttrConfById(attrConfId);

        if (null == attrConf)
            throw DbException.ENTITY_IS_NOT_FOUND("attrConf");

        return attrConf;
    }

    @Override
    public void insertAttrConf(AttrConf attrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConf");
            throw new IllegalArgumentException("failed to input attrConf");
        }

        attrConfMapper.insertAttrConf(attrConf);
    }

    @Override
    public void updateAttrConf(AttrConf attrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConf) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConf");
            throw new IllegalArgumentException("failed to input attrConf");
        }

        attrConfMapper.updateAttrConf(attrConf);
    }

    @Override
    public void deleteAttrConf(int attrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == attrConfId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input attrConfId");
            throw new IllegalArgumentException("failed to input attrConfId");
        }

        attrConfMapper.deleteAttrConf(attrConfId);
    }
}
