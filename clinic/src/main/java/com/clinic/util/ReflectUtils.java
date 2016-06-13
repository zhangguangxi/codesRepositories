/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * TODO:类功能介绍
 * 
 * @version 2016年5月22日下午12:02:23
 * @author guangxi.zhang
 */
public class ReflectUtils {
    /**
     * 获得超类的参数类型，取第一个参数类型
     * 
     * @param <T> 类型参数
     * @param clazz 超类类型
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassGenricType(@SuppressWarnings("rawtypes") final Class clazz) {
        return getClassGenricType(clazz, 0);
    }
    
    /**
     * 根据索引获得超类的参数类型
     * 
     * @param clazz 超类类型
     * @param index 索引
     */
    @SuppressWarnings("rawtypes")
    public static Class getClassGenricType(final Class clazz, final int index) {
        // 获得带有泛型的父类
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
