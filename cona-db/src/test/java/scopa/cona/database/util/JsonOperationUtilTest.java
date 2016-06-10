package scopa.cona.database.util;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import scopa.cona.database.model.RuleParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 5/18/16.
 */
public class JsonOperationUtilTest extends TestCase {

    public static final Logger logger = Logger.getLogger(JsonOperationUtilTest.class);

    @Test
    public String testGetJsonFromObject() throws Exception {
        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin test");

        List<RuleParams> ruleParamsList = generateRuleParamObject();
        String json = JsonOperationUtil.getJsonFromObject(ruleParamsList);
        logger.info("json = " + json);
        return json;
    }

    @Test
    public void testGetObjectFromJson() throws Exception {
        String jsonContent = testGetJsonFromObject();
        List<RuleParams> ruleParamsList = JsonOperationUtil.getRuleParamsFromJson(jsonContent);

        for (int i=0; i< ruleParamsList.size();i++) {
            RuleParams x = ruleParamsList.get(i);
            logger.info(x.getDefaultValue());
            logger.info(x.getIsOption());
            logger.info(x.getParam_order());
            logger.info(x.getRuleDictId());
        }

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