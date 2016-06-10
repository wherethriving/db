package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class ConfDict {
    private Integer confDictId;
    private String nameEn;
    private String nameCn;
    private Boolean isType;
    private String description;

    public Integer getConfDictId() {
        return confDictId;
    }

    public void setConfDictId(Integer confDictId) {
        this.confDictId = confDictId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public Boolean getIsType() {
        return isType;
    }

    public void setIsType(Boolean isType) {
        this.isType = isType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
