/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.eventlistener.advance;

import java.util.EventObject;

/**
 * 数据变更类。
 * 
 * @author hongxin.xu
 * @version $Id: EventData.java, v 0.1 2012-1-4 下午9:14:44 hongxin.xu Exp $
 */
public class EventData<T> extends EventObject {

    /** serial ID。 */
    private static final long serialVersionUID = 4037290219070223508L;

    /** 变更数据。 */
    private T                 changeData;

    /**
     * @param source
     */
    public EventData(Object source) {
        super(source);
    }

    public EventData(Object source, T changeData) {
        super(source);
        changeData = changeData;
    }

    /**
     * Getter method for property <tt>changeData</tt>.
     * 
     * @return property value of changeData
     */
    public T getChangeData() {
        return changeData;
    }

    /**
     * Setter method for property <tt>changeData</tt>.
     * 
     * @param changeData
     *        value to be assigned to property changeData
     */
    public void setChangeData(T changeData) {
        this.changeData = changeData;
    }

    /**
     * 返回当前对象的字符串表示。
     * 
     * @see java.util.EventObject#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "[changeData=" + changeData + "]";
    }

}
