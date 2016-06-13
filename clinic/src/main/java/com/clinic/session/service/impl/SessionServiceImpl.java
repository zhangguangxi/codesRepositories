/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.session.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.clinic.common.Constants;
import com.clinic.exception.ServiceException;
import com.clinic.model.DSession;
import com.clinic.model.User;
import com.clinic.session.dao.DSessionDao;
import com.clinic.session.service.SessionService;

/**
 * SessionServiceImpl
 * 
 * @version 2016年5月22日下午3:09:25
 * @author guangxi.zhang
 */
@Service("sessionServiceImpl")
public class SessionServiceImpl implements SessionService {
    @Resource(name = "dSessionDaoImpl")
    private DSessionDao dao;
    
    public User getSessionUser(String sid) throws ServiceException {
        User user = null;
        if (!StringUtils.isEmpty(sid)) {
            DSession session = dao.getSession(sid);
            if (null != session) {
                Object obj = session.get(Constants.SESSION_USER);
                if (obj instanceof User) {
                    return (User) obj;
                }
            }
        }
        return user;
    }
    
    public DSession getSession(String sid) throws ServiceException {
        DSession session = dao.getSession(sid);
        return session;
    }
    
    public void saveSession(DSession s) throws ServiceException {
        s.setOperationTime(new Date().getTime());
        dao.saveSession(s);
    }
    
    public void saveSession(DSession s, int minute) throws ServiceException {
        dao.saveSession(s, minute);
    }
    
    public DSession newSession() throws ServiceException {
        DSession session = new DSession();
        saveSession(session);
        return session;
    }
    
    public boolean removeSession(String sid) throws ServiceException {
        return dao.removeSession(sid);
    }
    
    public List<DSession> getAllSession() throws ServiceException {
        return dao.getAllSession();
    }
    
    public void saveWaitTime(String sid, int minutes) throws ServiceException {
    
    }
    
    public void refreshUser(Long userID, String sid) throws ServiceException {
    
    }
}
