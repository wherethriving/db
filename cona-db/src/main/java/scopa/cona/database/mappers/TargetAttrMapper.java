package scopa.cona.database.mappers;

import scopa.cona.database.model.RuleMapping;
import scopa.cona.database.model.TargetAttr;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface TargetAttrMapper {
    TargetAttr selectTargetAttrById(int targetAttrId);
    void insertTargetAttr(TargetAttr targetAttr);
    void updateTargetAttr(TargetAttr targetAttr);
    void deleteTargetAttr(int targetAttrId);
    List<TargetAttr> selectTargetAttrByTargetTableId(int targetTableId);
    TargetAttr selectTargetAttrByTableIdAndAttrNameEn(Integer targetTableId, String attrNameEn);

}
