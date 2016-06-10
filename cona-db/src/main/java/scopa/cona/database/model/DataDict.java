package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class DataDict {
    private Integer dataDictId;
    private String dictName;
    private String dictType;
    private String description;

    public Integer getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(Integer dataDictId) {
        this.dataDictId = dataDictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
