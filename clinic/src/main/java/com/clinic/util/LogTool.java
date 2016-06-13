/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clinic.exception.ServiceException;

/**
 * 日志工具类
 * 
 * @version 2016年5月22日上午11:43:53
 * @author guangxi.zhang
 */
public class LogTool {
    
    /** 日志对象 */
    private Logger logger = LoggerFactory.getLogger(LogTool.class);
    
    @SuppressWarnings("rawtypes")
    public static LogTool getInstance(Object... objects) {
        LogTool log = new LogTool();
        if (null != objects && objects.length > 0 && objects[0] instanceof Class) {
            log.logger = LoggerFactory.getLogger((Class) objects[0]);
        }
        return log;
    }
    
    /**
     * 打印DEBUG级别日志
     * 
     * @param message 日志信息
     */
    public void debug(Object message) {
        logger.debug("☆☆☆【" + message + "】☆☆☆");
    }
    
    /**
     * 打印ERROR级别日志
     * 
     * @param message 日志信息
     */
    
    public void error(Object message, Object... objects) {
        if (null != objects && objects.length > 0 && objects[0] instanceof Throwable) {
            logger.error("◆◆◆【" + message + "】◆◆◆", (Throwable) objects[0]);
        }
        else {
            logger.error("◆◆◆【" + message + "】◆◆◆");
        }
    }
    
    /**
     * 打印ERROR级别日志
     * 
     * @param message 日志信息
     */
    
    public void error(Object message) {
        if (message instanceof Throwable) {
            logger.error("接口调用报错 ◆◆◆[" + message + "]◆◆◆", (Throwable) message);
        }
        else {
            logger.error("◆◆◆【" + message + "】◆◆◆");
        }
    }
    
    /**
     * 打印ERROR级别日志
     * 
     * @param message 日志信息
     */
    
    public void error(ServiceException message) {
        if (message.getErrorType() == 0 && message instanceof Throwable) {
            logger.error("接口调用报错 ◆◆◆[" + message + "]◆◆◆", (Throwable) message);
        }
        else {
            logger.error("◆◆◆【" + message.getErrorMessage() + "】◆◆◆");
        }
    }
    
    /**
     * 打印INFO级别日志
     * 
     * @param message 日志信息
     */
    
    public void info(Object message) {
        logger.info("★★★【" + message + "】★★★");
    }
    
    /**
     * 打印WARN级别日志
     * 
     * @param message 日志信息
     */
    
    public void warn(Object message) {
        logger.warn("※※※【" + message + "】※※※");
    }
    
    /**
     * 是否有DEBUG级别
     * 
     * @return true/false
     */
    
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }
}
