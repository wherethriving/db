package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.constant.DataSourceType;
import scopa.cona.database.model.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataSourceManagerImplTest {

	public static final Logger logger = Logger.getLogger(DataSourceManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.DataSourceManager DataSourceManager;

	@Test
	public void testDataSourceCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataSource dataSource = new DataSource();
		dataSource.setSourceName(DataSourceType.ORACLE.toString());
		dataSource.setSampleValue("d195.mlamp.co");

		DataSourceManager.insertDataSource(dataSource);
		DataSource insertDataSource = DataSourceManager.selectDataSourceById(dataSource.getDataSourceId());

		assert (null != insertDataSource);
		assert (insertDataSource.getSourceName().equals(DataSourceType.ORACLE.toString()));
		assert (insertDataSource.getSampleValue().equals("d195.mlamp.co"));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");


		insertDataSource.setSampleValue("195d.mlamp.coooo");
		DataSourceManager.updateDataSource(insertDataSource);

		DataSource updateDataSource = DataSourceManager.selectDataSourceById(dataSource.getDataSourceId());

		assert (null != updateDataSource);
		assert (updateDataSource.getSampleValue().equals("195d.mlamp.coooo"));
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");

	}

	@Test
	public void testDataSourceD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataSource dataSource = new DataSource();
		dataSource.setSourceName(DataSourceType.ORACLE.toString());
		dataSource.setSampleValue("d195.mlamp.co");

		DataSourceManager.insertDataSource(dataSource);
		DataSource planDeleteDataSource = DataSourceManager.selectDataSourceById(dataSource.getDataSourceId());
		assert (null != planDeleteDataSource);

		DataSourceManager.deleteDataSource(dataSource.getDataSourceId());
		DataSource updateDataSource = DataSourceManager.selectDataSourceById(dataSource.getDataSourceId());
		assert (null == updateDataSource);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
