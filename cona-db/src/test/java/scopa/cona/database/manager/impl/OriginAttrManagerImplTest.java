package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.OriginAttr;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OriginAttrManagerImplTest {

	public static final Logger logger = Logger.getLogger(OriginAttrManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.OriginAttrManager OriginAttrManager;

	@Test
	public void testOriginAttrCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginAttr originAttr = new OriginAttr();
		originAttr.setOriginTableId(1);
		originAttr.setAttrName("Name");
		originAttr.setColumnType(1);
		originAttr.setRowOrder(2);
		originAttr.setSample("HNK");
		originAttr.setDescription("person's name");


		OriginAttrManager.insertOriginAttr(originAttr);
		OriginAttr insertOriginAttr = OriginAttrManager.selectOriginAttrById(originAttr.getOriginAttrId());

		assert (null != insertOriginAttr);
		assert (insertOriginAttr.getOriginTableId().equals(1));
		assert (insertOriginAttr.getAttrName().equals("Name"));
		assert (insertOriginAttr.getColumnType().equals(1));
		assert (insertOriginAttr.getSample().equals("HNK"));
		assert (insertOriginAttr.getDescription().equals("person's name"));
		assert (insertOriginAttr.getRowOrder().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOriginAttr.setAttrName("Age");
		OriginAttrManager.updateOriginAttr(insertOriginAttr);

		OriginAttr updatedOriginAttr = OriginAttrManager.selectOriginAttrById(originAttr.getOriginAttrId());

		assert (null != updatedOriginAttr);
		assert (updatedOriginAttr.getAttrName().equals("Age"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testOriginAttrD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginAttr originAttr = new OriginAttr();
		originAttr.setOriginTableId(1);
		originAttr.setAttrName("Name");
		originAttr.setColumnType(1);
		originAttr.setRowOrder(2);
		originAttr.setDescription("person's name");

		OriginAttrManager.insertOriginAttr(originAttr);
		OriginAttr planDeletedOriginAttr = OriginAttrManager.selectOriginAttrById(originAttr.getOriginAttrId());
		assert (null != planDeletedOriginAttr);

		OriginAttrManager.deleteOriginAttr(originAttr.getOriginAttrId());
		OriginAttr deletedOriginAttr = OriginAttrManager.selectOriginAttrById(originAttr.getOriginAttrId());

		assert (null == deletedOriginAttr);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");

	}

	@Test
	public void testGetOAttrByOTableNameAndDSInfoId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		String originTableName = "HKSJZ";
		int dSInfoId = 1;
		List<OriginAttr> originAttrs = OriginAttrManager.getOAttrByOTableNameAndDSInfoId(
				originTableName, dSInfoId);

		for (int i = 0; i < 2; i++) {
			OriginAttr originAttr = originAttrs.get(i);
			logger.info("originAttr === " + originAttr.getAttrName());
		}

	}

	@Test
	public void testAddBatchOriginAttrs() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		List<OriginAttr> originAttrList = new ArrayList<>();

		OriginAttr originAttr = new OriginAttr();
		originAttr.setOriginTableId(1);
		originAttr.setAttrName("Name1");
		originAttr.setColumnType(1);
		originAttr.setRowOrder(2);
		originAttr.setDescription("person's name1");

		OriginAttr originAttr1 = new OriginAttr();
		originAttr1.setOriginTableId(1);
		originAttr1.setAttrName("Name2");
		originAttr1.setColumnType(1);
		originAttr1.setRowOrder(3);
		originAttr1.setDescription("person's name2");

		originAttrList.add(originAttr);
		originAttrList.add(originAttr1);

		OriginAttrManager.addBatchOriginAttrs(originAttrList);
		logger.info("===== " + originAttr.getOriginAttrId());

		OriginAttr insertOriginAttr = OriginAttrManager.selectOriginAttrById(15);

		assert (null != insertOriginAttr);
		assert (insertOriginAttr.getOriginTableId().equals(1));
		assert (insertOriginAttr.getAttrName().equals("Name1"));
		assert (insertOriginAttr.getColumnType().equals(1));
		assert (insertOriginAttr.getDescription().equals("person's name1"));
		assert (insertOriginAttr.getRowOrder().equals(2));

		OriginAttr insertOriginAttr1 = OriginAttrManager.selectOriginAttrById(originAttr1.getOriginAttrId());

		assert (null != insertOriginAttr1);
		assert (insertOriginAttr1.getOriginTableId().equals(1));
		assert (insertOriginAttr1.getAttrName().equals("Name2"));
		assert (insertOriginAttr1.getColumnType().equals(1));
		assert (insertOriginAttr1.getDescription().equals("person's name2"));
		assert (insertOriginAttr1.getRowOrder().equals(3));



	}

}
