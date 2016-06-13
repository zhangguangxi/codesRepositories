/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import java.io.Serializable;

/**
 * Doctor
 * 
 * @version 2016年5月18日上午10:59:44
 * @author guangxi.zhang
 */
public class Doctor extends Model<Long> implements Serializable {
    
    /**
     * 类的版本号
     */
    private static final long serialVersionUID = 4724335939683910092L;
    
    /** 姓名 */
    private String name;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
