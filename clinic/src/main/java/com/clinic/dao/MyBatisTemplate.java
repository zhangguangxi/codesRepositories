/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.clinic.common.Global;
import com.clinic.exception.DaoException;
import com.clinic.model.Model;

/**
 * MyBatisTemplate
 * 
 * @version 2016年5月21日下午10:10:52
 * @author guangxi.zhang
 */
public class MyBatisTemplate<T extends Model<PK>, PK extends Serializable> extends SqlSessionDaoSupport {
    /**
     * 【增加】方法
     * 
     * @param sqlid SQL配置ID号 （必须）
     * @throws DaoException DAO异常对象
     */
    public void add(String perName, String sqlid) throws DaoException {
        if (null == sqlid || sqlid.equals(""))
            throw new DaoException(this.getClass().getName() + ".add(" + sqlid + ")传入的参数不能为空！");
        try {
            if (null != perName && !perName.equals("")) {
                sqlid = perName + Global.SPLIT_DIAN + sqlid;
            }
            @SuppressWarnings("unused")
            int result = getSqlSession().insert(sqlid);
        }
        catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    /**
     * 【增加】方法
     * 
     * @param sqlid SQL配置ID号 （必须）
     * @param obj 实体VO对象或List对象 （必须）
     * @throws DaoException DAO异常对象
     */
    @SuppressWarnings("rawtypes")
    public Object add(String perName, String sqlid, Object obj) throws DaoException {
        if (null == sqlid || sqlid.equals("") || null == obj
                || (null != obj && obj instanceof List && ((List) obj).size() == 0))
            throw new DaoException(this.getClass().getName() + ".add(" + sqlid + ", " + obj + ")传入的参数不能为空或空对象！");
        try {
            if (null != perName && !perName.equals("")) {
                sqlid = perName + Global.SPLIT_DIAN + sqlid;
            }
            getSqlSession().insert(sqlid, obj);
        }
        catch (Exception e) {
            throw new DaoException(e);
        }
        return obj;
    }
    
    /**
     * 
     * 【查询】Model对象方法
     * 
     * @version 2016年5月26日下午11:50:13
     * @author guangxi.zhang
     * @param preName
     * @param sqlId
     * @param obj 实体Model对象或List对象(必须)
     * @return T
     * @throws DaoException
     */
    public T findModelBySqlId(String preName, String sqlId, Object obj) throws DaoException {
        T reuslut = null;
        if (null == sqlId || "".equals(sqlId) || null == obj) {
            throw new DaoException(this.getClass().getName() + ".findModelBySqlId(" + sqlId + "," + ")传入的参数不能为空!");
        }
        try {
            if (null != preName && !"".equals(preName)) {
                sqlId = preName + Global.SPLIT_DIAN + sqlId;
            }
            reuslut = getSqlSession().<T> selectOne(sqlId, obj);
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return reuslut;
    }
    
}
