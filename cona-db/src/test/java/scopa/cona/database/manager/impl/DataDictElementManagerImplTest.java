package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.DataDictElement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataDictElementManagerImplTest {

	public static final Logger logger = Logger.getLogger(DataDictElementManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.DataDictElementManager DataDictElementManager;

	@Test
	public void testDataDictElementCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataDictElement dataDictElement = new DataDictElement();
		dataDictElement.setDataDictId(1);
		dataDictElement.setElementKey("大型车辆");
		dataDictElement.setElementValue("大型车");

		DataDictElementManager.insertDataDictElement(dataDictElement);
		DataDictElement insertDataDictElement = DataDictElementManager.selectDataDictElementfById(
				dataDictElement.getDataDictElementId());

		assert (null != insertDataDictElement);
		assert (insertDataDictElement.getDataDictId().equals(1));
		assert (insertDataDictElement.getElementKey().equals("大型车辆"));
		assert (insertDataDictElement.getElementValue().equals("大型车"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");



		dataDictElement.setElementValue("车辆");
		DataDictElementManager.updateDataDictElement(dataDictElement);

		DataDictElement uDataDictElement = DataDictElementManager.selectDataDictElementfById(
				dataDictElement.getDataDictElementId());

		assert (null != uDataDictElement);
		assert (uDataDictElement.getElementValue().equals("车辆"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testDataDictElementD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		DataDictElement dataDictElement = new DataDictElement();
		dataDictElement.setDataDictId(1);
		dataDictElement.setElementKey("大型车辆");
		dataDictElement.setElementValue("大型车");

		DataDictElementManager.insertDataDictElement(dataDictElement);
		DataDictElement insertDataDictElement = DataDictElementManager.selectDataDictElementfById(
				dataDictElement.getDataDictElementId());

		assert (null != insertDataDictElement);

		DataDictElementManager.deleteDataDictElement(dataDictElement.getDataDictElementId());
		DataDictElement dDataDictElement = DataDictElementManager.selectDataDictElementfById(
				dataDictElement.getDataDictElementId());

		assert (null == dDataDictElement);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}
}
