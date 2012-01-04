/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.eventlistener.advance;

import java.util.EventListener;

/**
 * 半岛局势的监听器。
 * 
 * @author hongxin.xu
 * @version $Id: PeninsulaEventListener.java, v 0.1 2012-1-4 下午9:41:54 hongxin.xu Exp $
 */
public interface PeninsulaEventListener<T> extends EventListener {

    /**
     * 处理半岛数据变化的Handler。
     * 
     * @param eventData
     *        半岛事件参数。
     */
    public void handler(EventData<T> eventData);

}
