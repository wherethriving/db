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
import scopa.cona.database.model.OTTableMapping;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class OTTableMappingServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(OTTableMappingServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testOTTableMapperCUR() {

        OTTableMapping otTableMapping = new OTTableMapping();
        otTableMapping.setOriginTableId(1);
        otTableMapping.setTargetTableId(1);
        otTableMapping.setTbOrder(11);

        ResponseEntity<OTTableMapping> insertedOTTableMapping = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.ot_table_mappings, otTableMapping, OTTableMapping.class);

//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedOTTableMapping.getStatusCode());

        ResponseEntity<OTTableMapping> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.ot_table_mappings + "/3" , OTTableMapping.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getOriginTableId().equals(2));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        otTableMapping.setTbMappingId(3);
        otTableMapping.setTbOrder(111);
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.ot_table_mappings + "/3", otTableMapping, OTTableMapping.class);
    }

    @Test
    public void testOTTableMappingD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.ot_table_mappings + "/4", OTTableMapping.class);
    }
}