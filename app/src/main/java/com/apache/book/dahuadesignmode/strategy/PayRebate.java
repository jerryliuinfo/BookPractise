package com.apache.book.dahuadesignmode.strategy;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 14:16
 * @copyright TCL-MIG
 */

public class PayRebate implements Pay {
    double rebateRate;

    public PayRebate(double rebateRate) {
        this.rebateRate = rebateRate;
    }

    @Override
    public double payMoney(double money) {
        return money * rebateRate;
    }
}
