package scopa.cona.database.manager;

import scopa.cona.database.model.TargetAttr;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface TargetAttrManager {
    TargetAttr selectTargetAttrById(int targetAttrId);

    /**
     * 获得一个统一个视图的所有属性
     * @param targetTableId
     * @return
     */
    List<TargetAttr> getTargetAttrByTargetTableId(int targetTableId);
    void insertTargetAttr(TargetAttr targetAttr);
    void updateTargetAttr(TargetAttr targetAttr);
    void deleteTargetAttr(int targetAttrId);
    TargetAttr getTargetAttrByTableIdAndAttrNameEn(Integer targetTableId, String attrNameEn);
}
