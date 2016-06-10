package scopa.cona.database.mappers;

import scopa.cona.database.model.RuleDef;
import scopa.cona.database.model.RuleMapping;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface RuleMappingMapper {
    RuleMapping selectRuleMappingById(int ruleMappingId);
    void insertRuleMapping(RuleMapping ruleMapping);
    void updateRuleMapping(RuleMapping ruleMapping);
    void deleteRuleMapping(int ruleMappingId);
    List<RuleMapping> selectRuleMappingByAttrMappingId (List<Integer> attrMappingIds);
}
