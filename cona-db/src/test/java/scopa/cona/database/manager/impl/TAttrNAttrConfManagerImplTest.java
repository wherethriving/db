package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.constant.AttrConfNameId;
import scopa.cona.database.manager.TAttrNAttrConfManager;
import scopa.cona.database.model.TAttrNAttrConf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TAttrNAttrConfManagerImplTest {

	public static final Logger logger = Logger.getLogger(TAttrNAttrConfManagerImplTest.class);

	@Autowired
	protected TAttrNAttrConfManager tAttrNAttrConfManager;

	@Test
	public void testTAttrNattrConfCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
		tAttrNAttrConf.setAttrConfId(3);
		tAttrNAttrConf.setTargetAttrId(2);
		tAttrNAttrConf.setConfValue("false");

		tAttrNAttrConfManager.insertTAttrNAttrConf(tAttrNAttrConf);
		TAttrNAttrConf insertTAttrNConf = tAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != insertTAttrNConf);
		assert (insertTAttrNConf.getAttrConfId().equals(3));
		assert (insertTAttrNConf.getTargetAttrId().equals(2));
		assert (insertTAttrNConf.getConfValue().equals("false"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		tAttrNAttrConf.setTargetAttrId(3);
		tAttrNAttrConfManager.updateTAttrNAttrConf(tAttrNAttrConf);

		TAttrNAttrConf uTAttrNConf = tAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != uTAttrNConf);
		assert (uTAttrNConf.getTargetAttrId().equals(3));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testTAttrNattrConfD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
		tAttrNAttrConf.setAttrConfId(3);
		tAttrNAttrConf.setTargetAttrId(2);

		tAttrNAttrConfManager.insertTAttrNAttrConf(tAttrNAttrConf);
		TAttrNAttrConf insertTAttrNConf = tAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != insertTAttrNConf);

		tAttrNAttrConfManager.deleteTAttrNAttrConf(tAttrNAttrConf.getAttrConfMappingId());
		TAttrNAttrConf dTAttrNConf = tAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null == dTAttrNConf);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testAddAttrConfValueByTAttrAndMap()  {

		Integer targetAttrId = 2;
		Map<Integer, Object> attrConfValueMap = new HashMap<>();
		attrConfValueMap.put(AttrConfNameId.primaryName.toInt(), "false");
		attrConfValueMap.put(AttrConfNameId.timeFormat.toInt(), "yyyy-MM-dd HH:mm:ss");

		tAttrNAttrConfManager.addAttrConfValueByTAttrAndMap(targetAttrId, attrConfValueMap);
	}

	@Test
	public void testAddBatchAttrConfValueByTAttrIdAndAttrConfValueMap()  {
		List<Map<Integer, Map<Integer, Object>>> attrConfValueMapList = new ArrayList<>();
		Map<Integer, Map<Integer, Object>> attrConfValueMapWithAttrId = new HashMap<>();

		Map<Integer, Object> attrConfValueMap = new HashMap<>();
		attrConfValueMap.put(AttrConfNameId.primaryName.toInt(), "false");
		attrConfValueMap.put(AttrConfNameId.timeFormat.toInt(), "yyyy-MM-dd HH:mm:ss");
		attrConfValueMapWithAttrId.put(2, attrConfValueMap);
		attrConfValueMapList.add(attrConfValueMapWithAttrId);

		Map<Integer, Object> attrConfValueMap1 = new HashMap<>();
		attrConfValueMap1.put(AttrConfNameId.primaryName.toInt(), "true");
		attrConfValueMap1.put(AttrConfNameId.timeFormat.toInt(), "yyyy-MM-dd HH:mm:ss test");
		attrConfValueMapWithAttrId.put(3, attrConfValueMap1);

		tAttrNAttrConfManager.addBatchAttrConfValueByTAttrIdAndAttrConfValueMap(attrConfValueMapList);
	}
}
