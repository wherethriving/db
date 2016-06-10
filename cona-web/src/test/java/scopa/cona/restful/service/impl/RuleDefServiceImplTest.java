package scopa.cona.restful.service.impl;

import constant.Constant;
import constant.EntityUrl;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import scopa.cona.database.model.ConfDict;
import scopa.cona.database.model.RuleDef;
import scopa.cona.database.model.RuleParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class RuleDefServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(RuleDefServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRuleDefCUR() {

        RuleDef ruleDef = new RuleDef();
        ruleDef.setRuleName("联合主键");
        ruleDef.setRuleType("多列规则");
        ruleDef.setAnnotation("union primary key");
        ruleDef.setDescription("选择多列合并做为联合主键，并保证多列合并时是有顺序的 , 多列规则");
        List<RuleParams> generateRuleParamObjects = generateRuleParamObject();
        ruleDef.setRuleParams(generateRuleParamObjects);

        ResponseEntity<RuleDef> insertedRuleDef = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.rule_defs, ruleDef, RuleDef.class);

        logger.info("status === " + insertedRuleDef.getStatusCode());

        ResponseEntity<RuleDef> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.rule_defs + "/30" , RuleDef.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getRuleName().equals("联合主键"));

        ruleDef.setRuleDefId(3);
        ruleDef.setRuleType("多列规则111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.rule_defs + "/3", ruleDef, RuleDef.class);
    }

    @Test
    public void testRuleDefD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.rule_defs + "/4", RuleDef.class);
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

}