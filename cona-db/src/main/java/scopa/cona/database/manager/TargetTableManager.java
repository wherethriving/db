package scopa.cona.database.manager;

import scopa.cona.database.model.TargetTable;

/**
 * Created by panda on 5/10/16.
 */
public interface TargetTableManager {
    TargetTable selectTargetTableById(int targetTableId);
    void insertTargetTable(TargetTable targetTable);
    void updateTargetTable(TargetTable targetTable);
    void deleteTargetTable(int targetTableId);
    TargetTable getTargetTableByLabelEn(String labelEn);
    TargetTable getTargetTableByLabelEnElemTypeVersion(String labelEn, String elemType, String version);
}
