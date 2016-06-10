package scopa.cona.database.model;

/**
 * Created by panda on 5/10/16.
 */
public class DataSourceInfo {
    private Integer dataSourceInfoId;
    private Integer dataSourceId;
    private String sourceInfoName;
    private String url;
    private String username;
    private String password;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private String schemaSplit;
    private String schemaInput;

    public Integer getDataSourceInfoId() {
        return dataSourceInfoId;
    }

    public void setDataSourceInfoId(Integer dataSourceInfoId) {
        this.dataSourceInfoId = dataSourceInfoId;
    }

    public Integer getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getSourceInfoName() {
        return sourceInfoName;
    }

    public void setSourceInfoName(String sourceInfoName) {
        this.sourceInfoName = sourceInfoName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchemaSplit() {
        return schemaSplit;
    }

    public void setSchemaSplit(String schemaSplit) {
        this.schemaSplit = schemaSplit;
    }

    public String getSchemaInput() {
        return schemaInput;
    }

    public void setSchemaInput(String schemaInput) {
        this.schemaInput = schemaInput;
    }
}
