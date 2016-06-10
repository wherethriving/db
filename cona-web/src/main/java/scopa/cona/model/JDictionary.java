package scopa.cona.model;

import java.util.List;

/**
 * Created by panda on 6/9/16.
 */
public class JDictionary {
    private String elementType;
    private List<JDictionaryProperty> property;
    private List<JDictionaryType> type;
    private String version;
    private JDictionaryLabel label;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public List<JDictionaryProperty> getProperty() {
        return property;
    }

    public void setProperty(List<JDictionaryProperty> property) {
        this.property = property;
    }

    public List<JDictionaryType> getType() {
        return type;
    }

    public void setType(List<JDictionaryType> type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public JDictionaryLabel getLabel() {
        return label;
    }

    public void setLabel(JDictionaryLabel label) {
        this.label = label;
    }
}


