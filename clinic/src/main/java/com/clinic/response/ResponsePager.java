/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.response;

/**
 * Pager
 * 
 * @version 2016年5月23日上午12:02:10
 * @author guangxi.zhang
 */
public class ResponsePager {
    /** 当前页 */
    private int currentPage;
    
    /** 每页显示记录数 */
    private int pageSize;
    
    /** 总记录数 */
    private long totalRecord;
    
    /** 下一页 */
    private int nextPage;
    
    public ResponsePager() {
        super();
    }
    
    /**
     * @param currentPage
     * @param pageSize
     * @param totalRecord
     * @param nextPage
     */
    public ResponsePager(int currentPage, int pageSize, long totalRecord, int nextPage) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.nextPage = nextPage;
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
        this.currentPage = currentPage;
    }
    
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
     * @return the totalRecord
     */
    public long getTotalRecord() {
        return totalRecord;
    }
    
    /**
     * @param totalRecord the totalRecord to set
     */
    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }
    
    /**
     * @return the nextPage
     */
    public int getNextPage() {
        return nextPage;
    }
    
    /**
     * @param nextPage the nextPage to set
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    
}
