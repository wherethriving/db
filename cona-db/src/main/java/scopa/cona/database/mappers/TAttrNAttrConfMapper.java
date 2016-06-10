package scopa.cona.database.mappers;

import scopa.cona.database.model.TAttrNAttrConf;
import scopa.cona.database.model.TargetTable;

import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */
public interface TAttrNAttrConfMapper {
    TAttrNAttrConf selectTAttrNAttrConfById(int tAttrNAttrConfId);
    void insertTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void updateTAttrNAttrConf(TAttrNAttrConf TAttrNAttrConf);
    void deleteTAttrNAttrConf(int tAttrNAttrConfId);
    void insertBatchAttrConfValueByTAttrIdAndAttrConfValueMap(List<Map<Integer, Map<String, Object>>> attrConfValueMapList);
}
