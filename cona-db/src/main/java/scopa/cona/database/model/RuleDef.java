package scopa.cona.database.model;

import org.apache.log4j.Logger;
import scopa.cona.database.util.JsonOperationUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public class RuleDef {
    private Integer ruleDefId;
    private String ruleName;
    private String ruleType;
    private String description;
    private String param;
    private String annotation;
    private List<RuleParams> ruleParams;

    public static final Logger logger = Logger.getLogger(RuleDef.class);

    public void setRuleParams(List<RuleParams> ruleParams) {
        this.ruleParams = ruleParams;
        String generatedParam = null;
        if (null != ruleParams) {
            generatedParam = JsonOperationUtil.getJsonFromObject(ruleParams);
        }
        this.param = generatedParam;
    }

    public List<RuleParams> getRuleParams() {
        ruleParams = JsonOperationUtil.getRuleParamsFromJson(param);
        return ruleParams;
    }

    public Integer getRuleDefId() {
        return ruleDefId;
    }

    public void setRuleDefId(Integer ruleDefId) {
        this.ruleDefId = ruleDefId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParam() {
        return param;
    }


    /**
     {
        [
            {
                "param_order": 1,
                "is_option": true,
                "rule_dict_id": 4,
                "default_value":"1"

            },
            {
                "param_order": 2,
                "is_option": false,
                "rule_dict_id": 3,
                "default_value":"1"

            }
        ]
     }
     **/

    public void setParam(String param) {
        this.param = param;
    }


    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
