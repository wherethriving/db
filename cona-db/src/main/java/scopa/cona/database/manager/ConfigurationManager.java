package scopa.cona.database.manager;

import scopa.cona.database.model.Configuration;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfigurationManager {
    Configuration selectConfigurationById(int configurationId);
    void insertConfiguration(Configuration configuration);
    void updateConfiguration(Configuration configuration);
    void deleteConfiguration(int configurationId);
}
