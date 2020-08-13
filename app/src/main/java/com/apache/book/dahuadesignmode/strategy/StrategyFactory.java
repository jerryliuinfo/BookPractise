package com.apache.book.dahuadesignmode.strategy;

/**
 * Created by jerryliu on 2017/7/15.
 */

public class StrategyFactory {
    public static final int STRATEGY_NORMAL = 1;
    public static final int STRATEGY_REBATE = 2;
    public static final int STRATEGY_RETURN = 3;
    public static Pay createPay(int type){
        switch (type){
            case STRATEGY_NORMAL:
                return new PayNormal();
            case STRATEGY_REBATE:
                return new PayRebate(0.8);
            case STRATEGY_RETURN:
                return new PayReturn(200,10);
        }
        return null;
    }
}
