package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.DataSourceInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataSourceInfoManagerImplTest {

	public static final Logger logger = Logger.getLogger(DataSourceInfoManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.DataSourceInfoManager DataSourceInfoManager;

	@Test
	public void testDataSourceInfoCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataSourceInfo dataSourceInfo = new DataSourceInfo();
		dataSourceInfo.setDataSourceId(1);
		dataSourceInfo.setUrl("d1.mlamp.co");
		dataSourceInfo.setUsername("THETEST");
		dataSourceInfo.setPassword("thetest");
		dataSourceInfo.setOwner("thetest");
		dataSourceInfo.setSourceInfoName("oracle-mlamp");
		dataSourceInfo.setSchemaInput("json schema");
		dataSourceInfo.setSchemaSplit("%");

		DataSourceInfoManager.insertDataSourceInfo(dataSourceInfo);
		DataSourceInfo insertDataSourceInfo = DataSourceInfoManager.selectDataSourceInfoById(dataSourceInfo.getDataSourceInfoId());

		assert (null != insertDataSourceInfo);
		assert (insertDataSourceInfo.getDataSourceId().equals(1));
		assert (insertDataSourceInfo.getUrl().equals("d1.mlamp.co"));
		assert (insertDataSourceInfo.getUsername().equals("THETEST"));
		assert (insertDataSourceInfo.getPassword().equals("thetest"));
		assert (insertDataSourceInfo.getOwner().equals("thetest"));
		assert (insertDataSourceInfo.getSourceInfoName().equals("oracle-mlamp"));
		assert (insertDataSourceInfo.getSchemaInput().equals("json schema"));
		assert (insertDataSourceInfo.getSchemaSplit().equals("%"));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertDataSourceInfo.setUsername("gooole");
		DataSourceInfoManager.updateDataSourceInfo(insertDataSourceInfo);

		DataSourceInfo updatedDataSourceInfo = DataSourceInfoManager.selectDataSourceInfoById(
																		dataSourceInfo.getDataSourceInfoId());

		assert (null != updatedDataSourceInfo);
		assert (updatedDataSourceInfo.getUsername().equals("gooole"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");

	}

	@Test
	public void testDataSourceInfoD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataSourceInfo dataSourceInfo = new DataSourceInfo();
		dataSourceInfo.setDataSourceId(1);
		dataSourceInfo.setUrl("d1.mlamp.co");
		dataSourceInfo.setUsername("THETEST");
		dataSourceInfo.setPassword("thetest");
		dataSourceInfo.setOwner("thetest");
		dataSourceInfo.setSourceInfoName("oracle-mlamp");
		dataSourceInfo.setSchemaInput("json schema");
		dataSourceInfo.setSchemaSplit("%");

		DataSourceInfoManager.insertDataSourceInfo(dataSourceInfo);

		DataSourceInfoManager.deleteDataSourceInfo(dataSourceInfo.getDataSourceInfoId());

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");

	}

	@Test
	public void testSelectDataSourceInfoByUrl() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		String url = "http://d1.mlamp.co:5480/thetest";

		DataSourceInfo selectedDataSourceInfo = DataSourceInfoManager.selectDataSourceInfoByUrl(url);

		assert (null != selectedDataSourceInfo);
		assert (selectedDataSourceInfo.getDataSourceId().equals(1));
		assert (selectedDataSourceInfo.getUsername().equals("THETEST"));



	}


}
