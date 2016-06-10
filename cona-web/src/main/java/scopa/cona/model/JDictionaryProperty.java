package scopa.cona.model;

/**
 * Created by panda on 6/9/16.
 */
public class JDictionaryProperty {
    private String primaryType;
    private String en;
    private String cn;
    private String searchType;
    private String dataType;
    private Boolean isUniqueKey;
    private String des;
    private String primary;
    private Boolean isLongString;
    private Boolean isCommonKey;
    private String primaryName;
    private Integer offset;
    private String  timeFormat;
    private Boolean isSearchKey;
    private Boolean isPrimary;
    private String reference;

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Boolean getIsUniqueKey() {
        return isUniqueKey;
    }

    public void setIsUniqueKey(Boolean isUniqueKey) {
        this.isUniqueKey = isUniqueKey;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Boolean getIsLongString() {
        return isLongString;
    }

    public void setIsLongString(Boolean isLongString) {
        this.isLongString = isLongString;
    }

    public Boolean getIsCommonKey() {
        return isCommonKey;
    }

    public void setIsCommonKey(Boolean isCommonKey) {
        this.isCommonKey = isCommonKey;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public Boolean getIsSearchKey() {
        return isSearchKey;
    }

    public void setIsSearchKey(Boolean isSearchKey) {
        this.isSearchKey = isSearchKey;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }
}
