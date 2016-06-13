/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.util;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * UUIDFactory
 * 
 * @version 2016年5月22日下午12:22:58
 * @author guangxi.zhang
 */
public class UUIDFactory {
    /**
     * 生产UUID 部署前须校准服务器时钟 *
     * 
     * @return
     */
    public static String newUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
    
    public static void main(String[] args) {
        // 正确性测试
        String uuid = newUUID();
        System.out.println("uuid.length()=" + uuid.length() + " : " + uuid);
        
        // 并发测试(20个线程，每个线程产生10UUid)
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                public void run() {
                    int j = 1;
                    while (j <= 7) {
                        System.out.println(j + "-" + newUUID());
                        j++;
                    }
                }
            });
        }
        pool.shutdown();
    }
}
