/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者的实例。
 * <p>
 * 伟大的北朝鲜政权，是世界各国关注的焦点。 因此，在这里将其作为一个被观察者的实例。
 * </p>
 * 
 * @author hongxin.xu
 * @version $Id: ChinaObserver.java, v 0.1 2012-1-2 下午3:14:53 hongxin.xu Exp $
 */
public class NorthKoreaSubject extends Observable {

    /**
     * @see java.util.Observable#addObserver(java.util.Observer)
     */
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        super.setChanged();
    }

    /**
     * @see java.util.Observable#notifyObservers(java.lang.Object)
     */
    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    public static void main(String[] args) {
        // 声明两个观察者。
        Observer china = new ChinaObserver();
        Observer american = new AmericanObserver();

        // 添加观察者
        Observable northKoreaSubject = new NorthKoreaSubject();
        northKoreaSubject.addObserver(china);
        northKoreaSubject.addObserver(american);

        // 触发事件。
        System.out.println("Kim-Jong-II:我们有核武器了思密达！");
        northKoreaSubject.notifyObservers(PeninsulaEnum.NUCLEAR);

        // 触发事件。
        System.out.println("Kim-Jong-II:我挂了~~~");
        northKoreaSubject.notifyObservers(PeninsulaEnum.KIMJIONIIDEAD);

    }

}
