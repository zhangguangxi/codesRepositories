/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.clinic.util.UUIDFactory;

/**
 * DSession
 * 
 * @version 2016年5月22日下午1:25:43
 * @author guangxi.zhang
 */
public class DSession implements Serializable {
    private static final long serialVersionUID = -1998879393680800196L;
    /** sessionId */
    private String id;
    
    /** 创建时间 */
    private long createTime;
    
    /** 最后操作时间 */
    private long OperationTime;
    
    /** 失效时间 */
    private long failureTime;
    
    /** session 存储数据 */
    private Map<String, Object> map;
    
    public DSession() {
        super();
        id = UUIDFactory.newUUID();
        createTime = new Date().getTime();
        map = new HashMap<String, Object>();
    }
    
    /**
     * 
     * 【保存】(session 保存数据)
     * 
     * @version 2016年5月22日下午3:05:02
     * @author guangxi.zhang
     * @param key
     * @param obj
     */
    public void save(String key, Object obj) {
        map.put(key, obj);
    }
    
    /**
     * 【删除】(删除session数据)
     * 
     * @version 2016年5月22日下午3:06:34
     * @author guangxi.zhang
     * @param key
     */
    public void del(String key) {
        map.remove(key);
    }
    
    /**
     * 
     * 【查询】(得到session数据)
     * 
     * @version 2016年5月22日下午3:07:41
     * @author guangxi.zhang
     * @param key
     * @return
     */
    public Object get(String key) {
        return map.get(key);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public long getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    
    public long getOperationTime() {
        return OperationTime;
    }
    
    public void setOperationTime(long operationTime) {
        OperationTime = operationTime;
    }
    
    public long getFailureTime() {
        return failureTime;
    }
    
    public void setFailureTime(long failureTime) {
        this.failureTime = failureTime;
    }
    
    public Map<String, Object> getMap() {
        return map;
    }
    
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    
}
