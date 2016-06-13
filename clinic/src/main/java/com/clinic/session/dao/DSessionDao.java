/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.session.dao;

import java.util.List;

import com.clinic.exception.DaoException;
import com.clinic.exception.ServiceException;
import com.clinic.model.DSession;

/**
 * DSessionDao
 * 
 * @version 2016年5月22日下午3:13:42
 * @author guangxi.zhang
 */
public interface DSessionDao {
    
    /**
     * 【获取session】(这里用一句话描述这个方法的作用)
     * 
     * @param sid
     * @return
     * @throws RpcException
     */
    public DSession getSession(String sid) throws ServiceException;
    
    /**
     * 【保存session】(这里用一句话描述这个方法的作用)
     * 
     * @param sid
     * @return
     * @throws RpcException
     */
    public void saveSession(DSession s) throws ServiceException;
    
    /**
     * 【保存session】(这里用一句话描述这个方法的作用)
     * 
     * @param sid
     * @param minute 过期时间 分钟
     * @return
     * @throws RpcException
     */
    public void saveSession(DSession s, int minute) throws ServiceException;
    
    /**
     * 【删除一个session】(这里用一句话描述这个方法的作用)
     * 
     * @param sid
     * @throws RpcException
     */
    public boolean removeSession(String sid) throws ServiceException;
    
    /**
     * 
     * 【取得所有session】
     * 
     * @return
     * @throws DaoException
     */
    public List<DSession> getAllSession() throws ServiceException;
}
