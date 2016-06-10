package scopa.cona.database.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import scopa.cona.database.constant.Constant;

/**
 * Created by panda on 5/9/16.
 */
@Service("springContextUtil")
public class SpringContextUtil implements ApplicationContextAware {
    public static final Logger logger = Logger.getLogger(SpringContextUtil.class);

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        if (null != applicationContext)
            SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static ApplicationContext getApplicationContextFromXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(Constant.applicationContextPath);
        return applicationContext;
    }

    public static Object getBean(String name, Class<Object> classType) throws BeansException {
        return applicationContext.getBean(name, classType);
    }
}
