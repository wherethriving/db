package scopa.cona.service.load;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by panda on 6/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-cxf-context.xml"})
public class LoadParseDataViewJsonTest extends TestCase {

    @Test
    public void testLoadFile() throws Exception {
        String dirPath = "/Users/panda/coding/example/json/sample/singletest";
        LoadParseDataViewJson.loadFile(dirPath);
    }
}