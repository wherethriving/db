package scopa.cona.database.mappers;

import scopa.cona.database.model.OTTableMapping;
import scopa.cona.database.model.RuleDef;

/**
 * Created by panda on 5/10/16.
 */
public interface RuleDefMapper {
    RuleDef selectRuleDefById(int ruleDefId);
    void insertRuleDef(RuleDef ruleDef);
    void updateRuleDef(RuleDef ruleDef);
    void deleteRuleDef(int ruleDefId);
}
