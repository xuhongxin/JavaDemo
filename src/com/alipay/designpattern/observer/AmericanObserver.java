/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 大洋彼岸的美国人民也时刻关注的北朝鲜。
 * 
 * @author hongxin.xu
 * @version $Id: AmericanObserver.java, v 0.1 2012-1-2 下午3:24:05 hongxin.xu Exp $
 */
public class AmericanObserver implements Observer {

    /**
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PeninsulaEnum) {
            PeninsulaEnum msg = (PeninsulaEnum) arg;
            if (msg == PeninsulaEnum.KIMJIONIIDEAD) {
                System.out.println("  --白宫发来贺电");
            }
            if (msg == PeninsulaEnum.NUCLEAR) {
                System.out.println("  --白宫很生气，后果很严重");
            }
        }
    }

}
