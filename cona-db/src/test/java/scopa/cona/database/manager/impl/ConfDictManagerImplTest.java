package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.ConfDict;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConfDictManagerImplTest {

	public static final Logger logger = Logger.getLogger(ConfDictManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.ConfDictManager ConfDictManager;

	@Test
	public void testConfDictCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		ConfDict confDict = new ConfDict();
		confDict.setNameEn("Car");
		confDict.setNameCn("车");
		confDict.setIsType(true);
		confDict.setDescription("type列");

		ConfDictManager.insertConfDict(confDict);
		ConfDict insertConfDict = ConfDictManager.selectConfDictById(confDict.getConfDictId());

		assert (null != insertConfDict);
		assert (insertConfDict.getIsType().equals(true));
		assert (insertConfDict.getNameCn().equals("车"));
		assert (insertConfDict.getNameEn().equals("Car"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		confDict.setIsType(false);
		ConfDictManager.updateConfDict(confDict);
		ConfDict uConfDict = ConfDictManager.selectConfDictById(confDict.getConfDictId());

		assert (null != uConfDict);
		assert (uConfDict.getIsType().equals(false));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testConfDictD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		ConfDict confDict = new ConfDict();
		confDict.setNameEn("Car");
		confDict.setNameCn("车");
		confDict.setIsType(true);
		confDict.setDescription("type列");

		ConfDictManager.insertConfDict(confDict);
		ConfDict insertConfDict = ConfDictManager.selectConfDictById(confDict.getConfDictId());

		assert (null != insertConfDict);

		ConfDictManager.deleteConfDict(confDict.getConfDictId());
		ConfDict uConfDict = ConfDictManager.selectConfDictById(confDict.getConfDictId());

		assert (null == uConfDict);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
