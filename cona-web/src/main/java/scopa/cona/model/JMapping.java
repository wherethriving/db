package scopa.cona.model;

import java.util.List;

/**
 * Created by panda on 6/9/16.
 */
public class JMapping {
    private List<JMappingMapping> mapping;
    private String version;
    private String elementType;
    private JMappingLabel label;

    public List<JMappingMapping> getMapping() {
        return mapping;
    }

    public void setMapping(List<JMappingMapping> mapping) {
        this.mapping = mapping;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public JMappingLabel getLabel() {
        return label;
    }

    public void setLabel(JMappingLabel label) {
        this.label = label;
    }
}
