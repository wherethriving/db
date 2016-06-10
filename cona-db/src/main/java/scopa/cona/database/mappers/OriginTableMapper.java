package scopa.cona.database.mappers;

import scopa.cona.database.model.OriginAttr;
import scopa.cona.database.model.OriginTable;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OriginTableMapper {
    OriginTable selectOriginTableById(int originTableId);
    void insertOriginTable(OriginTable originTable);
    void updateOriginTable(OriginTable originTable);
    void deleteOriginTable(int originTableId);
    OriginTable selectOriginTableByName(String originTableName);
    List<OriginTable> selectOTableByDSInfoId(Integer dataSourceInfoId);
}
