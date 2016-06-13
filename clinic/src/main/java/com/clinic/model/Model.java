/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import java.io.Serializable;

/**
 * VO
 * 
 * @version 2016年5月21日下午9:50:40
 * @author guangxi.zhang
 */
public class Model<PK extends Serializable> implements Serializable {
    private static final long serialVersionUID = -8330306258381509065L;
    
    /** 业务ID */
    protected PK id;
    
    public PK getId() {
        return id;
    }
    
    public void setId(PK id) {
        this.id = id;
    }
    
    public static enum Status {
        NO(0), OK(1);
        private int value;
        
        private Status(int value) {
            this.value = value;
        }
        
        public int value() {
            return value;
        }
    }
}
