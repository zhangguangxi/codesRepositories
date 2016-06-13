/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.dao.impl;

import java.io.Serializable;

import com.clinic.common.Global;
import com.clinic.dao.AbstractDao;
import com.clinic.dao.BizDao;
import com.clinic.exception.DaoException;
import com.clinic.model.Model;

/**
 * MyBatisDaoImpl
 * 
 * @version 2016年5月22日上午12:14:43
 * @author guangxi.zhang
 */
public abstract class MyBatisDaoImpl<T extends Model<PK>, PK extends Serializable> extends AbstractDao<T, PK>
        implements BizDao<T, PK> {
        
    @SuppressWarnings("unchecked")
    public T addVo(T model) throws DaoException {
        try {
            return (T) getMyBatisTemplate().add(getPreName(), Global.MYBTS_ADD_MODLE, model);
        }
        catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    public T findVo(PK id, T clazz) throws DaoException {
        try {
            return (T) getMyBatisTemplate().findModelBySqlId(getPreName(), Global.MYBTS_FIND_VO, id);
        }
        catch (Exception e) {
            throw new DaoException();
        }
    }
    
}
