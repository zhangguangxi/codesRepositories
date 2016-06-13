/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.dao.impl;

import org.springframework.stereotype.Repository;

import com.clinic.dao.UserDao;
import com.clinic.model.User;

/**
 * DoctorDaoImpl
 * 
 * @version 2016年5月22日上午12:12:13
 * @author guangxi.zhang
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends MyBatisDaoImpl<User, Long> implements UserDao {
    /** Mybatis 命名空间名 */
    private static String preName = UserDao.class.getName();
    
    /**
     * 【取得】MyBatis命名空间名
     */
    @Override
    protected String getPreName() {
        return preName;
    }
    
}
