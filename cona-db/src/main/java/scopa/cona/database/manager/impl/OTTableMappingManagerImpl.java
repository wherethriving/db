package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OTTableMappingManager;
import scopa.cona.database.mappers.OTTableMappingMapper;
import scopa.cona.database.model.OTTableMapping;

/**
 * Created by panda on 5/10/16.
 */

@Service("otTableMappingManager")
public class OTTableMappingManagerImpl implements OTTableMappingManager {

    public static final Logger logger = Logger.getLogger(OTTableMappingManagerImpl.class);

    @Autowired
    private OTTableMappingMapper otTableMappingMapper;

    @Override
    public OTTableMapping selectOTTableMappingById(int otTableMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == otTableMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMappingId");
            throw new IllegalArgumentException("failed to input otTableMappingId");
        }

        OTTableMapping otTableMapping = otTableMappingMapper.selectOTTableMappingById(otTableMappingId);

        if (null == otTableMapping)
            throw DbException.ENTITY_IS_NOT_FOUND("otTableMapping");

        return otTableMapping;
    }

    @Override
    public void insertOTTableMapping(OTTableMapping otTableMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMapping");
            throw new IllegalArgumentException("failed to input otTableMapping");
        }

        otTableMappingMapper.insertOTTableMapping(otTableMapping);
    }

    @Override
    public void updateOTTableMapping(OTTableMapping otTableMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otTableMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMapping");
            throw new IllegalArgumentException("failed to input otTableMapping");
        }

        otTableMappingMapper.updateOTTableMapping(otTableMapping);
    }

    @Override
    public void deleteOTTableMapping(int otTableMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == otTableMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otTableMappingId");
            throw new IllegalArgumentException("failed to input otTableMappingId");
        }

        otTableMappingMapper.deleteOTTableMapping(otTableMappingId);
    }
}
