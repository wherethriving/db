package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.DataDict;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataDictManagerImplTest {

	public static final Logger logger = Logger.getLogger(DataDictManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.DataDictManager DataDictManager;

	@Test
	public void testDataDictCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataDict dataDict = new DataDict();
		dataDict.setDictName("车辆");
		dataDict.setDictType("rule");
		dataDict.setDescription("车辆数据字典");

		DataDictManager.insertDataDict(dataDict);

		DataDict insertDataDict = DataDictManager.selectDataDictById(dataDict.getDataDictId());

		assert (null != insertDataDict);
		assert (insertDataDict.getDictName().equals("车辆"));
		assert (insertDataDict.getDescription().equals("车辆数据字典"));
		assert (insertDataDict.getDictType().equals("rule"));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertDataDict.setDictName("性别");
		DataDictManager.updateDataDict(insertDataDict);

		DataDict uDataDict = DataDictManager.selectDataDictById(dataDict.getDataDictId());

		assert (null != uDataDict);
		assert (uDataDict.getDictName().equals("性别"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testDataDictD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataDict dataDict = new DataDict();
		dataDict.setDictName("车辆");
		dataDict.setDictType("rule");
		dataDict.setDescription("车辆数据字典");

		DataDictManager.insertDataDict(dataDict);
		DataDict insertDataDict = DataDictManager.selectDataDictById(dataDict.getDataDictId());

		assert (null != insertDataDict);

		DataDictManager.deleteDataDict(dataDict.getDataDictId());
		DataDict dDataDict = DataDictManager.selectDataDictById(dataDict.getDataDictId());

		assert (null == dDataDict);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");

	}

}
