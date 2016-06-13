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
 * @version 2016年5月19日下午11:03:49
 * @author guangxi.zhang
 */
public class Medicine extends BaseModel {
    /** 中文名 */
    private String chineseName;
    /** 英文名 */
    private String englishName;
    /** 简称 */
    private String introducesName;
    /** 位置 */
    private String position;
    /** 成本价 */
    private BigDecimal costPrice;
    /** 售价 */
    private BigDecimal salePrice;
    /** 库存 */
    private Integer inventory;
    /** 说明 */
    private String comments;
    
    /**
     * @return the chineseName
     */
    public String getChineseName() {
        return chineseName;
    }
    
    /**
     * @param chineseName the chineseName to set
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }
    
    /**
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }
    
    /**
     * @param englishName the englishName to set
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    
    /**
     * @return the introducesName
     */
    public String getIntroducesName() {
        return introducesName;
    }
    
    /**
     * @param introducesName the introducesName to set
     */
    public void setIntroducesName(String introducesName) {
        this.introducesName = introducesName;
    }
    
    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * @return the costPrice
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }
    
    /**
     * @param costPrice the costPrice to set
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    
    /**
     * @return the salePrice
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }
    
    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    /**
     * @return the inventory
     */
    public Integer getInventory() {
        return inventory;
    }
    
    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
    
    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
