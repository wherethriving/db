package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataDictElementManager;
import scopa.cona.database.mappers.DataDictElementMapper;
import scopa.cona.database.model.DataDictElement;

/**
 * Created by panda on 5/10/16.
 */

@Service("dataDictElementManager")
public class DataDictElementManagerImpl implements DataDictElementManager {

    public static final Logger logger = Logger.getLogger(DataDictElementManagerImpl.class);

    @Autowired
    private DataDictElementMapper dataDictElementMapper;

    @Override
    public DataDictElement selectDataDictElementfById(int dataDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElementId");
            throw new IllegalArgumentException("failed to input dataDictElementId");
        }

        DataDictElement dataDictElement = dataDictElementMapper.selectDataDictElementfById(dataDictElementId);

        if (null == dataDictElement)
            throw DbException.ENTITY_IS_NOT_FOUND("dataDictElement");

        return dataDictElement;
    }

    @Override
    public void insertDataDictElement(DataDictElement dataDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElement");
            throw new IllegalArgumentException("failed to input dataDictElement");
        }

        dataDictElementMapper.insertDataDictElement(dataDictElement);
    }

    @Override
    public void updateDataDictElement(DataDictElement dataDictElement) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDictElement) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElement");
            throw new IllegalArgumentException("failed to input dataDictElement");
        }

        dataDictElementMapper.updateDataDictElement(dataDictElement);
    }

    @Override
    public void deleteDataDictElement(int dataDictElementId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataDictElementId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictElementId");
            throw new IllegalArgumentException("failed to input dataDictElementId");
        }

        dataDictElementMapper.deleteDataDictElement(dataDictElementId);
    }
}
