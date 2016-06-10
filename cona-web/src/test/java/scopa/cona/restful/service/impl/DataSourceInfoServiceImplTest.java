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
import scopa.cona.database.model.DataSourceInfo;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class DataSourceInfoServiceImplTest extends TestCase {


    public static final Logger logger = Logger.getLogger(DataSourceInfoServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testDataSourceInfoCUR() {

        DataSourceInfo dataSourceInfo = new DataSourceInfo();
        dataSourceInfo.setDataSourceId(1);
        dataSourceInfo.setUrl("d1.mlamp.co");
        dataSourceInfo.setUsername("THETEST");
        dataSourceInfo.setPassword("thetest");
        dataSourceInfo.setOwner("thetest");
        dataSourceInfo.setSourceInfoName("oracle-mlamp");
        dataSourceInfo.setSchemaInput("json schema");
        dataSourceInfo.setSchemaSplit("%");

        ResponseEntity<DataSourceInfo> inserteddataSourceInfo = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.data_source_info, dataSourceInfo, DataSourceInfo.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + inserteddataSourceInfo.getStatusCode());

        ResponseEntity<DataSourceInfo> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.data_source_info + "/3" , DataSourceInfo.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getUrl().equals("d1.mlamp.co"));


//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        dataSourceInfo.setDataSourceInfoId(3);
        dataSourceInfo.setUsername("gooogle111");
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.data_source_info + "/3", dataSourceInfo, DataSourceInfo.class);
    }

    @Test
    public void testDataSourceInfoD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.data_source_info + "/4", DataSourceInfo.class);
    }

}