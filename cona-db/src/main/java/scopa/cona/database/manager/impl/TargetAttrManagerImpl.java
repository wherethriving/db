package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.mappers.TargetAttrMapper;
import scopa.cona.database.model.TargetAttr;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */

@Service("targetAttrManager")
public class TargetAttrManagerImpl implements TargetAttrManager {

    public static final Logger logger = Logger.getLogger(TargetAttrManagerImpl.class);

    @Autowired
    private TargetAttrMapper targetAttrMapper;

    @Override
    public TargetAttr selectTargetAttrById(int targetAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetAttrId) {
            throw new IllegalArgumentException("failed to input targetAttrId");
        }

        TargetAttr targetAttr = targetAttrMapper.selectTargetAttrById(targetAttrId);

        if (null == targetAttr)
            throw DbException.ENTITY_IS_NOT_FOUND("targetAttr");

        return targetAttr;
    }

    @Override
    public List<TargetAttr> getTargetAttrByTargetTableId(int targetTableId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetTableId) {
            throw new IllegalArgumentException("failed to input targetTableId");
        }

        List<TargetAttr> targetAttrList = targetAttrMapper.selectTargetAttrByTargetTableId(targetTableId);


        if (null == targetAttrList)
            throw DbException.ENTITY_IS_NOT_FOUND("targetAttrList");

        return targetAttrList;
    }

    @Override
    public void insertTargetAttr(TargetAttr targetAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttr) {
            throw new IllegalArgumentException("failed to input targetAttr");
        }

        targetAttrMapper.insertTargetAttr(targetAttr);
    }

    @Override
    public void updateTargetAttr(TargetAttr targetAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == targetAttr) {
            throw new IllegalArgumentException("failed to input targetAttr");
        }

        targetAttrMapper.updateTargetAttr(targetAttr);
    }

    @Override
    public void deleteTargetAttr(int targetAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == targetAttrId) {
            throw new IllegalArgumentException("failed to input targetAttrId");
        }

        targetAttrMapper.deleteTargetAttr(targetAttrId);
    }

    public TargetAttr getTargetAttrByTableIdAndAttrNameEn(Integer targetTableId, String attrNameEn) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (!(0 != targetTableId && null != attrNameEn)) {
            throw new IllegalArgumentException("failed to input targetTableId or attrNameEn");
        }

        return targetAttrMapper.selectTargetAttrByTableIdAndAttrNameEn(targetTableId, attrNameEn);
    }

}
