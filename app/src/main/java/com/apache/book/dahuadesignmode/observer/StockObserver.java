package com.apache.book.dahuadesignmode.observer;

/**
 * @author Jerry
 * @Description:
 * @date 2016/12/4 14:07
 * @copyright TCL-MIG
 */

public class StockObserver extends Observer {
    public StockObserver(String name, Notifier sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction() +":" + name +"关闭股票行情，继续工作");
    }
}
