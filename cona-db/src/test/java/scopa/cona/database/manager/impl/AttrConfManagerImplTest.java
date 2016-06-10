package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.AttrConfManager;
import scopa.cona.database.model.AttrConf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AttrConfManagerImplTest {

	public static final Logger logger = Logger.getLogger(AttrConfManagerImplTest.class);

	@Autowired
	private AttrConfManager attrConfManager;

	@Test
	public void testAttrConfCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		AttrConf attrConf = new AttrConf();
		attrConf.setAconfNameCn("是否UniqueKey");
		attrConf.setAconfNameEn("isUniqueKey");
		attrConf.setColumnType("Boolean");
		attrConf.setConfDictId(2);
		attrConf.setDefaultValue("true");
		attrConf.setIsOptional(false);
		attrConf.setDescription("判断是否uniquekey");

		attrConfManager.insertAttrConf(attrConf);
		AttrConf insertAttrConf = attrConfManager.selectAttrConfById(attrConf.getAttrConfId());

		assert (insertAttrConf != null);
		assert (insertAttrConf.getAconfNameCn().equals("是否UniqueKey"));
		assert (insertAttrConf.getIsOptional().equals(false));
		assert (insertAttrConf.getAconfNameEn().equals("isUniqueKey"));
		assert (insertAttrConf.getColumnType().equals("Boolean"));
		assert (insertAttrConf.getDescription().equals("判断是否uniquekey"));
		assert (insertAttrConf.getDefaultValue().equals("true"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");


		insertAttrConf.setDefaultValue("false");

		attrConfManager.updateAttrConf(insertAttrConf);

		AttrConf updateAttrConf = attrConfManager.selectAttrConfById(insertAttrConf.getAttrConfId());

		assert (null != updateAttrConf);
		assert (updateAttrConf.getDefaultValue().equals("false"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");


	}


	@Test
	public void testAttrConfD(){

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test delete");

		AttrConf attrConf = new AttrConf();
		attrConf.setAconfNameCn("是否UniqueKey");
		attrConf.setAconfNameEn("isUniqueKey");
		attrConf.setColumnType("Boolean");
		attrConf.setConfDictId(2);
		attrConf.setDefaultValue("true");
		attrConf.setIsOptional(false);
		attrConf.setDescription("判断是否uniquekey");

		attrConfManager.insertAttrConf(attrConf);
		AttrConf planDeleteAttrConf = attrConfManager.selectAttrConfById(attrConf.getAttrConfId());
		assert (null != planDeleteAttrConf);

		attrConfManager.deleteAttrConf(attrConf.getAttrConfId());
		AttrConf deleteAttrConf = attrConfManager.selectAttrConfById(attrConf.getAttrConfId());
		assert (null == deleteAttrConf);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
