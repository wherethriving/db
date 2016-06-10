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

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class ConfDictServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(ConfDictServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        ConfDict confDict = new ConfDict();
        confDict.setNameEn("Car");
        confDict.setNameCn("车");
        confDict.setIsType(true);
        confDict.setDescription("type列");

        ResponseEntity<ConfDict> insertedconfDict = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.conf_dicts, confDict, ConfDict.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDict.getStatusCode());

        ResponseEntity<ConfDict> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.conf_dicts + "/3" , ConfDict.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getNameEn().equals("Car"));
        logger.info(selectConfDict.getBody().getIsType().equals("2"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        confDict.setConfDictId(3);
        confDict.setDescription("type列1111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.conf_dicts + "/3", confDict, ConfDict.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.conf_dicts + "/4", ConfDict.class);
    }
}