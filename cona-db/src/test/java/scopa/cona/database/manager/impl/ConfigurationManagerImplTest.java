package scopa.cona.database.manager.impl;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.ConfigurationManager;
import scopa.cona.database.model.ConfDict;
import scopa.cona.database.model.Configuration;
import scopa.cona.database.model.DataDictElement;

/**
 * Created by panda on 6/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConfigurationManagerImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(ConfigurationManagerImplTest.class);

    @Autowired
    private ConfigurationManager configurationManager;


    @Test
    public void testConfigurationCUR() {

        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin test");

        Configuration configuration = new Configuration();
        configuration.setConfKey("confKey");
        configuration.setConfValue("confValue");

        configurationManager.insertConfiguration(configuration);
        Configuration insertConfiguration = configurationManager.selectConfigurationById(
                configuration.getConfigurationId());

        assert (null != insertConfiguration);
        assert (insertConfiguration.getConfKey().equals("confKey"));
        assert (insertConfiguration.getConfValue().equals("confValue"));

        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "pass insert select");



        configuration.setConfKey("updateKey");
        configurationManager.updateConfiguration(configuration);

        Configuration uConfiguration = configurationManager.selectConfigurationById(
                configuration.getConfigurationId());

        assert (null != uConfiguration);
        assert (uConfiguration.getConfKey().equals("updateKey"));

        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "pass update");
    }

    @Test
    public void testConfigurationD() {
        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin test");

        Configuration configuration = new Configuration();
        configuration.setConfKey("confKey");
        configuration.setConfValue("confValue");

        configurationManager.insertConfiguration(configuration);
        Configuration insertConfiguration = configurationManager.selectConfigurationById(
                configuration.getConfigurationId());


        assert (null != insertConfiguration);

        configurationManager.deleteConfiguration(configuration.getConfigurationId());

        assert (null == configuration.getConfigurationId());
        Configuration dConfiguration = configurationManager.selectConfigurationById(configuration.getConfigurationId());

        assert (null == dConfiguration);

        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "pass delete");
    }
}