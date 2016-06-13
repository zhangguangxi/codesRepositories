/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.common.SpringContextHolder;
import com.clinic.model.Model;

/**
 * AbstractDao
 * 
 * @version 2016年5月21日下午10:05:46
 * @author guangxi.zhang
 */
public abstract class AbstractDao<T extends Model<PK>, PK extends Serializable> {
    
    /** 取得MyBatis的命名空间 */
    protected abstract String getPreName();
    
    private MyBatisTemplate<T, PK> myBatisTemplate;
    
    @SuppressWarnings("unused")
    private static MongoTemplate mogoTemplate;
    
    private static StringRedisTemplate stringRedisTemplate;
    
    private static RedisTemplate<Serializable, Serializable> redisTemplate;
    
    /** 用于设置redis连接数据库 */
    public static JedisConnectionFactory getRedisConnectionFactory() {
        return SpringContextHolder.getApplicationContext().getBean(JedisConnectionFactory.class);
    }
    
    /** 目前还没有找到同层调用不同数据库的方法目前采用springJDBC提供 */
    private static JdbcTemplate jdbcTemplate;
    
    public static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = SpringContextHolder.getApplicationContext().getBean(JdbcTemplate.class);
        }
        return jdbcTemplate;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public MyBatisTemplate getMyBatisTemplate() {
        if (null == myBatisTemplate) {
            myBatisTemplate = (MyBatisTemplate<T, PK>) SpringContextHolder.getBean("myBaitsTemplate");
        }
        return myBatisTemplate;
    }
    
    public static StringRedisTemplate getStringRedisTemplate() {
        if (null == stringRedisTemplate) {
            stringRedisTemplate = SpringContextHolder.getApplicationContext().getBean(StringRedisTemplate.class);
        }
        return stringRedisTemplate;
    }
    
    public static RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        if (null == redisTemplate) {
            redisTemplate = SpringContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }
    
}
