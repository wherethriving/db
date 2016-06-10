package scopa.cona.model;

import java.util.List;

/**
 * Created by panda on 6/9/16.
 */
public class JMappingMapping {
    private String srcTableEn;
    private List<JMappingMappingProperties> properties;
    private String srcTableCn;

    public String getSrcTableEn() {
        return srcTableEn;
    }

    public void setSrcTableEn(String srcTableEn) {
        this.srcTableEn = srcTableEn;
    }

    public List<JMappingMappingProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<JMappingMappingProperties> properties) {
        this.properties = properties;
    }

    public String getSrcTableCn() {
        return srcTableCn;
    }

    public void setSrcTableCn(String srcTableCn) {
        this.srcTableCn = srcTableCn;
    }
}
