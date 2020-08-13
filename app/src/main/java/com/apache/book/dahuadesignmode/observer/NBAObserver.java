package com.apache.book.dahuadesignmode.observer;

/**
 * @author Jerry
 * @Description:
 * @date 2016/12/4 14:24
 * @copyright TCL-MIG
 */

public class NBAObserver extends Observer {
    public NBAObserver(String name, Notifier sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction() +":" + name +"关闭NBA直播，继续工作");
    }
}
