package scopa.cona.database.model;

import java.util.Date;

/**
 * Created by panda on 5/10/16.
 */
public class DataSource {
    private Integer dataSourceId;
    private String sourceName;
    private String sampleValue;

    public Integer getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSampleValue() {
        return sampleValue;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
    }
}
