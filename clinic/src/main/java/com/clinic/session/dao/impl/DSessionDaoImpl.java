/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.session.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.clinic.exception.ServiceException;
import com.clinic.model.DSession;
import com.clinic.session.dao.DSessionDao;
import com.clinic.util.RedisUtils;

/**
 * DSessionDaoImpl
 * 
 * @version 2016年5月22日下午3:17:54
 * @author guangxi.zhang
 */
@Component("dSessionDaoImpl")
public class DSessionDaoImpl implements DSessionDao {
    private static final String SESSION_GROUP = "manage_session";
    
    public DSession getSession(String sid) throws ServiceException {
        Object obj = RedisUtils.getValue(sid, SESSION_GROUP);
        if (obj instanceof DSession) {
            DSession session = (DSession) obj;
            return session;
        }
        
        return null;
    }
    
    public void saveSession(DSession s) throws ServiceException {
        RedisUtils.setValue(s.getId(), SESSION_GROUP, s);
    }
    
    public void saveSession(DSession s, int minute) throws ServiceException {
        RedisUtils.setValue(s.getId(), SESSION_GROUP, s, minute);
    }
    
    public boolean removeSession(String sid) throws ServiceException {
        RedisUtils.removeValue(sid, SESSION_GROUP);
        return true;
    }
    
    public List<DSession> getAllSession() throws ServiceException {
        List<Serializable> values = RedisUtils.getValues(SESSION_GROUP);
        ArrayList<DSession> DSessions = new ArrayList<DSession>();
        Iterator<Serializable> it = values.iterator();
        while (it.hasNext()) {
            Serializable next = it.next();
            if (next instanceof DSession) {
                DSessions.add((DSession) next);
            }
        }
        return DSessions;
    }
}
