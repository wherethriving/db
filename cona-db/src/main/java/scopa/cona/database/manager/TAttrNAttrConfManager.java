package scopa.cona.database.manager;

import scopa.cona.database.model.TAttrNAttrConf;

import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */
public interface TAttrNAttrConfManager {
    TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId);
    void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void deleteTAttrNAttrConf(int tAttrNAttrConfId);
    void addAttrConfValueByTAttrAndMap(Integer targetAttrId, Map<Integer, Object> attrConfValueMap);
    void addBatchAttrConfValueByTAttrIdAndAttrConfValueMap(List<Map<Integer, Map<Integer, Object>>> attrConfValueMapList);
}
