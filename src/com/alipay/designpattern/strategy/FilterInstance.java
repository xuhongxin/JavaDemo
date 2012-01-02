/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.designpattern.strategy;

import com.alipay.designpattern.strategy.UtilTools.Element;

/**
 * @author hongxin.xu
 * @version $Id: FilterInstance.java, v 0.1 2011-12-27 обнГ9:18:23 hongxin.xu Exp $
 */
public class FilterInstance implements Element<DataModel> {

    /**
     * @see com.alipay.designpattern.strategy.UtilTools.Element#accept(java.lang.Object)
     */
    @Override
    public boolean accept(DataModel t) {
        if (t.getProperty() == "Alipay") {
            return true;
        }
        return false;
    }

}
