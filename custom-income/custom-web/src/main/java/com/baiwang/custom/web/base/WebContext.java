package com.baiwang.custom.web.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WebContext extends RequestContext implements ApplicationContextAware{
    private static ApplicationContext springContext;

    private WebContext()
    {
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException
    {
        WebContext.springContext = applicationContext;
    }

    public static ApplicationContext getSpringContext()
    {
        return WebContext.springContext;
    }

    public static <T> T getBean(Class<T> clazz)
    {
        return springContext.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static  <T> T getBean(String beanName)
    {
        return (T)springContext.getBean(beanName);
    }

}
