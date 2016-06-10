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
import scopa.cona.database.model.ConfDictElement;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class ConfDictElementServiceImplTest extends TestCase {
    
    public static final Logger logger = Logger.getLogger(ConfDictElementServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testConfDictElementRestServiceCUR() {

        logger.info(this.getClass().getSimpleName() + " ==== " +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                "begin test");

        ConfDictElement insertConfDictElement = new ConfDictElement();

        insertConfDictElement.setConfDictId(1);
        insertConfDictElement.setElemValue("String");
        insertConfDictElement.setDescription("数据类型");
        insertConfDictElement.setIsDefault(false);

        ResponseEntity<ConfDictElement> confDictElement = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.conf_dict_elems, insertConfDictElement, ConfDictElement.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + confDictElement.getStatusCode());

        ResponseEntity<ConfDictElement> selectConfDictElement = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.conf_dict_elems + "/3" , ConfDictElement.class);

        logger.info(selectConfDictElement.getStatusCode());
        logger.info(selectConfDictElement.getBody().getDescription().equals("数据类型"));
        logger.info(selectConfDictElement.getBody().getIsDefault().equals(0));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        insertConfDictElement.setConfDictElemId(3);
        insertConfDictElement.setElemValue("Integer111");

        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.conf_dict_elems + "/3", insertConfDictElement, ConfDictElement.class);
    }

    @Test
    public void testConfDictElementRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.conf_dict_elems + "/4", ConfDictElement.class);
    }
}