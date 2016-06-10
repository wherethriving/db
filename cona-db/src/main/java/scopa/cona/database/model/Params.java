package scopa.cona.database.model;

import java.util.List;

/**
 * Created by panda on 5/18/16.
 */
public class Params {
    public List<RuleParams> getRuleParamsList() {
        return ruleParamsList;
    }

    public void setRuleParamsList(List<RuleParams> ruleParamsList) {
        this.ruleParamsList = ruleParamsList;
    }

    private List<RuleParams> ruleParamsList;
}
