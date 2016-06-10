package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.constant.IncrementalType;
import scopa.cona.database.model.OriginTable;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OriginTableManagerImplTest {

	public static final Logger logger = Logger.getLogger(OriginTableManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.OriginTableManager OriginTableManager;

	@Test
	public void testOriginTableCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(IncrementalType.WHOLE_INCREMENTAL.toInt());
		originTable.setTbNameEn("HKSJZ");
		originTable.setTbNameCn("石家庄户口");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);
		OriginTable insertOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != insertOriginTable);
		assert (insertOriginTable.getDataSourceInfoId().equals(1));
		assert (insertOriginTable.getIsIncremental().equals(1));
		assert (insertOriginTable.getTbNameEn().equals("HKSJZ"));
		assert (insertOriginTable.getTbNameCn().equals("石家庄户口"));
		assert (insertOriginTable.getDescription().equals("石家庄户口"));
		assert (insertOriginTable.getIncreColName().equals("incremental"));
		assert (insertOriginTable.getIncreColType().equals(1));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOriginTable.setTbNameEn("NJZCP");
		OriginTableManager.updateOriginTable(insertOriginTable);

		OriginTable updatedOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != updatedOriginTable);
		assert (updatedOriginTable.getTbNameEn().equals("NJZCP"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testOriginTableD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(0);
		originTable.setTbNameEn("HKSJZ");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);
		OriginTable insertOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != insertOriginTable);

		OriginTableManager.deleteOriginTable(originTable.getOriginTableId());
		OriginTable deletedOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null == deletedOriginTable);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectOTableByName() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(0);
		originTable.setTbNameEn("HKSJZNAME");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);

		String originTableName = "HKSJZNAME";
		OriginTable selectOriginTable = OriginTableManager.
				selectOriginTableByName(originTableName);

		assert (selectOriginTable.getTbNameEn().equals("HKSJZNAME"));
		assert (selectOriginTable.getDescription().equals("石家庄户口"));
	}

	@Test
	public void testSelectOriginTableByDataSourceInfoId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(0);
		originTable.setTbNameEn("HKSJZNAME");
		originTable.setDescription("石家庄");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);

		OriginTable originTable1 = new OriginTable();
		originTable1.setDataSourceInfoId(1);
		originTable1.setIsIncremental(0);
		originTable1.setTbNameEn("HKSJZ");
		originTable1.setDescription("石家庄户口");
		originTable1.setIncreColName("incremental");
		originTable1.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable1);

		Integer dataSourceInfoId = 1;
		List<OriginTable> selectedOriginTables = OriginTableManager.
					getOriginTableByDataSourceInfoId(dataSourceInfoId);

		int size = selectedOriginTables.size();
		for (int i = size - 1; i > size - 3; i--) {
			OriginTable tAttr = selectedOriginTables.get(i);
			if (i == size - 2) {
				assert (tAttr.getTbNameEn().equals("HKSJZNAME"));
			} else if (i == size - 1) {
				assert (tAttr.getDescription().equals("石家庄户口"));
			}
		}
	}



}
