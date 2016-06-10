package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class OriginTable {
    private Integer originTableId;
    private Integer dataSourceInfoId;
    private String tbNameEn;
    private String tbNameCn;
    private String description;
    private Integer isIncremental;
    private String increColName;
    private Integer increColType;

    public String getIncreColName() {
        return increColName;
    }

    public void setIncreColName(String increColName) {
        this.increColName = increColName;
    }

    public Integer getIncreColType() {
        return increColType;
    }

    public void setIncreColType(Integer increColType) {
        this.increColType = increColType;
    }

    public Integer getOriginTableId() {
        return originTableId;
    }

    public void setOriginTableId(Integer originTableId) {
        this.originTableId = originTableId;
    }

    public Integer getDataSourceInfoId() {
        return dataSourceInfoId;
    }

    public void setDataSourceInfoId(Integer dataSourceInfoId) {
        this.dataSourceInfoId = dataSourceInfoId;
    }

    public String getTbNameEn() {
        return tbNameEn;
    }

    public void setTbNameEn(String tbNameEn) {
        this.tbNameEn = tbNameEn;
    }

    public String getTbNameCn() {
        return tbNameCn;
    }

    public void setTbNameCn(String tbNameCn) {
        this.tbNameCn = tbNameCn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsIncremental() {
        return isIncremental;
    }

    public void setIsIncremental(Integer isIncremental) {
        this.isIncremental = isIncremental;
    }
}
