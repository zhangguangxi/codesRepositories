/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.service;

import com.clinic.exception.ServiceException;
import com.clinic.model.User;

/**
 * DoctorService
 * 
 * @version 2016年5月22日上午8:20:03
 * @author guangxi.zhang
 */
public interface UserService extends BaseService<User, Long> {
    /**
     * 
     * 增加患者
     * 
     * @version 2016年5月22日下午1:10:42
     * @author guangxi.zhang
     * @param doctor
     */
    void addUser(User user) throws ServiceException;
    
    /**
     * 
     * 根据id查询患者
     * 
     * @version 2016年5月26日上午12:13:25
     * @author guangxi.zhang
     * @param uid
     * @return
     * @throws ServiceException
     */
    User queryById(Long uid) throws ServiceException;
}
