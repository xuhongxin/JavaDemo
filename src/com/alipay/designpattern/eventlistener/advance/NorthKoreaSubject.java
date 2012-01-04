/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.eventlistener.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 北朝鲜作为一个这点地区，总是世界各国的关注重点。
 * 
 * @author hongxin.xu
 * @version $Id: NorthKoreaSubject.java, v 0.1 2012-1-4 下午9:11:34 hongxin.xu Exp $
 */
public class NorthKoreaSubject<T> {

    /** 半岛局势监听器列表。 */
    private List<PeninsulaEventListener<T>> eventListeners = new ArrayList<PeninsulaEventListener<T>>();

    /** 生成线程池对象。 */
    private ExecutorService                 executor       = Executors.newCachedThreadPool();

    /**
     * 触发监听器的执行。
     * 
     * @param eventData
     */
    public void publishEvent(EventData<T> eventData) {
        if (eventData == null || eventListeners.isEmpty()) {
            throw new IllegalArgumentException("Parameter is null");
        }

        for (PeninsulaEventListener<T> listener : eventListeners) {
            executor.execute(new NotifyTask(eventData, listener));
        }
    }

    /**
     * 执行多线程操作的内部类。
     * 
     * @author hongxin.xu
     * @version $Id: NorthKoreaSubject.java, v 0.1 2012-1-4 下午9:47:38 hongxin.xu Exp $
     */
    private class NotifyTask implements Runnable {

        private EventData<T>              eventData;
        private PeninsulaEventListener<T> listener;

        public NotifyTask(EventData<T> eventData, PeninsulaEventListener<T> listener) {
            this.eventData = eventData;
            this.listener = listener;
        }

        /**
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            listener.handler(eventData);
        }

    }
}
