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
import scopa.cona.database.constant.DataSourceType;
import scopa.cona.database.model.ConfDict;
import scopa.cona.database.model.DataSource;

/**
 * Created by panda on 5/23/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class DataSourceServiceImplTest extends TestCase {

    public static final Logger logger = Logger.getLogger(DataSourceServiceImplTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testAttrConfRestServiceCUR() {

        DataSource dataSource = new DataSource();
        dataSource.setSourceName(DataSourceType.ORACLE.toString());
        dataSource.setSampleValue("d195.mlamp.co");

        ResponseEntity<DataSource> insertedDataSource = restTemplate.postForEntity(Constant.localhostBaseUrl + EntityUrl.data_sources, dataSource, DataSource.class);


//        assert (attrConf.getStatusCode().equals(204));
        logger.info("status === " + insertedDataSource.getStatusCode());

        ResponseEntity<DataSource> selectConfDict = restTemplate.getForEntity(
                Constant.localhostBaseUrl + EntityUrl.data_sources + "/3" , DataSource.class);

        logger.info(selectConfDict.getStatusCode());
        logger.info(selectConfDict.getBody().getSampleValue().equals("d195.mlamp.co"));

//        assertThat(attrConf.getStatusCode(), equalTo(HttpStatus.OK));

        dataSource.setDataSourceId(3);
        dataSource.setSourceName(DataSourceType.EXCEL.toString());
        restTemplate.put(
                Constant.localhostBaseUrl + EntityUrl.data_sources + "/3", dataSource, DataSource.class);
    }

    @Test
    public void testAttrConfRestServiceD() {

        restTemplate.delete(Constant.localhostBaseUrl + EntityUrl.data_sources + "/4", DataSource.class);
    }

}