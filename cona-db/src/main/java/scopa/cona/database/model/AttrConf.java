package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class AttrConf {
    private Integer attrConfId;
    private Integer confDictId;
    private String  aconfNameEn;
    private String aconfNameCn;
    private Boolean isOptional;
    private String columnType;
    private String defaultValue;
    private String description;


    public Integer getAttrConfId() {
        return attrConfId;
    }

    public void setAttrConfId(Integer attrConfId) {
        this.attrConfId = attrConfId;
    }

    public Integer getConfDictId() {
        return confDictId;
    }

    public void setConfDictId(Integer confDictId) {
        this.confDictId = confDictId;
    }

    public String getAconfNameEn() {
        return aconfNameEn;
    }

    public void setAconfNameEn(String aconfNameEn) {
        this.aconfNameEn = aconfNameEn;
    }

    public String getAconfNameCn() {
        return aconfNameCn;
    }

    public void setAconfNameCn(String aconfNameCn) {
        this.aconfNameCn = aconfNameCn;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
