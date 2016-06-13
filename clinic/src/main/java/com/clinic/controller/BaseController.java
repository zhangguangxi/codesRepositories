/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinic.exception.ActionException;
import com.clinic.exception.ExceptionCode;
import com.clinic.exception.ServiceException;
import com.clinic.model.User;
import com.clinic.response.ResponseHandler;
import com.clinic.response.ResponseMessage;
import com.clinic.session.service.SessionService;
import com.clinic.util.LogTool;

/**
 * BaseController
 * 
 * @version 2016年5月22日下午1:16:43
 * @author guangxi.zhang
 */
public class BaseController {
    protected static LogTool log = LogTool.getInstance(BaseController.class);
    
    public static final String REQUEST_DATA = "data";
    
    @SuppressWarnings("unused")
    @Autowired
    private SessionService sessionService;
    
    /**
     * 
     * 取得用户id 如果返回为null则表示未登录
     * 
     * @param sessionid
     * @return
     * @throws ServiceException
     */
    protected User getUser(String sid) throws ServiceException {
        User user = null;
        /*
         * if (!StringUtils.isEmpty(sid)) { DSession session = sessionService.getSession(sid); if (null != session) { Object obj =
         * session.get(Constants.SESSION_USER); if (obj instanceof User) { return (User) obj; } } }
         */
        user = new User();
        user.setId((long) 123);
        return user;
    }
    
    public void exceptionHander(HttpServletRequest request, Exception exception, HttpServletResponse response) {
        // 记录异常日志
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = exception.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        log.error("" + sb.toString() + "" + exception.getMessage(), exception);
        // 根据不同异常类型转向不同页面
        if (exception instanceof ServiceException) {
            ServiceException e = (ServiceException) exception;
            switch (e.getErrorType()) {
            case ExceptionCode.GOODSCATEGORY_NULL_EXCEPTION:
                ResponseHandler.responseError(ResponseMessage.goodsCategory_dont_exist, response);
                break;
            case ExceptionCode.PRICE_ERROR:
                ResponseHandler.responseError(ResponseMessage.price_error, response);
                break;
            case ExceptionCode.USER_NO_LOGIN:
                ResponseHandler.responseApiLoginError(response);
                break;
            case ExceptionCode.DEL_GOODSCATEGORY_EXIST_PRODUCT:
                ResponseHandler.responseError(ResponseMessage.goodsCategory_product_error, response);
                break;
            case ExceptionCode.USER_NO_AUTHEN:
                ResponseHandler.responseError(ResponseMessage.account_no_auth, response);
                break;
            case ExceptionCode.SELLER_NO_OPEN_STORE:
                ResponseHandler.responseError(ResponseMessage.seller_no_store, response);
                break;
            case ExceptionCode.EXIST_BUSINESSLICENSENAME:
                ResponseHandler.responseError(ResponseMessage.exist_businesslicensename, response);
                break;
            case ExceptionCode.BUSINESSLICENSENAME_LENGTH_GT_30:
                ResponseHandler.responseError(ResponseMessage.businessLicenseName_length_gt_30, response);
                break;
            case ExceptionCode.BUSINESSLICENSENAME_LENGTH_LT_5:
                ResponseHandler.responseError(ResponseMessage.businessLicenseName_length_lt_5, response);
                break;
            default:
                ResponseHandler.responseServerError(response);
                break;
            }
            return;
        }
        if (exception instanceof com.alibaba.dubbo.rpc.RpcException) {
            ResponseHandler.responseServerTimeout(response);
        }
        else {
            ResponseHandler.responseServerError(response);
        }
    }
    
    /**
     * 检查登陆，TODO 这样子做有点蛋疼
     *
     * @param token token
     * @param response 响应对象
     * @throws ServiceException
     * @throws ActionException
     */
    public void checkLogin(String token, HttpServletResponse response) throws ServiceException, ActionException {
        User user = getUser(token);
        if (user == null) {
            ResponseHandler.responseError(ResponseMessage.user_not_login, response);
            throw new ActionException("用户未登陆！");
        }
    }
    
}
