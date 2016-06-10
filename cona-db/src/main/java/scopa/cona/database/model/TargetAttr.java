package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class TargetAttr {
    private Integer targetAttrId;
    private Integer targetTableId;
    private String attrNameCn;
    private String attrNameEn;
    private String sample;
    private String columnType;
    private Boolean originTbIsExisted;
    private String description;

    public Integer getTargetAttrId() {
        return targetAttrId;
    }

    public void setTargetAttrId(Integer targetAttrId) {
        this.targetAttrId = targetAttrId;
    }

    public Integer getTargetTableId() {
        return targetTableId;
    }

    public void setTargetTableId(Integer targetTableId) {
        this.targetTableId = targetTableId;
    }

    public String getAttrNameCn() {
        return attrNameCn;
    }

    public void setAttrNameCn(String attrNameCn) {
        this.attrNameCn = attrNameCn;
    }

    public String getAttrNameEn() {
        return attrNameEn;
    }

    public void setAttrNameEn(String attrNameEn) {
        this.attrNameEn = attrNameEn;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Boolean getOriginTbIsExisted() {
        return originTbIsExisted;
    }

    public void setOriginTbIsExisted(Boolean originTbIsExisted) {
        this.originTbIsExisted = originTbIsExisted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
