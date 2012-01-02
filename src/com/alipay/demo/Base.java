/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.demo;

/**
 * @author hongxin.xu
 * @version $Id: Base.java, v 0.1 2011-11-17 обнГ6:39:15 hongxin.xu Exp $
 */
public class Base {
    int w, x, y, z;

    public Base(int a, int b) {
        x = a;
        y = b;
    }

    public Base(int a, int b, int c, int d) {
        // assignment x=a, y=b
        this(a, b);
        w = d;
        z = c;
    }
}
