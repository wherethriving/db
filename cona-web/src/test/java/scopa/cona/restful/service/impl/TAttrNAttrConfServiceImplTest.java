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
import scopa.cona.database.model.TAttrNAttrConf;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class TAttrNAttrConfServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(TAttrNAttrConfServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testTAttrNattrConfCUR() {

        TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
        tAttrNAttrConf.setAttrConfId(3);
        tAttrNAttrConf.setTargetAttrId(2);

        ResponseEntity<TAttrNAttrConf> insertedconfDict = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.attr_conf_mappings, tAttrNAttrConf, TAttrNAttrConf.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDict.getStatusCode());

        ResponseEntity<TAttrNAttrConf> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.attr_conf_mappings + "/3" , TAttrNAttrConf.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getAttrConfId().equals(3));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        tAttrNAttrConf.setAttrConfMappingId(3);
        tAttrNAttrConf.setTargetAttrId(3);
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.attr_conf_mappings + "/3", tAttrNAttrConf, TAttrNAttrConf.class);
    }

    @Test
    public void testTAttrNattrConfD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.attr_conf_mappings + "/4", TAttrNAttrConf.class);
    }
}