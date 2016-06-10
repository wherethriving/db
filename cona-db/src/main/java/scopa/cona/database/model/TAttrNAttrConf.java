package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class TAttrNAttrConf {
    private Integer attrConfMappingId;
    private Integer attrConfId;
    private Integer targetAttrId;
    private String confValue;

    public String getConfValue() {
        return confValue;
    }

    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }

    public Integer getAttrConfMappingId() {
        return attrConfMappingId;
    }

    public void setAttrConfMappingId(Integer attrConfMappingId) {
        this.attrConfMappingId = attrConfMappingId;
    }

    public Integer getAttrConfId() {
        return attrConfId;
    }

    public void setAttrConfId(Integer attrConfId) {
        this.attrConfId = attrConfId;
    }

    public Integer getTargetAttrId() {
        return targetAttrId;
    }

    public void setTargetAttrId(Integer targetAttrId) {
        this.targetAttrId = targetAttrId;
    }
}
