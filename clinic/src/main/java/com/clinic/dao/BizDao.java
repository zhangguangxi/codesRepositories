/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.dao;

import java.io.Serializable;

import com.clinic.exception.DaoException;
import com.clinic.model.Model;

/**
 * BizDao
 * 
 * @version 2016年5月22日上午12:07:45
 * @author guangxi.zhang
 */
public interface BizDao<T extends Model<PK>, PK extends Serializable> {
    
    /**
     * 
     * 【增加】VO对象
     * 
     * @version 2016年5月22日上午12:09:23
     * @author guangxi.zhang
     * @param vo
     * @return
     * @throws DaoException
     */
    public T addVo(T model) throws DaoException;
    
    /**
     * 
     * 【查询】ID值对应的VO
     * 
     * @version 2016年5月26日上午12:17:29
     * @author guangxi.zhang
     * @param id
     * @param clazz
     * @return
     * @throws DaoException
     */
    public T findVo(PK id, T clazz) throws DaoException;
    
}
