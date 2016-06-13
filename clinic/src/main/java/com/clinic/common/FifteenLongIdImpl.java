/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.common;

/**
 * 生成 15位长整形 ID
 * 
 * @version 2016年5月22日下午12:43:20
 * @author guangxi.zhang
 */
public class FifteenLongIdImpl implements FifteenLongId {
    private long workerId;
    private final static long twepoch = 1361753741828L;
    private long sequence = 0L;
    /** 机器标识位数 */
    private final static long workerIdBits = 4L;
    /** 机器ID最大值 */
    public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
    /** 毫秒内自增位 */
    private final static long sequenceBits = 10L;
    /** 机器ID偏左移12位 */
    private final static long workerIdShift = sequenceBits;
    /** 时间毫秒左移22位 */
    private final static long timestampLeftShift = sequenceBits + workerIdBits;
    /** (用一句话描述这个变量表示什么) */
    public final static long sequenceMask = -1L ^ -1L << sequenceBits;
    
    private long lastTimestamp = -1L;
    
    public FifteenLongIdImpl() {
        init(2);
    }
    
    public FifteenLongIdImpl(long workerId) {
        init(workerId);
    }
    
    private void init(long workerId) {
        if (workerId > FifteenLongIdImpl.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", FifteenLongIdImpl.maxWorkerId));
        }
        this.workerId = workerId;
    }
    
    public synchronized long nextId() {
        long timeGen = this.timeGen();
        if (this.lastTimestamp == timeGen) {
            this.sequence = (this.sequence + 1) & FifteenLongIdImpl.sequenceMask;
            if (this.sequence == 0) {
                timeGen = this.tilNextMillis(lastTimestamp);
            }
        }
        else {
            this.sequence = 0;
        }
        if (timeGen < this.lastTimestamp) {
            try {
                throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                        this.lastTimestamp - timeGen));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.lastTimestamp = timeGen;
        long nextId = ((timeGen - twepoch << timestampLeftShift)) | (this.workerId << FifteenLongIdImpl.workerIdShift)
                | (this.sequence);
        return nextId;
    }
    
    private long timeGen() {
        return System.currentTimeMillis();
    }
    
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }
    
}
