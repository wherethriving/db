package scopa.cona.database.manager;

import scopa.cona.database.model.RuleDef;
import scopa.cona.database.model.RuleEntity;
import scopa.cona.database.model.RuleMapping;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface RuleDefManager {
    RuleDef selectRuleDefById(int ruleDefId);
    void insertRuleDef(RuleDef ruleDef);
    void updateRuleDef(RuleDef ruleDef);
    void deleteRuleDef(int ruleDefId);
}
