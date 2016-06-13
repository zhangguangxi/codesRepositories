/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.common.FifteenLongId;
import com.clinic.dao.BizDao;
import com.clinic.dao.UserDao;
import com.clinic.exception.ServiceException;
import com.clinic.model.User;
import com.clinic.service.UserService;
import com.clinic.util.LogTool;

/**
 * UserServiceImpl
 * 
 * @version 2016年5月22日上午8:20:51
 * @author guangxi.zhang
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
    /** 初始化日志对象 */
    private static LogTool log = LogTool.getInstance(UserServiceImpl.class);
    
    /** 注入以上DAO接口类 */
    @Resource(name = "userDaoImpl")
    private UserDao dao;
    @Autowired
    private FifteenLongId fifteenLongId;
    
    @Override
    protected LogTool getLog() {
        return log;
    }
    
    @Override
    protected BizDao<User, Long> getDao() {
        return dao;
    }
    
    public void addUser(User user) throws ServiceException {
        user.setId(fifteenLongId.nextId());
        try {
            getDao().addVo(user);
        }
        catch (Exception e) {
            log.error(e);
            throw new ServiceException(e);
        }
    }
    
    public User queryById(Long uid) throws ServiceException {
        User user = null;
        try {
            user = getDao().findVo(uid, null);
        }
        catch (Exception e) {
            log.error(e);
            throw new ServiceException(e);
        }
        return user;
    }
    
}
