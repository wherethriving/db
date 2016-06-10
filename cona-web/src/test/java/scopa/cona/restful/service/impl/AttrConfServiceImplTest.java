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
import scopa.cona.database.model.AttrConf;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by panda on 5/19/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class AttrConfServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(AttrConfServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        AttrConf insertAttrConf = new AttrConf();
        insertAttrConf.setAconfNameCn("联合主键");
        insertAttrConf.setColumnType("String");
        insertAttrConf.setConfDictId(1);
        insertAttrConf.setDefaultValue("yui");
        insertAttrConf.setDescription("lian he zhu jian");
        insertAttrConf.setIsOptional(true);

        ResponseEntity<AttrConf> attrConf = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.attr_confs, insertAttrConf, AttrConf.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + attrConf.getStatusCode());

        ResponseEntity<AttrConf> selectAttrConf = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.attr_confs + "/3" , AttrConf.class);

        logger.info(selectAttrConf.getStatusCode());
        logger.info(selectAttrConf.getBody().getAconfNameCn().equals("是否UniqueKey"));
        logger.info(selectAttrConf.getBody().getDefaultValue().equals("true"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        insertAttrConf.setAttrConfId(3);
        insertAttrConf.setAconfNameCn("change联合主键");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.attr_confs + "/3", insertAttrConf, AttrConf.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.attr_confs + "/4", AttrConf.class);
    }

}