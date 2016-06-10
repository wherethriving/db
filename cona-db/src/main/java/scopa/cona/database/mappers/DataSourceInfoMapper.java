package scopa.cona.database.mappers;

import scopa.cona.database.model.DataSourceInfo;

/**
 * Created by panda on 5/10/16.
 */
public interface DataSourceInfoMapper {
    DataSourceInfo selectDataSourceInfoById(int dataSourceInfoId);
    void insertDataSourceInfo(DataSourceInfo DataSourceInfo);
    void updateDataSourceInfo(DataSourceInfo DataSourceInfo);
    void deleteDataSourceInfo(int dataSourceInfoId);
    DataSourceInfo selectDataSourceInfoByUrl(String dataSourceUrl);
}
