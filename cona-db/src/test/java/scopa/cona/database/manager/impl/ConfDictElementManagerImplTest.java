package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.ConfDictElement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConfDictElementManagerImplTest {

	public static final Logger logger = Logger.getLogger(ConfDictElementManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.ConfDictElementManager ConfDictElementManager;

	@Test
	public void testConfDictElementCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		ConfDictElement confDictElement = new ConfDictElement();
		confDictElement.setConfDictId(1);
		confDictElement.setElemValue("String");
		confDictElement.setDescription("数据类型");
		confDictElement.setIsDefault(false);

		ConfDictElementManager.insertConfDictElement(confDictElement);

		ConfDictElement insertConfDictElement = ConfDictElementManager.selectConfDictElementById(
				confDictElement.getConfDictElemId());

		assert (insertConfDictElement != null);
		assert (insertConfDictElement.getIsDefault().equals(false));
		assert (insertConfDictElement.getConfDictId().equals(1));
		assert (insertConfDictElement.getDescription().equals("数据类型"));
		assert (insertConfDictElement.getElemValue().equals("String"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");


		insertConfDictElement.setElemValue("Integer");
		ConfDictElementManager.updateConfDictElement(insertConfDictElement);

		ConfDictElement updatedConfDictElement = ConfDictElementManager.selectConfDictElementById(
				insertConfDictElement.getConfDictElemId());

		assert (null != updatedConfDictElement);
		assert (updatedConfDictElement.getElemValue().equals("Integer"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testConfDictElementD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test delete");

		ConfDictElement confDictElement = new ConfDictElement();
		confDictElement.setConfDictId(1);
		confDictElement.setElemValue("when");
		confDictElement.setDescription("数据类型");
		confDictElement.setIsDefault(false);

		ConfDictElementManager.insertConfDictElement(confDictElement);
		ConfDictElement planDConfDictElement = ConfDictElementManager.selectConfDictElementById(confDictElement
				.getConfDictId());
		assert (null != planDConfDictElement);

		ConfDictElementManager.deleteConfDictElement(confDictElement.getConfDictElemId());
		ConfDictElement dConfDictElement = ConfDictElementManager.selectConfDictElementById(confDictElement
				.getConfDictId());
		assert (null == dConfDictElement);


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
