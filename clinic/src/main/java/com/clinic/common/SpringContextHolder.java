/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 以静态变量保存Spring ApplicationContext，可以在任何代码任何地方任何时候取出ApplicationContext
 * 
 * @version 2016年5月21日下午11:28:47
 * @author guangxi.zhang
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;
    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
    
    /**
     * 实现ApplicationContextAware接口,注入Context到静态变量中
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("注入ApplicationContext到SpringContextHolder:" + applicationContext);
        if (SpringContextHolder.applicationContext != null) {
            logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
                    + SpringContextHolder.applicationContext);
        }
        SpringContextHolder.applicationContext = applicationContext;
    }
    
    /**
     * 实现DisposableBean接口，在Context关闭时清理静态变量
     */
    public void destroy() throws Exception {
        SpringContextHolder.clear();
    }
    
    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }
    
    /**
     * 从静态变量applicationContext中取得Bean,自动转型为所赋值对象的类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }
    
    /**
     * 从静态变量applicationContext中获取Bean，自动转型为所赋值对象的类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return (T) applicationContext.getBeansOfType(requiredType);
    }
    
    /**
     * 清除SpringContextHolder中的ApplicationContext为null
     * 
     */
    
    public static void clear() {
        logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        applicationContext = null;
    }
    
    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }
    
}
