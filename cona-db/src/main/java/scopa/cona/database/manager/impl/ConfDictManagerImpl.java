package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.ConfDictManager;
import scopa.cona.database.mappers.ConfDictMapper;
import scopa.cona.database.model.ConfDict;

/**
 * Created by panda on 5/10/16.
 */

@Service("confDictManager")
public class ConfDictManagerImpl implements ConfDictManager {

    public static final Logger logger = Logger.getLogger(ConfDictManagerImpl.class);

    @Autowired
    private ConfDictMapper confDictMapper;

    @Override
    public ConfDict selectConfDictById(int confDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == confDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictId");
            throw new IllegalArgumentException("failed to input confDictId");
        }

        ConfDict confDict = confDictMapper.selectConfDictById(confDictId);

        if (null == confDict)
            throw DbException.ENTITY_IS_NOT_FOUND("confDict");

        return confDict;
    }

    @Override
    public void insertConfDict(ConfDict confDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDict");
            throw new IllegalArgumentException("failed to input confDict");
        }

        confDictMapper.insertConfDict(confDict);
    }

    @Override
    public void updateConfDict(ConfDict confDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDict");
            throw new IllegalArgumentException("failed to input confDict");
        }

        confDictMapper.updateConfDict(confDict);
    }

    @Override
    public void deleteConfDict(int confDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == confDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictId");
            throw new IllegalArgumentException("failed to input confDictId");
        }

        confDictMapper.deleteConfDict(confDictId);
    }
}
