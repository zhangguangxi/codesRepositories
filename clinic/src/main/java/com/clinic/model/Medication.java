/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import java.math.BigDecimal;

/**
 * Medicine
 * 
 * @version 2016年5月19日下午10:37:34
 * @author guangxi.zhang
 */
public class Medication extends BaseModel {
    /** 用量 */
    private Integer useage;
    /** 总金额 */
    private BigDecimal toatlAmt;
    /** 药 */
    private Integer medcineId;
    /** 症状 */
    private Integer sympomsId;
    /** 医生 */
    private Integer doctorId;
    
    /**
     * @return the useage
     */
    public Integer getUseage() {
        return useage;
    }
    
    /**
     * @param useage the useage to set
     */
    public void setUseage(Integer useage) {
        this.useage = useage;
    }
    
    /**
     * @return the toatlAmt
     */
    public BigDecimal getToatlAmt() {
        return toatlAmt;
    }
    
    /**
     * @param toatlAmt the toatlAmt to set
     */
    public void setToatlAmt(BigDecimal toatlAmt) {
        this.toatlAmt = toatlAmt;
    }
    
    /**
     * @return the medcineId
     */
    public Integer getMedcineId() {
        return medcineId;
    }
    
    /**
     * @param medcineId the medcineId to set
     */
    public void setMedcineId(Integer medcineId) {
        this.medcineId = medcineId;
    }
    
    /**
     * @return the sympomsId
     */
    public Integer getSympomsId() {
        return sympomsId;
    }
    
    /**
     * @param sympomsId the sympomsId to set
     */
    public void setSympomsId(Integer sympomsId) {
        this.sympomsId = sympomsId;
    }
    
    /**
     * @return the doctorId
     */
    public Integer getDoctorId() {
        return doctorId;
    }
    
    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
}
