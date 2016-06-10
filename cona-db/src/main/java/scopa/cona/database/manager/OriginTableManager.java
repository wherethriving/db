package scopa.cona.database.manager;

import scopa.cona.database.model.OriginTable;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OriginTableManager {
    OriginTable selectOriginTableById(int originTableId);

    /**
     * 根据表名
     * @param originTableName
     * @return
     */
    OriginTable selectOriginTableByName(String originTableName);
    void insertOriginTable(OriginTable originTable);
    void updateOriginTable(OriginTable originTable);
    void deleteOriginTable(int originTableId);

    /**
     * 获取这个source下的所有table
     * @param dataSourceInfoId
     * @return
     */
    List<OriginTable> getOriginTableByDataSourceInfoId(Integer dataSourceInfoId);
}
