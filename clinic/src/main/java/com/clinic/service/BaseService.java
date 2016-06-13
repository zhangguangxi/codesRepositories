/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.service;

import java.io.Serializable;

import com.clinic.exception.ServiceException;
import com.clinic.model.Model;

/**
 * 业务服务基类接口
 * 
 * @version 2016年5月22日上午8:14:56
 * @author guangxi.zhang
 */
public interface BaseService<T extends Model<PK>, PK extends Serializable> {
    /**
     * 【增加】 Model对象
     * 
     * @param model model对象
     * @throws ServiceException SERVICE异常对象
     */
    
    public T addVo(T model) throws ServiceException;
    
    /**
     * 【查询】ID值对应的VO对象
     * 
     * @param id ID值
     * @return VO VO对象
     * @throws ServiceException SERVICE异常对象
     */
    
    public T findVo(PK id, T clazz) throws ServiceException;
    
}
