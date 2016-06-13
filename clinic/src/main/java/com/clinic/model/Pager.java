/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.model;

import java.io.Serializable;
import java.util.List;

import com.clinic.common.Constants;

/**
 * 分页模型
 * 
 * @version 2016年5月22日下午4:42:04
 * @author guangxi.zhang
 */
public class Pager<T extends Model<PK>, PK extends Serializable> implements Serializable {
    
    private static final long serialVersionUID = 4074758085772040889L;
    
    /** 每页显示记录数 */
    private int pageSize = Constants.PAGE_SIZE;
    
    /** 当前页 */
    private int currentPage = 1;
    
    /** 总页数 */
    private int totalPage;
    
    /** 总记录数 */
    private int totalRecord;
    
    /** 当前页开始记录 */
    private int pageOffSet;
    
    /** 当前页到达记录 */
    private int pageTail;
    
    /** 页面显示分页按钮个数 */
    private int pageButtonNum = 6;
    
    /** 开始分页数字 */
    private int startIndex;
    
    /** 结束分页数字 */
    private int endIndex;
    
    /** 显示分页的页数数组 */
    private int[] indexs;
    
    /** 返回的结果集 */
    private List<T> list;
    
    /** 返回的结果集(对象模型结果集数据) */
    private List<?> list2;
    
    /** 排序字段 */
    private String orderField;
    
    /** 排序升降序(默认:升) */
    private static boolean orderDirection;
    
    /** 业务ID */
    protected PK id;
    
    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }
    
    /**
     * @return the totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }
    
    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    /**
     * @return the totalRecord
     */
    public int getTotalRecord() {
        return totalRecord;
    }
    
    /**
     * @param totalRecord the totalRecord to set
     */
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        this.doPage();
    }
    
    protected void doPage() {
        /** 根据总记录数,计算总页数 */
        this.totalPage = (this.totalRecord % this.pageSize == 0) ? (this.totalRecord / this.pageSize)
                : (this.totalRecord / this.pageSize + 1);
        /** 根据当前页计算 起始记录与结束记录索引 */
        this.pageOffSet = (this.currentPage - 1) * this.pageSize;
        this.pageTail = (this.pageOffSet + this.pageSize > totalRecord) ? totalRecord
                : (this.pageOffSet + this.pageSize);
    }
    
    /**
     * @return the pageOffSet
     */
    public int getPageOffSet() {
        this.pageOffSet = (this.currentPage - 1) * this.pageSize;
        return pageOffSet;
    }
    
    /**
     * @param pageOffSet the pageOffSet to set
     */
    public void setPageOffSet(int pageOffSet) {
        this.pageOffSet = pageOffSet;
    }
    
    /**
     * @return the pageTail
     */
    public int getPageTail() {
        return pageTail;
    }
    
    /**
     * @param pageTail the pageTail to set
     */
    public void setPageTail(int pageTail) {
        this.pageTail = pageTail;
    }
    
    /**
     * @return the pageButtonNum
     */
    public int getPageButtonNum() {
        return pageButtonNum;
    }
    
    /**
     * @param pageButtonNum the pageButtonNum to set
     */
    public void setPageButtonNum(int pageButtonNum) {
        this.pageButtonNum = pageButtonNum;
    }
    
    /**
     * 开始按钮显示页码随着当前页数的变化
     * 
     * @return the startIndex
     */
    public int getStartIndex() {
        startIndex = currentPage - (pageButtonNum / 2);
        if (startIndex < 1) {
            startIndex = 1;
        }
        return startIndex;
    }
    
    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    
    /**
     * @return the endIndex
     */
    public int getEndIndex() {
        if (getStartIndex() < 1) {
            setStartIndex(1);
        }
        // 结束分页数显示(如果(开始分页数+分页按钮显示数）小于总页数,则结束分页数为(开始分页数+分页按钮显示数),否则显示总页数
        endIndex = (getStartIndex() + pageButtonNum <= getTotalPage() ? (getStartIndex() + pageButtonNum)
                : getTotalPage());
        return endIndex;
    }
    
    /**
     * @param endIndex the endIndex to set
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    
    /**
     * 将当前页码按钮显示页码数存入到显示分页的页数疏散组
     * 
     * @return the indexs
     */
    public int[] getIndexs() {
        int len = getEndIndex() - getStartIndex() + 1;
        if (len < 7) {
            startIndex = getStartIndex() - (7 - len);
        }
        if (startIndex <= 0) {
            startIndex = 1;
        }
        len = endIndex - startIndex + 1;
        indexs = new int[len];
        for (int i = 0; i < len; i++) {
            indexs[i] = (startIndex + i);
        }
        return indexs;
    }
    
    /**
     * @param indexs the indexs to set
     */
    public void setIndexs(int[] indexs) {
        this.indexs = indexs;
    }
    
    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }
    
    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }
    
    /**
     * @return the list2
     */
    public List<?> getList2() {
        return list2;
    }
    
    /**
     * @param list2 the list2 to set
     */
    public void setList2(List<?> list2) {
        this.list2 = list2;
    }
    
    /**
     * @return the id
     */
    public PK getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(PK id) {
        this.id = id;
    }
    
    /**
     * @return the orderField
     */
    public String getOrderField() {
        return orderField;
    }
    
    /**
     * @param orderField the orderField to set
     */
    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }
    
    /**
     * @return the orderDirection
     */
    public static boolean isOrderDirection() {
        return orderDirection;
    }
    
    /**
     * @param orderDirection the orderDirection to set
     */
    public static void setOrderDirection(boolean orderDirection) {
        Pager.orderDirection = orderDirection;
    }
    
    public String getMysqlQueryCondition() {
        String conditoin = "";
        if (this.orderField != null && this.orderField.length() != 0) {
            conditoin = " order by " + orderField + (orderDirection ? " asc " : " desc");
        }
        conditoin += " limit " + pageOffSet + "," + pageSize;
        return conditoin;
    }
    
}
