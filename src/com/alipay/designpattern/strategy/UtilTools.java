/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.designpattern.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 调用过滤器策略的工具类。
 * 
 * @author hongxin.xu
 * @version $Id: UtilTools.java, v 0.1 2011-12-27 下午9:07:15 hongxin.xu Exp $
 */
public class UtilTools {

    /**
     * 策略接口。
     * 
     * @author hongxin.xu
     * @version $Id: UtilTools.java, v 0.1 2011-12-27 下午9:09:14 hongxin.xu Exp $
     */
    public static interface Element<T> {
        /**
         * 需要调用的策略接口。
         * 
         * @param t
         * @return
         */
        boolean accept(T t);
    }

    public static <T> List<T> filter(List<T> lists, Element<T> filter) {

        List<T> result = new ArrayList<T>();

        if (lists == null || lists.isEmpty()) {
            return result;
        }

        if (filter == null) {
            return result;
        }

        for (Iterator<T> it = lists.iterator(); it.hasNext();) {
            T next = it.next();
            if (filter.accept(next)) {
                result.add(next);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DataModel model1 = new DataModel("Taobao");
        DataModel model2 = new DataModel("Alipay");
        DataModel model3 = new DataModel("Alipay");
        DataModel model4 = new DataModel("B2B");

        List<DataModel> lists = new ArrayList<DataModel>();
        lists.add(model1);
        lists.add(model2);
        lists.add(model3);
        lists.add(model4);

        List<DataModel> result = UtilTools.filter(lists, new FilterInstance());

        System.out.println(result.size());
    }
}
