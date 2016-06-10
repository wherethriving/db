package scopa.cona.database.mappers;

import scopa.cona.database.model.Configuration;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfigurationMapper {
    Configuration selectConfigurationById(int configurationId);
    void insertConfiguration(Configuration configuration);
    void updateConfiguration(Configuration configuration);
    void deleteConfiguration(int configurationId);
}
