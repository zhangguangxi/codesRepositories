/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import com.alibaba.fastjson.JSON;

/**
 * BaseModel
 * 
 * @version 2016年5月18日上午11:10:19
 * @author guangxi.zhang
 */
public class BaseModel {
    /** 主键id */
    private Integer id;
    
    /** 创建时间 */
    private String createTime;
    
    /** 更新时间 */
    private String updateTime;
    
    /** 版本号 */
    private Integer versionNo;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }
    
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    /**
     * @return the updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }
    
    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * @return the versionNo
     */
    public Integer getVersionNo() {
        return versionNo;
    }
    
    /**
     * @param versionNo the versionNo to set
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
    
    /**
     * toString方法
     */
    public String toString() {
        return JSON.toJSONString(this);
    }
}
