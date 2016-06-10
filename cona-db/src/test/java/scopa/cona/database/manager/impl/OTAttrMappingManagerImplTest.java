package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.OTAttrMapping;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OTAttrMappingManagerImplTest {

	public static final Logger logger = Logger.getLogger(OTAttrMappingManagerImplTest.class);

	@Autowired
	private scopa.cona.database.manager.OTAttrMappingManager OTAttrMappingManager;

	@Test
	public void testOTAttrMappingCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OTAttrMapping otAttrMapping = new OTAttrMapping();
		otAttrMapping.setOriginAttrId(1);
		otAttrMapping.setTargetAttrId(2);

		OTAttrMappingManager.insertOTAttrMapping(otAttrMapping);
		OTAttrMapping insertOTAttrMapping = OTAttrMappingManager.selectOTAttrMappingById(otAttrMapping.getAttrMappingId());

		assert (null != insertOTAttrMapping);
		assert (insertOTAttrMapping.getOriginAttrId().equals(1));
		assert (insertOTAttrMapping.getTargetAttrId().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOTAttrMapping.setOriginAttrId(2);
		OTAttrMappingManager.updateOTAttrMapping(insertOTAttrMapping);

		OTAttrMapping updatedOTAttrMapping = OTAttrMappingManager.selectOTAttrMappingById(otAttrMapping.getAttrMappingId());

		assert (null != updatedOTAttrMapping);
		assert (updatedOTAttrMapping.getOriginAttrId().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");

	}

	@Test
	public void testOTAttrMappingD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OTAttrMapping otAttrMapping = new OTAttrMapping();
		otAttrMapping.setOriginAttrId(1);
		otAttrMapping.setTargetAttrId(2);

		OTAttrMappingManager.insertOTAttrMapping(otAttrMapping);
		OTAttrMapping insertOTAttrMapping = OTAttrMappingManager.selectOTAttrMappingById(otAttrMapping.getAttrMappingId());

		assert (null != insertOTAttrMapping);

		OTAttrMappingManager.deleteOTAttrMapping(otAttrMapping.getAttrMappingId());
		OTAttrMapping deletedOTAttrMapping = OTAttrMappingManager.selectOTAttrMappingById(otAttrMapping.getAttrMappingId());

		assert (null == deletedOTAttrMapping);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectOTAttrMappingByTAttrId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		List<Integer> tAttrIds = new ArrayList<>();
		tAttrIds.add(2);
		tAttrIds.add(3);

		List<OTAttrMapping> otAttrMappingList = OTAttrMappingManager.getOTAttrMappingByTAttrId(tAttrIds);

		for (int i = 0; i < otAttrMappingList.size(); i++) {
			OTAttrMapping otAttrMapping = otAttrMappingList.get(i);
			logger.info("testSelectOTAttrMappingByTAttrId====" + otAttrMapping.getAttrMappingId());
		}

	}

	@Test
	public void testSelectOTAttrMappingByOAttrId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		List<Integer> oAttrIds = new ArrayList<>();
		oAttrIds.add(2);
		oAttrIds.add(3);

		List<OTAttrMapping> otAttrMappingList = OTAttrMappingManager.getOTAttrMappingByOAttrId(oAttrIds);

		for (int i = 0; i < otAttrMappingList.size(); i++) {
			OTAttrMapping otAttrMapping = otAttrMappingList.get(i);
			logger.info("testSelectOTAttrMappingByOAttrId====" + otAttrMapping.getAttrMappingId());
		}

	}

}
