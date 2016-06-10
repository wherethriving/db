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
import scopa.cona.database.model.OTAttrMapping;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class OTAttrMappingServiceImplTest extends TestCase {


    public static final Logger logger = Logger.getLogger(OTAttrMappingServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testOTAttrMappingCUR() {

        OTAttrMapping otAttrMapping = new OTAttrMapping();
        otAttrMapping.setOriginAttrId(1);
        otAttrMapping.setTargetAttrId(2);

        ResponseEntity<OTAttrMapping> insertedOTAttrMapping = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.ot_attr_mappings, otAttrMapping, OTAttrMapping.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedOTAttrMapping.getStatusCode());

        ResponseEntity<OTAttrMapping> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.ot_attr_mappings + "/3" , OTAttrMapping.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getOriginAttrId().equals(2));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        otAttrMapping.setAttrMappingId(3);
        otAttrMapping.setTargetAttrId(4);
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.ot_attr_mappings + "/3", otAttrMapping, OTAttrMapping.class);
    }

    @Test
    public void testOTAttrMappingD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.ot_attr_mappings + "/7", OTAttrMapping.class);
    }
}