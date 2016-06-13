/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.exception.ServiceException;
import com.clinic.model.User;
import com.clinic.response.ResponseHandler;
import com.clinic.service.UserService;

/**
 * DoctorController
 * 
 * @version 2016年5月24日下午11:13:24
 * @author guangxi.zhang
 */
@Controller("ClinicUserController")
@RequestMapping("/clinic/user")
public class UserController extends BaseController {
    /** 初始化日志对象 */
    private final static Logger log = LoggerFactory.getLogger(UserController.class);
    
    /** 注入用户Service类 */
    @Resource(name = "userServiceImpl")
    private UserService userService;
    
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public void getUserById(@RequestHeader("token") String token, @RequestParam Long userId, HttpServletRequest request,
            HttpServletResponse response) {
        try {
            getUser(token);
            User user = userService.queryById(userId);
            ResponseHandler.responseOK(user, response);
        }
        catch (ServiceException se) {
            // 后期可以将错误信息定义为错误码
            log.error("查询用户详情失败", se);
            
        }
        catch (Exception e) {
            log.error("查询用户详情出现系统错误", e);
            ResponseHandler.responseServerError(response);
        }
    }
    
}
