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
import scopa.cona.database.model.OriginTable;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class OriginTableServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(OriginTableServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testOriginTableRestServiceCUR() {


        OriginTable originTable = new OriginTable();
        originTable.setDataSourceInfoId(1);
        originTable.setDescription("石家庄户口");
        originTable.setIncreColName("incremental");
        originTable.setIncreColType(1);
        originTable.setTbNameEn("HKSJZ");

        ResponseEntity<OriginTable> insertedOriginTable = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.origin_tables, originTable, OriginTable.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedOriginTable.getStatusCode());

        ResponseEntity<OriginTable> selectOriginTable = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.origin_tables + "/3" , OriginTable.class);

        logger.info(selectOriginTable.getStatusCode());
        logger.info(selectOriginTable.getBody().getDescription().equals("石家庄户口"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        originTable.setOriginTableId(3);
        originTable.setDescription("石家庄户口111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.origin_tables + "/3", originTable, OriginTable.class);
    }

    @Test
    public void testOriginTableRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.origin_tables + "/4", OriginTable.class);
    }

}