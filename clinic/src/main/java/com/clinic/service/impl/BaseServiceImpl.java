/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.service.impl;

import java.io.Serializable;

import com.clinic.common.FifteenLongId;
import com.clinic.common.FifteenLongIdImpl;
import com.clinic.common.SpringContextHolder;
import com.clinic.dao.BizDao;
import com.clinic.exception.ServiceException;
import com.clinic.model.Model;
import com.clinic.service.BaseService;
import com.clinic.util.LogTool;
import com.clinic.util.ReflectUtils;
import com.clinic.util.UUIDFactory;

/**
 * BaseServiceImpl
 * 
 * @version 2016年5月22日上午11:39:20
 * @author guangxi.zhang
 */
public abstract class BaseServiceImpl<T extends Model<PK>, PK extends Serializable> implements BaseService<T, PK> {
    /**
     * 【取得】日志对象
     * 
     * @return 日志对象
     */
    protected abstract LogTool getLog();
    
    /**
     * 【取得】业务DAO对象
     * 
     * @return 业务DAO对象
     */
    protected abstract BizDao<T, PK> getDao();
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T addVo(T model) throws ServiceException {
        try {
            if (null == model.getId() || "".equals(model.getId())) {
                Class clazz = ReflectUtils.getClassGenricType(this.getClass(), 1);
                if (null == clazz) {
                    throw new ServiceException("主键类型为空,主键=" + clazz);
                }
                else if (clazz.toString().endsWith(String.class.toString())) {
                    model.setId((PK) UUIDFactory.newUUID());
                }
                else if (clazz.toString().endsWith(Long.class.toString())) {
                    model.setId((PK) new Long(((FifteenLongId) SpringContextHolder.getApplicationContext()
                            .getBean(FifteenLongIdImpl.class)).nextId()));
                }
                else {
                    throw new ServiceException("未知的主键类型，类型=" + clazz.toString());
                }
            }
            return getDao().addVo(model);
        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    
    /**
     * 【查询】ID值对应的VO对象
     * 
     * @param id ID值
     * @return VO VO对象
     * @throws ServiceException SERVICE异常对象
     */
    public T findVo(PK id, T clazz) throws ServiceException {
        try {
            return getDao().findVo(id, clazz);
        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
