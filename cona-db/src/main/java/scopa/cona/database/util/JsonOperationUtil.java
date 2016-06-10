package scopa.cona.database.util;

import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import scopa.cona.util.JsonUtil;
import scopa.cona.database.model.RuleParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 5/15/16.
 */
public class JsonOperationUtil {
    public static final Logger logger = Logger.getLogger(JsonOperationUtil.class);

    public static ArrayList<RuleParams> parseRuleJsonSimpleJson(String jsonFile) {

        ArrayList ruleParamsList = new ArrayList();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) parser.parse(jsonFile);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray paramsArray  = (JSONArray) jsonObject.get("params");

        for (int i = 0; i < paramsArray.size(); i++) {
            RuleParams ruleParams = new RuleParams();
            JSONObject param = (JSONObject) paramsArray.get(i);
            Integer param_order = Integer.valueOf(param.get("param_order").toString());
            Boolean is_option = (Boolean) param.get("is_option");
            String default_value = (String) param.get("default_value");
            Integer rule_dict_id = Integer.valueOf(param.get("rule_dict_id").toString());

            ruleParams.setParam_order(param_order);
            ruleParams.setIsOption(is_option);
            ruleParams.setDefaultValue(default_value);
            ruleParams.setRuleDictId(rule_dict_id);

            ruleParamsList.add(i, ruleParams);
        }

        return ruleParamsList;
    }

    public static List<RuleParams> getRuleParamsFromJson(String jsonContent) {
        Type type = new TypeToken<List<RuleParams>>(){}.getType();
        return JsonUtil.getObjListFromStr(jsonContent, type);
    }

    public static String getJsonFromObject(List<RuleParams> ruleParams) {
        String jsonContent = JsonUtil.getStrFromObj(ruleParams);

        return jsonContent;
    }

}
