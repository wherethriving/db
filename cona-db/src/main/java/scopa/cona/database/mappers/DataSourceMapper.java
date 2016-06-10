package scopa.cona.database.mappers;

import scopa.cona.database.model.DataSource;
import scopa.cona.database.model.DataSourceInfo;

/**
 * Created by panda on 5/10/16.
 */
public interface DataSourceMapper {
    DataSource selectDataSourceById(int dataSourceId);
    void insertDataSource(DataSource dataSource);
    void updateDataSource(DataSource dataSource);
    void deleteDataSource(int dataSourceId);
}
