package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.OriginAttrManager;
import scopa.cona.database.mappers.OriginAttrMapper;
import scopa.cona.database.mappers.OriginTableMapper;
import scopa.cona.database.model.OriginAttr;
import scopa.cona.database.model.OriginTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by panda on 5/10/16.
 */

@Service("originAttrManager")
public class OriginAttrManagerImpl implements OriginAttrManager {

    public static final Logger logger = Logger.getLogger(OriginAttrManagerImpl.class);

    @Autowired
    private OriginAttrMapper originAttrMapper;

    @Autowired
    private OriginTableMapper originTableMapper;

    @Override
    public OriginAttr selectOriginAttrById(int originAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == originAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrId");
            throw new IllegalArgumentException("failed to input originAttrId");
        }

        OriginAttr originAttr = originAttrMapper.selectOriginAttrById(originAttrId);

        if (null == originAttr)
            throw DbException.ENTITY_IS_NOT_FOUND("originAttr");

        return originAttr;
    }

    @Override
    public void insertOriginAttr(OriginAttr originAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttr");
            throw new IllegalArgumentException("failed to input originAttr");
        }

        originAttrMapper.insertOriginAttr(originAttr);
    }

    @Override
    public void updateOriginAttr(OriginAttr originAttr) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttr) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttr");
            throw new IllegalArgumentException("failed to input originAttr");
        }

        originAttrMapper.updateOriginAttr(originAttr);
    }

    @Override
    public void deleteOriginAttr(int originAttrId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == originAttrId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrId");
            throw new IllegalArgumentException("failed to input originAttrId");
        }

        originAttrMapper.deleteOriginAttr(originAttrId);
    }

    @Override
    public List<OriginAttr> getOAttrByOTableNameAndDSInfoId(String tableName, Integer dataSourceInfoId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == tableName) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input tableName");
            throw new IllegalArgumentException("failed to input tableName");
        }

        if (null == dataSourceInfoId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input dataSourceInfoId");
            throw new IllegalArgumentException("failed to input dataSourceInfoId");
        }

        List<Integer> originTableIds = new ArrayList<>();
        List<OriginTable> originTableList = originTableMapper.selectOTableByDSInfoId(dataSourceInfoId);
        for (OriginTable originTable : originTableList) {
            originTableIds.add(originTable.getOriginTableId());
        }
        //根据rowOrder排序
        List<OriginAttr> attrs = originAttrMapper.getOAttrByOTableName(originTableIds);
        if(attrs !=null && attrs.size()>0){
            Collections.sort(attrs);
        }
        return originAttrMapper.getOAttrByOTableName(originTableIds);
    }

    @Override
    public void addBatchOriginAttrs(List<OriginAttr> originAttrs) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == originAttrs) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input originAttrs");
            throw new IllegalArgumentException("failed to input originAttrs");
        }

        originAttrMapper.insertBatchOriginAttrs(originAttrs);
    }
}
