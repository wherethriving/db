package scopa.cona.database.model;

/**
 * Created by panda on 5/16/16.
 */
public class RuleEntity {
    RuleMapping ruleMapping;
    RuleDef ruleDef;

    public RuleMapping getRuleMapping() {
        return ruleMapping;
    }

    public void setRuleMapping(RuleMapping ruleMapping) {
        this.ruleMapping = ruleMapping;
    }

    public RuleDef getRuleDef() {
        return ruleDef;
    }

    public void setRuleDef(RuleDef ruleDef) {
        this.ruleDef = ruleDef;
    }
}
