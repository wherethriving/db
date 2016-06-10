package scopa.cona.database.manager;

import scopa.cona.database.model.DataSource;

/**
 * Created by panda on 5/10/16.
 */
public interface DataSourceManager {
    DataSource selectDataSourceById(int dataSourceId);
    void insertDataSource(DataSource dataSource);
    void updateDataSource(DataSource dataSource);
    void deleteDataSource(int dataSourceId);
}
