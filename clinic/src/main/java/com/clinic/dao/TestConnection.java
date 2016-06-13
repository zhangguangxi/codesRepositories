/*
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.clinic.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * TODO:类功能介绍
 * 
 * @version 2016年6月2日下午5:31:58
 * @author guangxi.zhang
 */
public class TestConnection {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.60.94:3306/clinic?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "mysql";
    
    static {
        try {
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
            System.out.println("connection==>" + connection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        
    }
}
