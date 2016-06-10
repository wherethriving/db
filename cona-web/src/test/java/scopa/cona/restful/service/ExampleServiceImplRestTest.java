package scopa.cona.restful.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import scopa.cona.database.model.Category;
import scopa.cona.database.model.ExampleModel;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class ExampleServiceImplRestTest {

    public static final Logger logger = Logger.getLogger(ExampleServiceImplRestTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testCxfRestService() {
        ResponseEntity<ExampleModel> entity = restTemplate.getForEntity("http://127.0.0.1:8080/cona-web/services/example/1 ", ExampleModel.class);

        logger.info(entity.getStatusCode());
        logger.info(entity.getBody().getString());
        logger.info(entity.getBody().getAnInt());

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testCategoryRestService() {
        ResponseEntity<Category> entity = restTemplate.getForEntity("http://127.0.0.1:8080/cona-web/services/catgegory/1 ", Category.class);

        logger.info(entity.getStatusCode());
        logger.info(entity.getBody().getCategoryName());
        logger.info(entity.getBody().getProducts());
        logger.info(entity.getBody().getCategoryId());

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
