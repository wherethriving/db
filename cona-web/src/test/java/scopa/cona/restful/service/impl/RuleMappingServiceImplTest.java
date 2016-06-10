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
import scopa.cona.database.model.RuleMapping;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class RuleMappingServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(RuleMappingServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRuleMappingCUR() {

        RuleMapping ruleMapping = new RuleMapping();
        ruleMapping.setAttrMappingId(2);
        ruleMapping.setRuleDefId(1);
        ruleMapping.setParamValue("1,people");
        ruleMapping.setRuleOrder(1);

        ResponseEntity<RuleMapping> insertedconfDict = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.rule_mappings, ruleMapping, RuleMapping.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDict.getStatusCode());

        ResponseEntity<RuleMapping> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.rule_mappings + "/3" , RuleMapping.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getParamValue().equals("1,people"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        ruleMapping.setRuleMappingId(3);
        ruleMapping.setAttrMappingId(3);
        ruleMapping.setParamValue("11111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.rule_mappings + "/3", ruleMapping, RuleMapping.class);
    }

    @Test
    public void testRuleMappingD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.rule_mappings + "/4", RuleMapping.class);
    }
}