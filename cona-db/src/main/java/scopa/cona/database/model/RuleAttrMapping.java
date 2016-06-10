package scopa.cona.database.model;

import java.util.List;

/**
 * Created by panda on 5/31/16.
 */
public class RuleAttrMapping {
    OriginAttr originAttr;
    List<RuleEntity> ruleEntityList;

    public OriginAttr getOriginAttr() {
        return originAttr;
    }

    public void setOriginAttr(OriginAttr originAttr) {
        this.originAttr = originAttr;
    }

    public List<RuleEntity> getRuleEntityList() {
        return ruleEntityList;
    }

    public void setRuleEntityList(List<RuleEntity> ruleEntityList) {
        this.ruleEntityList = ruleEntityList;
    }
}
