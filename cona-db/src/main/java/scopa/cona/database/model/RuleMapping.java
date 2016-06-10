package scopa.cona.database.model;

import scopa.cona.database.util.DataConvertUtil;

/**
 * Created by panda on 5/10/16.
 */
public class RuleMapping {
    private Integer ruleMappingId;
    private Integer attrMappingId;
    private Integer ruleDefId;
    private String paramValue;
    private Integer ruleOrder;
    private String[] paramArray;

    public String[] getParamArray() {
        paramArray = DataConvertUtil.explodeString(paramValue);
        return paramArray;
    }

    public void setParamArray(String[] paramArray) {
        this.paramArray = paramArray;
        paramValue = DataConvertUtil.implodeString(paramArray);
    }

    public Integer getRuleMappingId() {
        return ruleMappingId;
    }

    public void setRuleMappingId(Integer ruleMappingId) {
        this.ruleMappingId = ruleMappingId;
    }

    public Integer getAttrMappingId() {
        return attrMappingId;
    }

    public void setAttrMappingId(Integer attrMappingId) {
        this.attrMappingId = attrMappingId;
    }

    public Integer getRuleDefId() {
        return ruleDefId;
    }

    public void setRuleDefId(Integer ruleDefId) {
        this.ruleDefId = ruleDefId;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getRuleOrder() {
        return ruleOrder;
    }

    public void setRuleOrder(Integer ruleOrder) {
        this.ruleOrder = ruleOrder;
    }
}
