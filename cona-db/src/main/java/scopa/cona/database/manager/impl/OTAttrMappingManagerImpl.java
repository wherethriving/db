package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OTAttrMappingManager;
import scopa.cona.database.mappers.OTAttrMappingMapper;
import scopa.cona.database.model.OTAttrMapping;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */

@Service("otAttrMappingManager")
public class OTAttrMappingManagerImpl implements OTAttrMappingManager {

    public static final Logger logger = Logger.getLogger(OTAttrMappingManagerImpl.class);

    @Autowired
    private OTAttrMappingMapper otAttrMappingMapper;

    @Override
    public OTAttrMapping selectOTAttrMappingById(int otAttrMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == otAttrMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMappingId");
            throw new IllegalArgumentException("failed to input otAttrMappingId");
        }
        OTAttrMapping otAttrMapping = otAttrMappingMapper.
                                            selectOTAttrMappingById(otAttrMappingId);

        if (null == otAttrMapping) {
            throw DbException.ENTITY_IS_NOT_FOUND("otAttrMapping");
        }

        return otAttrMapping;
    }

    @Override
    public void insertOTAttrMapping(OTAttrMapping otAttrMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMapping");
            throw new IllegalArgumentException("failed to input otAttrMapping");
        }

        otAttrMappingMapper.insertOTAttrMapping(otAttrMapping);
    }

    @Override
    public void updateOTAttrMapping(OTAttrMapping otAttrMapping) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == otAttrMapping) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMapping");
            throw new IllegalArgumentException("failed to input otAttrMapping");
        }

        otAttrMappingMapper.updateOTAttrMapping(otAttrMapping);
    }

    @Override
    public void deleteOTAttrMapping(int otAttrMappingId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == otAttrMappingId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input otAttrMappingId");
            throw new IllegalArgumentException("failed to input otAttrMappingId");
        }

        otAttrMappingMapper.deleteOTAttrMapping(otAttrMappingId);
    }

    @Override
    public List<OTAttrMapping> getOTAttrMappingByTAttrId(List<Integer> targetAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input targetAttrId");
            throw new IllegalArgumentException("failed to input targetAttrId");
        }

        List<OTAttrMapping> otAttrMappingList = otAttrMappingMapper.selectOTAttrMappingByTAttrId(targetAttrId);

        if (null == otAttrMappingList)
            throw DbException.ENTITY_IS_NOT_FOUND("otAttrMappingList");

        return otAttrMappingList;
    }

    @Override
    public List<OTAttrMapping> getOTAttrMappingByOAttrId(List<Integer> originAttrIds) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttrIds) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrIds");
            throw new IllegalArgumentException("failed to input originAttrIds");
        }

        List<OTAttrMapping> otAttrMappingList = otAttrMappingMapper.selectOTAttrMappingByOAttrId(originAttrIds);

        if (null == otAttrMappingList)
            throw DbException.ENTITY_IS_NOT_FOUND("otAttrMappingList");

        return otAttrMappingList;
    }


}
