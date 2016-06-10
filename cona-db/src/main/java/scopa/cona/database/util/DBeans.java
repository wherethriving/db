package scopa.cona.database.util;

import org.springframework.context.ApplicationContext;

/**
 * Created by zhangdekun on 16-5-13.
 */
public final class DBeans {
    private static ApplicationContext context = SpringContextUtil.getApplicationContextFromXml();
    public static <T> T bean(Class<T> clz){
        return context.getBean(clz);
    }
}
