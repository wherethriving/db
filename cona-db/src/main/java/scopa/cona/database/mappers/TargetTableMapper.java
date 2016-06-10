package scopa.cona.database.mappers;

import scopa.cona.database.model.TargetAttr;
import scopa.cona.database.model.TargetTable;

/**
 * Created by panda on 5/10/16.
 */
public interface TargetTableMapper {
    TargetTable selectTargetTableById(int targetTableId);
    void insertTargetTable(TargetTable targetTable);
    void updateTargetTable(TargetTable targetTable);
    void deleteTargetTable(int targetTableId);
    TargetTable selectTargetTableByLabelEn(String labelEn);
    TargetTable selectTargetTableByLabelEnElemTypeVersion(String labelEn, String elemType, String version);
}
