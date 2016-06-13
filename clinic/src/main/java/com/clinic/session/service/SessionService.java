/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.session.service;

import java.util.List;

import com.clinic.exception.ServiceException;
import com.clinic.model.DSession;
import com.clinic.model.User;

/**
 * SessionService
 * 
 * @version 2016年5月22日下午1:19:56
 * @author guangxi.zhang
 */
public interface SessionService {
    /**
     * 
     * 获取User
     * 
     * @version 2016年5月22日下午1:23:48
     * @author guangxi.zhang
     * @param id
     * @return
     * @throws ServiceException
     */
    public User getSessionUser(String id) throws ServiceException;
    
    /**
     * 【获取 app session,如果不存在则创建一个新session】(这里用一句话描述这个方法的作用)
     * <p>
     * 更改session后必须调用saveSession方法
     * </p>
     * 
     * @param sid
     * @return
     * @throws RpcException
     */
    public DSession getSession(String sid) throws ServiceException;
    
    /**
     * 【保存 app session】
     * 
     * @param sid
     * @return
     * @throws RpcException
     */
    public void saveSession(DSession s) throws ServiceException;
    
    /**
     * 【保存 app session】
     * 
     * @param sid
     * @param minute 过期时间 分钟
     * @return
     * @throws RpcException
     */
    public void saveSession(DSession s, int minute) throws ServiceException;
    
    /**
     * 【新建一个 app session】
     * 
     * @return
     * @throws RpcException
     */
    public DSession newSession() throws ServiceException;
    
    /**
     * 【删除一个 app session】
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
     * @throws ServiceException
     */
    public List<DSession> getAllSession() throws ServiceException;
    
    /**
     * 
     * 【设置过期时间】
     * 
     * @param sid session id
     * @param minutes 延迟过期分钟
     * @throws ServiceException
     */
    void saveWaitTime(String sid, int minutes) throws ServiceException;
    
    /**
     * 
     * 【刷新用户】
     * 
     * @version 2016年5月22日下午3:49:36
     * @author guangxi.zhang
     * @param userID
     * @param sid
     * @throws ServiceException
     */
    void refreshUser(Long userID, String sid) throws ServiceException;
}
