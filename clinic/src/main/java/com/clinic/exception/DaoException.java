/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.exception;

import com.clinic.common.Global;

/**
 * DaoException
 * 
 * @version 2016年5月21日下午10:16:22
 * @author guangxi.zhang
 */
public class DaoException extends Exception {
    /** 对象版本编号 */
    private static final long serialVersionUID = 1725882791825940799L;
    
    /** 错误信息 */
    private String errorMessage = null;
    
    /** 概况错误信息 */
    private String errorTitle = null;
    
    /** 错误类型，缺省为0 */
    private int errorType = 0;
    
    public DaoException() {
        super();
        errorMessage = "DAO layer is Error";
    }
    
    public DaoException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    
    public DaoException(Throwable throwable) {
        super(throwable);
        errorMessage = throwable.getLocalizedMessage();
    }
    
    public DaoException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
    
    public DaoException(int errorType, String errorTitle, String errorMessage) {
        super(errorTitle);
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
    }
    
    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    /**
     * @return the errorTitle
     */
    public String getErrorTitle() {
        return errorTitle;
    }
    
    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }
    
    public int getErrorType() {
        return errorType;
    }
    
    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
    
    /** 当该异常被打印出来的时候执行 */
    public String toString() {
        StringBuffer sb = new StringBuffer(Global.EXPCEPTION_DAO);
        sb.append("*****************DaoException start***********************");
        sb.append(errorMessage);
        sb.append("\n***************DaoException end*************************");
        return sb.toString();
    }
}
