package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.TAttrNAttrConfManager;
import scopa.cona.database.mappers.TAttrNAttrConfMapper;
import scopa.cona.database.model.TAttrNAttrConf;

import java.util.*;

/**
 * Created by panda on 5/10/16.
 */

@Service("tAttrNAttrConfManager")
public class TAttrNAttrConfManagerImpl implements TAttrNAttrConfManager {

    public static final Logger logger = Logger.getLogger(TAttrNAttrConfManagerImpl.class);

    @Autowired
    private TAttrNAttrConfMapper tAttrNAttrConfMapper;

    @Override
    public TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == tAttrNAttrConfId) {
            throw new IllegalArgumentException("failed to input tAttrNAttrConfId");
        }

        TAttrNAttrConf tAttrNAttrConf = tAttrNAttrConfMapper.selectTAttrNAttrConfById(tAttrNAttrConfId);

        if (null == tAttrNAttrConf)
            throw DbException.ENTITY_IS_NOT_FOUND("tAttrNAttrConf");

        return tAttrNAttrConf;
    }

    @Override
    public void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == TAttrNAttrConf) {
            throw new IllegalArgumentException("failed to input TAttrNAttrConf");
        }

        tAttrNAttrConfMapper.insertTAttrNAttrConf(TAttrNAttrConf);
    }

    @Override
    public void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == TAttrNAttrConf) {
            throw new IllegalArgumentException("failed to input TAttrNAttrConf");
        }

        tAttrNAttrConfMapper.updateTAttrNAttrConf(TAttrNAttrConf);
    }

    @Override
    public void deleteTAttrNAttrConf(int tAttrNAttrConfId) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == tAttrNAttrConfId) {
            throw new IllegalArgumentException("failed to input tAttrNAttrConfId");
        }

        tAttrNAttrConfMapper.deleteTAttrNAttrConf(tAttrNAttrConfId);
    }

    @Override
    public void addAttrConfValueByTAttrAndMap(Integer targetAttrId, Map<Integer, Object> attrConfValueMap) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (!(0 != targetAttrId && null != attrConfValueMap)) {
            throw new IllegalArgumentException("failed to input targetAttrId or attrConfValueMap");
        }

        TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
        tAttrNAttrConf.setTargetAttrId(targetAttrId);

        Map.Entry<Integer, Object> entry = null;

        Set<Map.Entry<Integer, Object>> set = attrConfValueMap.entrySet();
        Iterator<Map.Entry<Integer, Object>> iter = set.iterator();

        while (iter.hasNext()) {
            entry = iter.next();
            tAttrNAttrConf.setAttrConfId(Integer.valueOf(entry.getKey().toString()));
            tAttrNAttrConf.setConfValue(entry.getValue().toString());

            tAttrNAttrConfMapper.insertTAttrNAttrConf(tAttrNAttrConf);
        }


    }

    @Override
    public void addBatchAttrConfValueByTAttrIdAndAttrConfValueMap(List<Map<Integer, Map<Integer, Object>>> attrConfValueMapList) {

        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == attrConfValueMapList) {
            throw new IllegalArgumentException("failed to input attrConfValueMapList");
        }

        for (Map<Integer, Map<Integer, Object>> attrConfValueMap : attrConfValueMapList) {

            Set<Map.Entry<Integer, Map<Integer, Object>>> set = attrConfValueMap.entrySet();
            Iterator<Map.Entry<Integer, Map<Integer, Object>>> iter = set.iterator();
            Map.Entry<Integer, Map<Integer, Object>> entry = null;
            while (iter.hasNext()) {
                entry = iter.next();
            }

            Integer targetAttrId = entry.getKey();
            Map<Integer, Object> attrConfValue = entry.getValue();
            addAttrConfValueByTAttrAndMap(targetAttrId, attrConfValue);

        }

    }




}
