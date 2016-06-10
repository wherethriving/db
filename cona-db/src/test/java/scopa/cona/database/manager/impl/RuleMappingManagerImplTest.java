package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.RuleMappingManager;
import scopa.cona.database.model.RuleMapping;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RuleMappingManagerImplTest {

	public static final Logger logger = Logger.getLogger(RuleMappingManagerImplTest.class);

	@Autowired
	private RuleMappingManager ruleMappingManager;

	@Test
	public void testRuleMappingCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		RuleMapping ruleMapping = new RuleMapping();
		ruleMapping.setAttrMappingId(2);
		ruleMapping.setRuleDefId(1);
		ruleMapping.setParamValue("1,people");
		ruleMapping.setRuleOrder(1);

		ruleMappingManager.insertRuleMapping(ruleMapping);
		RuleMapping insertRuleMapping = ruleMappingManager.selectRuleMappingById(ruleMapping.getRuleMappingId());

		assert (null != insertRuleMapping);
		assert (insertRuleMapping.getAttrMappingId().equals(2));
		assert (insertRuleMapping.getRuleDefId().equals(1));
		assert (insertRuleMapping.getParamValue().equals("1,people"));
		assert (insertRuleMapping.getRuleDefId().equals(1));
		String[] paramArray = insertRuleMapping.getParamArray();

		for (int i = 0; i < paramArray.length; i++) {
			String param = paramArray[i];
			if (i == 0) {
				assert (param.equals("1"));
			} else if (i == 1) {
				assert (param.equals("people"));
			}
		}

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertRuleMapping.setParamValue("2");
		ruleMappingManager.updateRuleMapping(insertRuleMapping);

		RuleMapping updatedRuleMapping = ruleMappingManager.selectRuleMappingById(
				ruleMapping.getRuleMappingId());

		assert (null != updatedRuleMapping);
		assert (updatedRuleMapping.getParamValue().equals("2"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");

	}

	@Test
	public void testRuleMappingD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		RuleMapping ruleMapping = new RuleMapping();
		ruleMapping.setAttrMappingId(2);
		ruleMapping.setRuleDefId(1);
		ruleMapping.setParamValue("1,people");
		ruleMapping.setRuleOrder(1);

		ruleMappingManager.insertRuleMapping(ruleMapping);
		RuleMapping insertRuleMapping = ruleMappingManager.selectRuleMappingById(ruleMapping.getRuleMappingId());

		assert (null != insertRuleMapping);

		ruleMappingManager.deleteRuleMapping(insertRuleMapping.getRuleMappingId());
		RuleMapping deletedRuleMapping = ruleMappingManager.selectRuleMappingById(ruleMapping.getRuleMappingId());

		assert (null == deletedRuleMapping);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");


	}

	@Test
	public void testSelectRuleMappingByAttrMappingId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		List<Integer> attrMappingIds = new ArrayList<>();
		attrMappingIds.add(2);
		attrMappingIds.add(3);
		attrMappingIds.add(4);

		List<RuleMapping> ruleMappings = ruleMappingManager.getRuleMappingByAttrMappingId(attrMappingIds);

		for (int i = 0; i < ruleMappings.size(); i++) {
			RuleMapping ruleMapping = ruleMappings.get(i);
			logger.info("ruleMappings == " + ruleMapping.getParamValue());
			logger.info("ruleMappings == " + ruleMapping.getParamArray().toString());
		}
	}

	@Test
	public void testGetRuleEntityByTargetTableId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

//		关键数据点信息，判断接口正确的关键数据项
//		label en = people
//		target_table_id = 1
//		target_attr_id = 2 3 4 8
//		attr_mapping_id = 2 3   8 9 10 11
//		rule_mapping_id = 1-7
//		rule_def_id = 1-5


	}

}
