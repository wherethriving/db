package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class OTTableMapping {
    private Integer tbMappingId;
    private Integer OriginTableId;
    private Integer targetTableId;
    private Integer tbOrder;

    public Integer getTbMappingId() {
        return tbMappingId;
    }

    public void setTbMappingId(Integer tbMappingId) {
        this.tbMappingId = tbMappingId;
    }

    public Integer getTargetTableId() {
        return targetTableId;
    }

    public void setTargetTableId(Integer targetTableId) {
        this.targetTableId = targetTableId;
    }

    public Integer getOriginTableId() {
        return OriginTableId;
    }

    public void setOriginTableId(Integer originTableId) {
        OriginTableId = originTableId;
    }

    public Integer getTbOrder() {
        return tbOrder;
    }

    public void setTbOrder(Integer tbOrder) {
        this.tbOrder = tbOrder;
    }
}
