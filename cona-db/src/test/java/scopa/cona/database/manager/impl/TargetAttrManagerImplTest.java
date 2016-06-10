package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.model.TargetAttr;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TargetAttrManagerImplTest {

	public static final Logger logger = Logger.getLogger(TargetAttrManagerImplTest.class);

	@Autowired
	private TargetAttrManager targetAttrManager;

	@Test
	public void testTargetAttrCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setAttrNameCn("简要案情");
		targetAttr.setAttrNameEn("CASE_jyaq");
		targetAttr.setColumnType("String");
		targetAttr.setDescription("简要案情");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setSample("po");

		targetAttrManager.insertTargetAttr(targetAttr);
		TargetAttr insertTargetAttr = targetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());

		assert (null != insertTargetAttr);
		assert (insertTargetAttr.getTargetTableId().equals(1));
		assert (insertTargetAttr.getAttrNameCn().equals("简要案情"));
		assert (insertTargetAttr.getAttrNameEn().equals("CASE_jyaq"));
		assert (insertTargetAttr.getColumnType().equals("String"));
		assert (insertTargetAttr.getOriginTbIsExisted().equals(true));
		assert (insertTargetAttr.getDescription().equals("简要案情"));
		assert (insertTargetAttr.getSample().equals("po"));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertTargetAttr.setAttrNameCn("人户关系");
		targetAttrManager.updateTargetAttr(insertTargetAttr);

		TargetAttr updatedTargetAttr = targetAttrManager.selectTargetAttrById(
				targetAttr.getTargetAttrId());

		assert (null != insertTargetAttr);
		assert (insertTargetAttr.getAttrNameCn().equals("人户关系"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");

	}

	@Test
	public void testTargetAttrD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setAttrNameCn("简要案情");
		targetAttr.setAttrNameEn("CASE_jyaq");
		targetAttr.setColumnType("String");
		targetAttr.setDescription("简要案情");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setSample("po");

		targetAttrManager.insertTargetAttr(targetAttr);
		TargetAttr insertTargetAttr = targetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());

		assert (null != insertTargetAttr);

		targetAttrManager.deleteTargetAttr(targetAttr.getTargetAttrId());
		TargetAttr dTargetAttr = targetAttrManager.selectTargetAttrById(targetAttr.getTargetAttrId());

		assert (null == dTargetAttr);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectTargetAttrByName() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setAttrNameCn("简要案情");
		targetAttr.setAttrNameEn("CASE_jyaq");
		targetAttr.setColumnType("String");
		targetAttr.setDescription("简要案情");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setSample("po");

		targetAttrManager.insertTargetAttr(targetAttr);

		TargetAttr targetAttr1 = new TargetAttr();
		targetAttr1.setTargetTableId(11);
		targetAttr.setAttrNameCn("群组名称");
		targetAttr.setAttrNameEn("MVP");
		targetAttr.setColumnType("String");
		targetAttr1.setOriginTbIsExisted(true);
		targetAttr1.setDescription("group");
		targetAttr.setSample("po");


		targetAttrManager.insertTargetAttr(targetAttr1);

		Integer targetTableId = 11;
		List<TargetAttr> selectedTargetAttr = targetAttrManager.
				getTargetAttrByTargetTableId(targetTableId);

		int size = selectedTargetAttr.size();

		for (int i = size - 1; i > size - 3; i--) {
			TargetAttr tAttr = selectedTargetAttr.get(i);
			if (i == size - 2) {
				assert (tAttr.getAttrNameCn().equals("群组名称"));
			} else if (i == size - 1) {
				assert (tAttr.getAttrNameEn().equals("MVP"));
			}
		}

	}

	@Test
	public void testSelectTargetAttrByTableIdAndAttrNameEn() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetAttr targetAttr = new TargetAttr();
		targetAttr.setTargetTableId(1);
		targetAttr.setAttrNameCn("简要案情");
		targetAttr.setAttrNameEn("CASE_jyaq_testget");
		targetAttr.setColumnType("String");
		targetAttr.setDescription("简要案情");
		targetAttr.setOriginTbIsExisted(true);
		targetAttr.setSample("po");

		targetAttrManager.insertTargetAttr(targetAttr);
		TargetAttr selectedTargetAttr = targetAttrManager.getTargetAttrByTableIdAndAttrNameEn(
				targetAttr.getTargetTableId(), targetAttr.getAttrNameEn());

		assert (null != selectedTargetAttr);
		assert (selectedTargetAttr.getTargetTableId().equals(1));
		assert (selectedTargetAttr.getAttrNameCn().equals("简要案情"));
		assert (selectedTargetAttr.getAttrNameEn().equals("CASE_jyaq_testget"));
		assert (selectedTargetAttr.getColumnType().equals("String"));
		assert (selectedTargetAttr.getOriginTbIsExisted().equals(true));
		assert (selectedTargetAttr.getDescription().equals("简要案情"));
		assert (selectedTargetAttr.getSample().equals("po"));
	}

}
