package common.util;


import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import scopa.cona.database.model.RuleParams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by panda on 5/13/16.
 */
public class JsonTest {
    public static final Logger logger = Logger.getLogger(JsonTest.class);

    @Test
    public void testJson() {
        writeToJsonFile("/Users/panda/coding/example/json/testwrite.json");

        try {
            parseJsonFilePath("/Users/panda/coding/example/json/rule.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseJsonFilePath(String jsonFilePath) throws IOException {
        String jsonFile = readFile(jsonFilePath);
        parseJsonSimpleJson(jsonFile);
    }

    public String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public ArrayList<RuleParams> parseJsonSimpleJson(String jsonFile) {
        ArrayList ruleParamsList = new ArrayList(3);
        logger.info("jsonfile\n" + jsonFile);
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

            logger.info("i" + i);
            logger.info("param_order" + param_order);
            logger.info("is_option" + is_option);
            logger.info("default_value" + default_value);
            logger.info("rule_dict_id" + rule_dict_id);

            logger.info("param_order" + ruleParams.getParam_order());
            logger.info("is_option" + ruleParams.getIsOption());
            logger.info("default_value" + ruleParams.getDefaultValue());
            logger.info("rule_dict_id" + ruleParams.getRuleDictId());
        }

        return ruleParamsList;

    }

    public void writeToJsonFile(String jsonFilePath) {

        System.out.print("writeToJsonFile");

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
        paramObject2.put("default_value", new String("good"));


        paramsArray.add(paramObject);
        paramsArray.add(paramObject2);
        jsonObject.put("params", paramsArray);

        try {
            FileWriter jsonFile = new FileWriter(jsonFilePath);
            jsonFile.write(jsonObject.toJSONString());
            jsonFile.flush();
            jsonFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
