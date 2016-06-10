package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class RuleParams {
    private Integer param_order;
    private Boolean isOption;
    private String defaultValue;
    private Integer ruleDictId;

    public Integer getParam_order() {
        return param_order;
    }

    public void setParam_order(Integer param_order) {
        this.param_order = param_order;
    }

    public Boolean getIsOption() {
        return isOption;
    }

    public void setIsOption(Boolean isOption) {
        this.isOption = isOption;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Integer getRuleDictId() {
        return ruleDictId;
    }

    public void setRuleDictId(Integer ruleDictId) {
        this.ruleDictId = ruleDictId;
    }
}
