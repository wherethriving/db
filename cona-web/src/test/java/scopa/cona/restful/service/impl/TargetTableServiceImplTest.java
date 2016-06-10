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
import scopa.cona.database.model.TargetTable;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class TargetTableServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(TargetTableServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        TargetTable targetTable = new TargetTable();
        targetTable.setLabelCn("监护人");
        targetTable.setLabelEn("parent");
        targetTable.setVersion("V1.0");
        targetTable.setDescription("监护人统一视图");
        targetTable.setElementType("Entity");
        targetTable.setTbNumber(1);

        ResponseEntity<TargetTable> insertedTargetTable = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.target_tables, targetTable, TargetTable.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedTargetTable.getStatusCode());

        ResponseEntity<TargetTable> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.target_tables + "/3" , TargetTable.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getLabelEn().equals("parent"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        targetTable.setTargetTableId(3);
        targetTable.setDescription("监护人统一视图111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.target_tables + "/3", targetTable, TargetTable.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.target_tables + "/4", TargetTable.class);
    }
}