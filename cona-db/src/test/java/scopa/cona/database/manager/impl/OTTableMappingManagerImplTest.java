package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.OTTableMappingManager;
import scopa.cona.database.model.OTTableMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OTTableMappingManagerImplTest {

	public static final Logger logger = Logger.getLogger(OTTableMappingManagerImplTest.class);

	@Autowired
	private OTTableMappingManager otTableMappingManager;

	@Test
	public void testOTTableMapperCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");


		OTTableMapping otTableMapping = new OTTableMapping();
		otTableMapping.setOriginTableId(1);
		otTableMapping.setTargetTableId(1);

		otTableMappingManager.insertOTTableMapping(otTableMapping);
		OTTableMapping insertOTTableMapping = otTableMappingManager.selectOTTableMappingById(otTableMapping.getTbMappingId());

		assert (null != insertOTTableMapping);
		assert (insertOTTableMapping.getOriginTableId().equals(1));
		assert (insertOTTableMapping.getTargetTableId().equals(1));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOTTableMapping.setOriginTableId(2);
		otTableMappingManager.updateOTTableMapping(insertOTTableMapping);

		OTTableMapping updatedOTTableMapping = otTableMappingManager.selectOTTableMappingById(otTableMapping.getTbMappingId());
		assert (null != insertOTTableMapping);
		assert (updatedOTTableMapping.getOriginTableId().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testOTTableMappingD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OTTableMapping otTableMapping = new OTTableMapping();
		otTableMapping.setOriginTableId(1);
		otTableMapping.setTargetTableId(1);

		otTableMappingManager.insertOTTableMapping(otTableMapping);
		OTTableMapping insertOTTableMapping = otTableMappingManager.selectOTTableMappingById(
				otTableMapping.getTbMappingId());

		assert (null != insertOTTableMapping);

		otTableMappingManager.deleteOTTableMapping(insertOTTableMapping.getTbMappingId());
		OTTableMapping deletedOTTableMapping = otTableMappingManager.selectOTTableMappingById(
				otTableMapping.getTbMappingId());

		assert (null == deletedOTTableMapping);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
