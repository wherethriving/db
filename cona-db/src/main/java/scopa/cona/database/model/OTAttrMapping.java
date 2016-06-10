package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class OTAttrMapping {
    private Integer attrMappingId;
    private Integer originAttrId;
    private Integer targetAttrId;


    public Integer getAttrMappingId() {
        return attrMappingId;
    }

    public void setAttrMappingId(Integer attrMappingId) {
        this.attrMappingId = attrMappingId;
    }

    public Integer getTargetAttrId() {
        return targetAttrId;
    }

    public void setTargetAttrId(Integer targetAttrId) {
        this.targetAttrId = targetAttrId;
    }

    public Integer getOriginAttrId() {
        return originAttrId;
    }

    public void setOriginAttrId(Integer originAttrId) {
        this.originAttrId = originAttrId;
    }
}
