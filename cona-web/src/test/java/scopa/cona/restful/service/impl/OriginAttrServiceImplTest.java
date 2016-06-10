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
import scopa.cona.database.model.OriginAttr;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class OriginAttrServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(OriginAttrServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testOriginAttrCUR() {

        OriginAttr originAttr = new OriginAttr();
        originAttr.setOriginTableId(1);
        originAttr.setAttrName("Name");
        originAttr.setColumnType(1);
        originAttr.setRowOrder(2);
        originAttr.setDescription("person's name");

        ResponseEntity<OriginAttr> insertedconfDict = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.origin_attrs, originAttr, OriginAttr.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedconfDict.getStatusCode());

        ResponseEntity<OriginAttr> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.origin_attrs + "/3" , OriginAttr.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getAttrName().equals("Name"));
        logger.info(selectConfDict.getBody().getColumnType().equals(1));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        originAttr.setOriginAttrId(3);
        originAttr.setRowOrder(111);
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.origin_attrs + "/3", originAttr, OriginAttr.class);
    }

    @Test
    public void testOriginAttrD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.origin_attrs + "/4", OriginAttr.class);
    }

}