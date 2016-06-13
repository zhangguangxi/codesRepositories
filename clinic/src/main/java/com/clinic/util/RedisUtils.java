/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.clinic.common.SpringContextHolder;
import com.clinic.exception.ServiceException;

/**
 * RedisUtils
 * 
 * @version 2016年5月22日下午3:23:01
 * @author guangxi.zhang
 */
public class RedisUtils {
    private static LogTool log = LogTool.getInstance(RedisUtils.class);
    
    /**
     * 
     * 【保存到redis】
     * 
     * @version 2016年5月22日下午3:32:38
     * @author guangxi.zhang
     * @param key
     * @param obj
     * @param dbnum
     * @throws ServiceException
     */
    public static void saveAttributeForHashDb(String key, Serializable obj, int dbnum) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        redisTemplate.opsForValue().set(key, obj);
    }
    
    /**
     * 【获取缓存ForHash】
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static Object getAttributeForHash(String key, Object hashKey) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        return redisTemplate.opsForHash().get(key, hashKey);
    }
    
    /**
     * 【保存缓存ForHash】
     * 
     * @param key
     * @param obj
     * @return
     * @throws Exception
     */
    public static Object setAttributeForHash(String key, Object hashKey, Object value) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        redisTemplate.opsForHash().put(key, hashKey, value);
        return value;
    }
    
    /**
     * 【删除缓存ForHash】
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static boolean removeAttributeForHash(String key, Object hashKey) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        try {
            redisTemplate.opsForHash().delete(key, hashKey);
            return true;
        }
        catch (Exception e) {
            log.error("删除缓存失败，key=" + key + ",hashKey=" + hashKey, e);
            return false;
        }
    }
    
    /**
     * 【删除缓存，一次删除一组缓存，真实环境必须禁用！ForHash】
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static boolean removeAttributeForHash(String key) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        try {
            Set<Object> objs = redisTemplate.opsForHash().keys(key);
            if (null == objs)
                return true;
            for (Object object : objs) {
                redisTemplate.opsForHash().delete(key, object);
            }
            return true;
        }
        catch (Exception e) {
            log.error("删除缓存失败，key=" + key, e);
            return false;
        }
    }
    
    /**
     * 
     * 【获取缓存键集合ForHash】
     * 
     * @param key 分组key
     * @return
     * @throws ServiceException
     */
    public static Set<Object> getHashKeyListForHash(String key) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        return redisTemplate.opsForHash().keys(key);
    }
    
    /**
     * 【删除缓存value】
     * 
     * @param key 键
     * @param groupId 分组ID
     * @throws ServiceException
     */
    public static void removeValue(String key, String groupId) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        redisTemplate.delete(groupId + key);
    }
    
    /**
     * 【获取缓存value】
     * 
     * @param key 键
     * @param groupId 分组ID
     * @return 值
     * @throws ServiceException
     */
    public static Serializable getValue(String key, String groupId) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        return redisTemplate.opsForValue().get(groupId + key);
    }
    
    /**
     * 
     * 【保存缓存value】
     * 
     * @param key 键
     * @param groupId 分组ID
     * @param value 值
     * @param timeout 过期时间：分钟
     * @throws ServiceException
     */
    public static void setValue(String key, String groupId, Serializable value, long timeout) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        redisTemplate.opsForValue().set(groupId + key, value, timeout, TimeUnit.MINUTES);
    }
    
    /**
     * 保存缓存 没有过期时间 【】
     * 
     * @param key
     * @param groupId
     * @param value
     * @throws ServiceException
     */
    public static void setValue(String key, String groupId, Serializable value) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        redisTemplate.opsForValue().set(groupId + key, value);
    }
    
    /**
     * 
     * 【获取所有session】
     * 
     * @param groupId
     * @return
     * @throws Exception
     */
    public static List<Serializable> getValues(String groupId) throws ServiceException {
        RedisTemplate<Serializable, Serializable> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        List<Serializable> serializables = new ArrayList<Serializable>();
        Set<Serializable> keys = (Set<Serializable>) redisTemplate.keys(groupId + "*");
        if (keys == null || keys.isEmpty()) {
            return null;
        }
        Iterator<Serializable> iterator = keys.iterator();
        while (iterator.hasNext()) {
            serializables.add(redisTemplate.opsForValue().get(iterator.next()));
        }
        return serializables;
    }
    
}
