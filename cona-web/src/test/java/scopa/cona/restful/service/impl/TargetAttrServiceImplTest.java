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
import scopa.cona.database.model.TargetAttr;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class TargetAttrServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(TargetAttrServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        TargetAttr targetAttr = new TargetAttr();
        targetAttr.setTargetTableId(1);
        targetAttr.setAttrNameCn("群组名称");
        targetAttr.setAttrNameEn("qzmc");
        targetAttr.setColumnType("String");
        targetAttr.setOriginTbIsExisted(true);
        targetAttr.setDescription("group");

        ResponseEntity<TargetAttr> insertedTargetAttr = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.target_attrs, targetAttr, TargetAttr.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedTargetAttr.getStatusCode());

        ResponseEntity<TargetAttr> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.target_attrs + "/3" , TargetAttr.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getAttrNameCn().equals("群组名称"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        targetAttr.setTargetAttrId(3);
        targetAttr.setAttrNameEn("qzmc11111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.target_attrs + "/3", targetAttr, TargetAttr.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.target_attrs + "/11", TargetAttr.class);
    }
}