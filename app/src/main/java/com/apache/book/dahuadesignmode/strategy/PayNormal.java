package com.apache.book.dahuadesignmode.strategy;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 14:16
 * @copyright TCL-MIG
 */

public class PayNormal implements Pay {
    @Override
    public double payMoney(double money) {
        return money;
    }
}
