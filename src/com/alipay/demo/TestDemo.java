/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.demo;

/**
 * @author hongxin.xu
 * @version $Id: TestDemo.java, v 0.1 2011-8-29 обнГ5:18:49 hongxin.xu Exp $
 */
public class TestDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Map<String, String> map1 = new ConcurrentHashMap<String, String>();
        // Map<String, String> map2 = new ConcurrentHashMap<String, String>();
        //
        // for (int i = 0; i < 10; i++) {
        // map1.put("key1" + i, "value1" + i);
        // }
        //
        // for (int i = 0; i < 5; i++) {
        // map2.put("key1" + i, "value2" + i);
        // }
        //
        // map2.putAll(map1);
        //
        // for (String str : map2.values()) {
        // System.out.println(str);
        // }
        int a = -67, b = 116, c = 78;
        int d = ~a | b & c;
        System.out.println(d);

    }
}
