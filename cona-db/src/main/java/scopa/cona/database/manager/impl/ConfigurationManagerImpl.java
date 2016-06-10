package scopa.cona.database.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.exception.DbException;
import scopa.cona.database.manager.AttrConfManager;
import scopa.cona.database.manager.ConfigurationManager;
import scopa.cona.database.mappers.AttrConfMapper;
import scopa.cona.database.mappers.ConfigurationMapper;
import scopa.cona.database.mappers.DataDictElementMapper;
import scopa.cona.database.model.AttrConf;
import scopa.cona.database.model.Configuration;

/**
 * Created by panda on 5/10/16.
 */

@Service("configurationManager")
public class ConfigurationManagerImpl implements ConfigurationManager {

    public static final Logger logger = Logger.getLogger(ConfigurationManagerImpl.class);

    @Autowired
    private ConfigurationMapper configurationMapper;

    @Override
    public Configuration selectConfigurationById(int configurationId) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == configurationId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input configurationId");
            throw new IllegalArgumentException("failed to input configurationId");
        }

        Configuration configuration = configurationMapper.selectConfigurationById(configurationId);

        if (null == configuration)
            throw DbException.ENTITY_IS_NOT_FOUND("configuration");

        return configuration;
    }

    @Override
    public void insertConfiguration(Configuration configuration) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == configuration) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input configuration");
            throw new IllegalArgumentException("failed to input configuration");
        }

        configurationMapper.insertConfiguration(configuration);
    }

    @Override
    public void updateConfiguration(Configuration configuration) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (null == configuration) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input configuration");
            throw new IllegalArgumentException("failed to input configuration");
        }

        configurationMapper.updateConfiguration(configuration);
    }

    @Override
    public void deleteConfiguration(int configurationId) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin");

        if (0 == configurationId) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                    "failed to input configurationId");
            throw new IllegalArgumentException("failed to input configurationId");
        }

        configurationMapper.deleteConfiguration(configurationId);
    }

}
