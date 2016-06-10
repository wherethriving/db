package scopa.cona.database.manager;

import scopa.cona.database.model.DataSourceInfo;

/**
 * Created by panda on 5/10/16.
 */
public interface DataSourceInfoManager {
    DataSourceInfo selectDataSourceInfoById(int dataSourceInfoId);
    void insertDataSourceInfo(DataSourceInfo dataSourceInfo);
    void updateDataSourceInfo(DataSourceInfo dataSourceInfo);
    void deleteDataSourceInfo(int dataSourceInfoId);
    DataSourceInfo selectDataSourceInfoByUrl(String dataSourceUrl);
}
