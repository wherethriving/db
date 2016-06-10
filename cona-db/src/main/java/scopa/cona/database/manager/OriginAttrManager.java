package scopa.cona.database.manager;

import scopa.cona.database.model.OriginAttr;

import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */
public interface OriginAttrManager {
    OriginAttr selectOriginAttrById(int originAttrId);
    void insertOriginAttr(OriginAttr originAttr);
    void updateOriginAttr(OriginAttr originAttr);
    void deleteOriginAttr(int originAttrId);

    /**
     * 根据这个datasource下的一个表名查询这个表的所有字段
     * @param tableName
     * @param dataSourceInfoId
     * @return 返回的list要根据字段的顺序进行排序
     */
    List<OriginAttr> getOAttrByOTableNameAndDSInfoId(String tableName,Integer dataSourceInfoId);

    void addBatchOriginAttrs(List<OriginAttr> originAttrs);

    void addTableIdByTAMappingList(List<Map<String, String>> oTableAttrMappingList);
}
