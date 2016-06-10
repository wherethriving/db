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
import scopa.cona.database.model.DataDict;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class DataDictServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(DataDictServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        DataDict dataDict = new DataDict();
        dataDict.setDictName("车辆");
        dataDict.setDictType("rule");
        dataDict.setDescription("车辆数据字典");

        ResponseEntity<DataDict> insertedconfDict = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.data_dicts, dataDict, DataDict.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDict.getStatusCode());

        ResponseEntity<DataDict> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.data_dicts + "/3" , DataDict.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getDictName().equals("车辆"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        dataDict.setDataDictId(3);
        dataDict.setDescription("车辆数据字典1111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.data_dicts + "/3", dataDict, DataDict.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.data_dicts + "/4", DataDict.class);
    }

}