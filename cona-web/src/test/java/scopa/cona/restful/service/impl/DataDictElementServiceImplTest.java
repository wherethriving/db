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
import scopa.cona.database.model.DataDictElement;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class DataDictElementServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(DataDictElementServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void testDataDictElementCUR() {

        DataDictElement dataDictElement = new DataDictElement();
        dataDictElement.setDataDictId(1);
        dataDictElement.setElementKey("大型车辆");
        dataDictElement.setElementValue("大型车");

        ResponseEntity<DataDictElement> insertedconfDictElement = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.data_dict_elems, dataDictElement, DataDictElement.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDictElement.getStatusCode());

        ResponseEntity<DataDictElement> selectConfDictElement = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.data_dict_elems + "/3" , DataDictElement.class);

        logger.info(selectConfDictElement.getStatusCode());
        logger.info(selectConfDictElement.getBody().getElementKey().equals("大型车辆"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        dataDictElement.setDataDictElementId(3);
        dataDictElement.setElementValue("大型车111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.data_dict_elems + "/3", dataDictElement, DataDictElement.class);
    }

    @Test
    public void testDataDictElementD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.data_dict_elems + "/4", DataDictElement.class);
    }
}