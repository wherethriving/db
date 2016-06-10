package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.ConfDictElementManager;
import scopa.cona.database.mappers.ConfDictElementMapper;
import scopa.cona.database.model.ConfDictElement;

/**
 * Created by panda on 5/10/16.
 */

@Service("confDictElementManager")
public class ConfDictElementManagerImpl implements ConfDictElementManager {

    public static final Logger logger = Logger.getLogger(ConfDictElementManagerImpl.class);

    @Autowired
    private ConfDictElementMapper confDictElementMapper;

    @Override
    public ConfDictElement selectConfDictElementById(int confDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == confDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElementId");
            throw new IllegalArgumentException("failed to input confDictElementId");
        }

        ConfDictElement confDictElement = confDictElementMapper.selectConfDictElementById(confDictElementId);

        if (null == confDictElement)
            throw DbException.ENTITY_IS_NOT_FOUND("confDictElement");

        return confDictElement;
    }

    @Override
    public void insertConfDictElement(ConfDictElement confDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElement");
            throw new IllegalArgumentException("failed to input confDictElement");
        }

        confDictElementMapper.insertConfDictElement(confDictElement);
    }

    @Override
    public void updateConfDictElement(ConfDictElement confDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == confDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElement");
            throw new IllegalArgumentException("failed to input confDictElement");
        }

        confDictElementMapper.updateConfDictElement(confDictElement);
    }

    @Override
    public void deleteConfDictElement(int confDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == confDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input confDictElementId");
            throw new IllegalArgumentException("failed to input confDictElementId");
        }

        confDictElementMapper.deleteConfDictElement(confDictElementId);
    }
}
