package com.apache.book.dahuadesignmode.strategy;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 14:16
 * @copyright TCL-MIG
 */

public class PayReturn implements Pay {
    double mConditionMoney;
    double mReturnMoney;

    public PayReturn(double mConditionMoney, double mReturnMoney) {
        this.mConditionMoney = mConditionMoney;
        this.mReturnMoney = mReturnMoney;
    }

    @Override
    public double payMoney(double money) {
        double result = money;
        if (money >= mConditionMoney){
            result = money - (money / mConditionMoney) * mReturnMoney;
        }
        return result ;
    }
}
