package scopa.cona.database.model;

import java.util.Date;

/**
 * Created by zhangdekun on 16-4-25.
 */
public class ConsumerDataVersion{
    private Integer id;
    private String consumerName;
    private String origId;
    private Integer versionProducerId;
    private Integer version;
    private boolean consumered;
    private Date consumeredTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Integer getVersionProducerId() {
        return versionProducerId;
    }

    public void setVersionProducerId(Integer versionProducerId) {
        this.versionProducerId = versionProducerId;
    }

    public boolean isConsumered() {
        return consumered;
    }

    public void setConsumered(boolean consumered) {
        this.consumered = consumered;
    }

    public Date getConsumeredTime() {
        return consumeredTime;
    }

    public void setConsumeredTime(Date consumeredTime) {
        this.consumeredTime = consumeredTime;
    }

    public String getOrigId() {
        return origId;
    }

    public void setOrigId(String origId) {
        this.origId = origId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
