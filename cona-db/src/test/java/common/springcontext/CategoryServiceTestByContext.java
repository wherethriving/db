package common.springcontext;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.constant.EnumBeans;
import scopa.cona.database.manager.AttrConfManager;
import scopa.cona.database.model.AttrConf;
import scopa.cona.database.model.Category;
import scopa.cona.database.util.SpringContextUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceTestByContext {

	public static final Logger logger = Logger.getLogger(CategoryServiceTestByContext.class);

	AttrConf attrConf = null;

//	ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/test/resources/test-context.xml");
//	CatgegoryManager catgegoryManager = applicationContext.getBean("catgegoryManager", CatgegoryManager.class);

	@Test
	public void testCategory() {
		AttrConfManager attrConfManager = SpringContextUtil.getApplicationContextFromXml().getBean(EnumBeans.attrConfManager.toString(), AttrConfManager.class);

		logger.info("=========== " + "testCategory" + attrConfManager);
		Category category = new Category();

	}


}
