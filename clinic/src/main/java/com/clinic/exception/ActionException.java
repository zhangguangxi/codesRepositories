/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.exception;

import com.clinic.common.Global;

/**
 * ActionException
 * 
 * @version 2016年5月23日上午12:30:37
 * @author guangxi.zhang
 */
public class ActionException extends Exception {
    private static final long serialVersionUID = 6599426383582358284L;
    /**
     * 错误信息
     */
    private String errorMessage = null;
    
    /**
     * ActionException构造函数
     */
    
    public ActionException() {
        super();
        errorMessage = "Action layer is Error!!";
    }
    
    /**
     * ActionException构造函数根据传递的异常信息
     * 
     * @param argMessage
     */
    
    public ActionException(String argMessage) {
        super(argMessage);
        errorMessage = argMessage;
    }
    
    /**
     * ActionException构造函数根据传递的异常信息
     * 
     * @param argMessage
     * @param argThr
     */
    
    public ActionException(String argMessage, Throwable argThr) {
        super(argMessage, argThr);
    }
    
    /**
     * ActionException构造函数通过传递异常对象
     * 
     * @param argThr
     */
    
    public ActionException(Throwable argThr) {
        super(argThr);
        errorMessage = argThr.getLocalizedMessage();
    }
    
    /**
     * 当该异常被打印出来的时候执行
     * 
     * @return String
     */
    
    public String toString() {
        StringBuffer sqlString = new StringBuffer(Global.EXPCEPTION_ACTION);
        sqlString.append(
                "****************************************ActionException Start****************************************\n");
        sqlString.append(errorMessage);
        sqlString.append(
                "\n****************************************ActionException End****************************************");
        return sqlString.toString();
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
