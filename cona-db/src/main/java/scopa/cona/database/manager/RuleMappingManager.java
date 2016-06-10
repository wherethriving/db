package scopa.cona.database.manager;

import scopa.cona.database.model.RuleAttrMapping;
import scopa.cona.database.model.RuleEntity;
import scopa.cona.database.model.RuleMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */
public interface RuleMappingManager {
    RuleMapping selectRuleMappingById(int ruleMappingId);
    void insertRuleMapping(RuleMapping ruleMapping);
    void updateRuleMapping(RuleMapping ruleMapping);
    void deleteRuleMapping(int ruleMappingId);
    /**
     *
     * @params Integer 统一视图id
     * @return Map<统一视图的英文名,应用到这个英文名上的所有规则>
     */
    Map<String, RuleAttrMapping> getRuleEntityByTargetTableId(Integer targetTableId);

    List<RuleMapping> getRuleMappingByAttrMappingId (List<Integer> attrMappingIds);

    List<RuleEntity> convertRuleMappingToRuleEntity(List<RuleMapping> ruleMappingList);
}
