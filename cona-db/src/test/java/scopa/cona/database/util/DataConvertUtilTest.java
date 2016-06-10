package scopa.cona.database.util;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by panda on 5/16/16.
 */
public class DataConvertUtilTest extends TestCase {

    public static final Logger logger = Logger.getLogger(DataConvertUtilTest.class);

    @Test
    public void testImplodeExplode() {
        String[] stringDataSet = {"1","people","data"};
        String implodeResult = DataConvertUtil.implodeString(stringDataSet);
        logger.info("implodeResult = " + implodeResult);

        String[] explodeResult = DataConvertUtil.explodeString(implodeResult);
        for (String elem: explodeResult) {
            logger.info("elem = " + elem);
        }
    }
}