package com.apache.book.dahuadesignmode.strategy;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 14:15
 * @copyright TCL-MIG
 */

public interface Pay {
    /**
     *
     * @param money 正常需要支付的钱
     * @return
     */
    double payMoney(double money);
}
