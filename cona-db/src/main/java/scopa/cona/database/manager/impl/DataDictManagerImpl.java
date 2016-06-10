package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.DataDictManager;
import scopa.cona.database.mappers.DataDictMapper;
import scopa.cona.database.model.DataDict;

/**
 * Created by panda on 5/10/16.
 */

@Service("dataDictManager")
public class DataDictManagerImpl implements DataDictManager {

    public static final Logger logger = Logger.getLogger(DataDictManagerImpl.class);

    @Autowired
    private DataDictMapper dataDictMapper;

    @Override
    public DataDict selectDataDictById(int dataDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictId");
            throw new IllegalArgumentException("failed to input dataDictId");
        }

        DataDict dataDict = dataDictMapper.selectDataDictById(dataDictId);

        if (null == dataDict)
            throw DbException.ENTITY_IS_NOT_FOUND("dataDict");

        return dataDict;
    }

    @Override
    public void insertDataDict(DataDict dataDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictId");
            throw new IllegalArgumentException("failed to input dataDict");
        }

        dataDictMapper.insertDataDict(dataDict);
    }

    @Override
    public void updateDataDict(DataDict dataDict) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == dataDict) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictId");
            throw new IllegalArgumentException("failed to input dataDict");
        }

        dataDictMapper.updateDataDict(dataDict);
    }

    @Override
    public void deleteDataDict(int dataDictId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == dataDictId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataDictId");
            throw new IllegalArgumentException("failed to input dataDictId");
        }

        dataDictMapper.deleteDataDict(dataDictId);
    }
}
