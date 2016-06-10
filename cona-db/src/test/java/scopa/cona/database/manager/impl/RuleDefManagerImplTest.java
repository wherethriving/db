package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.manager.RuleDefManager;
import scopa.cona.database.model.RuleDef;
import scopa.cona.database.model.RuleParams;
import scopa.cona.database.util.JsonOperationUtil;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RuleDefManagerImplTest {

	public static final Logger logger = Logger.getLogger(RuleDefManagerImplTest.class);

	@Autowired
	public RuleDefManager ruleDefManager;

	@Test
	public void testRuleDefCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		RuleDef ruleDef = new RuleDef();
		ruleDef.setRuleName("联合主键");
		ruleDef.setRuleType("多列规则");
		ruleDef.setAnnotation("union primary key");
		ruleDef.setDescription("选择多列合并做为联合主键，并保证多列合并时是有顺序的 , 多列规则");
		List<RuleParams> generateRuleParamObjects = generateRuleParamObject();
		ruleDef.setRuleParams(generateRuleParamObjects);
//		ruleDef.setParam(ruleJsonString);

		ruleDefManager.insertRuleDef(ruleDef);

		RuleDef insertRuleDef = ruleDefManager.selectRuleDefById(ruleDef.getRuleDefId());

		assert (null != insertRuleDef);
		assert (insertRuleDef.getRuleName().equals("联合主键"));
		assert (insertRuleDef.getAnnotation().equals("union primary key"));
		assert (insertRuleDef.getRuleType().equals("多列规则"));
		assert (insertRuleDef.getDescription().equals("选择多列合并做为联合主键，并保证多列合并时是有顺序的 , 多列规则"));

		String ruleJson = insertRuleDef.getParam();
		List<RuleParams> ruleParamsList = JsonOperationUtil.getRuleParamsFromJson(ruleJson);
		insertRuleDef.setRuleParams(ruleParamsList);

		for (int i = 0; i < insertRuleDef.getRuleParams().size(); i++) {
			RuleParams tempRuleParam = ruleParamsList.get(i);
			logger.info(tempRuleParam.getParam_order());
			logger.info(tempRuleParam.getIsOption());
			logger.info(tempRuleParam.getDefaultValue());
			logger.info(tempRuleParam.getRuleDictId());

			if (i == 0) {
				assert (tempRuleParam.getParam_order().equals(1));
				assert (tempRuleParam.getIsOption().equals(true));
				assert (tempRuleParam.getRuleDictId().equals(1));
				assert (tempRuleParam.getDefaultValue().equals("great"));
			} else if (i == 1) {
				assert (tempRuleParam.getParam_order().equals(2));
				assert (tempRuleParam.getIsOption().equals(false));
				assert (tempRuleParam.getRuleDictId().equals(2));
				assert (tempRuleParam.getDefaultValue().equals("great2"));
			}

		}

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");



		insertRuleDef.setRuleType("单列规则");
		ruleDefManager.updateRuleDef(insertRuleDef);

		RuleDef updatedRuleDef = ruleDefManager.selectRuleDefById(ruleDef.getRuleDefId());

		assert (null != insertRuleDef);
		assert (insertRuleDef.getRuleType().equals("单列规则"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testRuleDefD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		RuleDef ruleDef = new RuleDef();
		ruleDef.setRuleName("联合主键");
		ruleDef.setRuleType("多列规则");
		ruleDef.setAnnotation("union primary key");
		ruleDef.setDescription("选择多列合并做为联合主键，并保证多列合并时是有顺序的 , 多列规则");
//		ruleDef.setParam("{\"params\":[{\"param_order\":1,\"default_value\":\"good\"," +
//				"\"rule_dict_id\":1,\"is_option\":false}," +
//				"{\"param_order\":2,\"default_value\":\"good\"," +
//				"\"rule_dict_id\":2,\"is_option\":true}]}");

		ruleDefManager.insertRuleDef(ruleDef);
		RuleDef insertRuleDef = ruleDefManager.selectRuleDefById(ruleDef.getRuleDefId());

		assert (null != insertRuleDef);

		ruleDefManager.deleteRuleDef(insertRuleDef.getRuleDefId());
		RuleDef deletedRuleDef = ruleDefManager.selectRuleDefById(ruleDef.getRuleDefId());

		assert (null == deletedRuleDef);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");

	}

	public String generateRuleJsonString() {
		JSONObject jsonObject = new JSONObject();
		JSONArray paramsArray = new JSONArray();

		JSONObject paramObject = new JSONObject();
		paramObject.put("param_order", new Integer(1));
		paramObject.put("is_option", new Boolean(false));
		paramObject.put("rule_dict_id", new Integer(1));
		paramObject.put("default_value", new String("first"));

		JSONObject paramObject2 = new JSONObject();
		paramObject2.put("param_order", new Integer(2));
		paramObject2.put("is_option", new Boolean(true));
		paramObject2.put("rule_dict_id", new Integer(2));
		paramObject2.put("default_value", new String("second"));

		paramsArray.add(paramObject);
		paramsArray.add(paramObject2);
		jsonObject.put("params", paramsArray);

		return jsonObject.toJSONString();
	}

	public List<RuleParams> generateRuleParamObject() {
		List<RuleParams> ruleParamsList = new ArrayList<>();
		RuleParams ruleParams = new RuleParams();
		ruleParams.setParam_order(1);
		ruleParams.setIsOption(true);
		ruleParams.setRuleDictId(1);
		ruleParams.setDefaultValue("great");

		RuleParams ruleParams2 = new RuleParams();
		ruleParams2.setParam_order(2);
		ruleParams2.setIsOption(false);
		ruleParams2.setRuleDictId(2);
		ruleParams2.setDefaultValue("great2");

		ruleParamsList.add(ruleParams);
		ruleParamsList.add(ruleParams2);
		return ruleParamsList;
	}

	public String generateRuleParamJson(List<RuleParams> ruleParamsList) {
		return JsonOperationUtil.getJsonFromObject(ruleParamsList);
	}


}
