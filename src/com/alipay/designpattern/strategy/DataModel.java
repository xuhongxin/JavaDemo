/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.designpattern.strategy;

/**
 * 需要被过滤的数据类型。
 * 
 * @author hongxin.xu
 * @version $Id: DataModel.java, v 0.1 2011-12-27 下午9:05:22 hongxin.xu Exp $
 */
public class DataModel {
    private String property;

    public DataModel(String property) {
        this.property = property;
    }

    /**
     * Getter method for property <tt>property</tt>.
     * 
     * @return property value of property
     */
    public String getProperty() {
        return property;
    }

    /**
     * Setter method for property <tt>property</tt>.
     * 
     * @param property
     *        value to be assigned to property property
     */
    public void setProperty(String property) {
        this.property = property;
    }

}
