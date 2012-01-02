/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 中国作为一个观察者，时时刻刻关注着北朝鲜的动态。
 * 
 * @author hongxin.xu
 * @version $Id: ChinaObserver.java, v 0.1 2012-1-2 下午3:19:39 hongxin.xu Exp $
 */
public class ChinaObserver implements Observer {

    /**
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PeninsulaEnum) {
            PeninsulaEnum msg = (PeninsulaEnum) arg;
            if (msg == PeninsulaEnum.KIMJIONIIDEAD) {
                System.out.println("  --中国外交部发来唁电");
            }
            if (msg == PeninsulaEnum.NUCLEAR) {
                System.out.println("  --中国外交部表示谴责！");
            }
        }
    }

}
