package com.apache.book.dahuadesignmode.strategy;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 14:06
 * @copyright TCL-MIG
 */

public class StrategyContext {
    public static final int STRATEGY_NORMAL = 1;
    public static final int STRATEGY_REBATE = 2;
    public static final int STRATEGY_RETURN = 3;
    public Pay mPay;

    public StrategyContext(int type) {
        switch (type){
            case STRATEGY_NORMAL:
                mPay = new PayNormal();
                break;
            case STRATEGY_REBATE:
                mPay = new PayRebate(0.8);
                break;
            case STRATEGY_RETURN:
                mPay = new PayReturn(200,10);
                break;
        }
    }

    public double payMoney(double money){
        return mPay.payMoney(money);
    }
}
