package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.model.TargetTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TargetTableManagerImplTest {

	public static final Logger logger = Logger.getLogger(TargetTableManagerImplTest.class);

	@Autowired
	private TargetTableManager targetTableManager;

	@Test
	public void testTargetTableCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");


		TargetTable targetTable = new TargetTable();
		targetTable.setLabelCn("案件");
		targetTable.setLabelEn("case");
//		targetTable.setVersion(Float.valueOf("V1.0"));
		targetTable.setVersion("V1.0");
		targetTable.setDescription("案件统一视图");
		targetTable.setElementType("entity");
		targetTable.setTbNumber(2);

		targetTableManager.insertTargetTable(targetTable);
		TargetTable insertTargetTable = targetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null != insertTargetTable);
		assert (insertTargetTable.getLabelCn().equals("案件"));
		assert (insertTargetTable.getLabelEn().equals("case"));
		assert (insertTargetTable.getElementType().equals("entity"));
		assert (insertTargetTable.getTbNumber().equals(2));
		assert (insertTargetTable.getVersion().equals("V1.0"));
		assert (insertTargetTable.getDescription().equals("案件统一视图"));

		TargetTable updateTargetTable = targetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		updateTargetTable.setLabelCn("户口");
		logger.info("updateTargetTable ==== " + updateTargetTable.getLabelCn());
		targetTableManager.updateTargetTable(updateTargetTable);
		logger.info("updateTargetTable ==== " + updateTargetTable.getLabelCn());

		assert (null != updateTargetTable);
		assert (updateTargetTable.getLabelCn().equals("户口"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

	}

	@Test
	public void testTargetTableD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetTable targetTable = new TargetTable();
		targetTable.setLabelCn("监护人");
		targetTable.setLabelEn("parent");
		targetTable.setVersion("V1.0");
		targetTable.setDescription("监护人统一视图");
		targetTable.setElementType("人");
		targetTable.setTbNumber(1);

		targetTableManager.insertTargetTable(targetTable);
		TargetTable insertTargetTable = targetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null != insertTargetTable);

		targetTableManager.deleteTargetTable(targetTable.getTargetTableId());
		TargetTable dTargetTable = targetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null == dTargetTable);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectTargetTableByLabelEn() {
		String labelEn = "people";

		TargetTable selectedTargetTable = targetTableManager.getTargetTableByLabelEn(labelEn);
		assert (null != selectedTargetTable);
		assert (selectedTargetTable.getLabelEn().equals("people"));
	}

	@Test
	public void testSelectTargetTableByLabelEnElemTypeVersion() {
		String labelEn = "test";
		String elemType = "entity";
		String version = "V1.0";

		TargetTable selectedTargetTable = targetTableManager.getTargetTableByLabelEnElemTypeVersion(
				labelEn, elemType, version);
		assert (null != selectedTargetTable);
		assert (selectedTargetTable.getLabelEn().equals("test"));
	}

}
