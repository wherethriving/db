package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class ConfDictElement {
    private Integer confDictElemId;
    private Integer confDictId;
    private String elemValue;
    private String description;
    private Boolean isDefault;

    public Integer getConfDictElemId() {
        return confDictElemId;
    }

    public void setConfDictElemId(Integer confDictElemId) {
        this.confDictElemId = confDictElemId;
    }

    public Integer getConfDictId() {
        return confDictId;
    }

    public void setConfDictId(Integer confDictId) {
        this.confDictId = confDictId;
    }

    public String getElemValue() {
        return elemValue;
    }

    public void setElemValue(String elemValue) {
        this.elemValue = elemValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
