package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class DataDictElement {
    private Integer dataDictElementId;
    private Integer dataDictId;
    private String elementKey;
    private String elementValue;

    public Integer getDataDictElementId() {
        return dataDictElementId;
    }

    public void setDataDictElementId(Integer dataDictElementId) {
        this.dataDictElementId = dataDictElementId;
    }

    public Integer getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(Integer dataDictId) {
        this.dataDictId = dataDictId;
    }

    public String getElementKey() {
        return elementKey;
    }

    public void setElementKey(String elementKey) {
        this.elementKey = elementKey;
    }

    public String getElementValue() {
        return elementValue;
    }

    public void setElementValue(String elementValue) {
        this.elementValue = elementValue;
    }

}
