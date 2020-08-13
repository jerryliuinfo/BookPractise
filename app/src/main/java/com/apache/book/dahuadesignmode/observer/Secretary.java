package com.apache.book.dahuadesignmode.observer;

/**
 * @author Jerry
 * @Description:
 * @date 2016/12/4 14:07
 * @copyright TCL-MIG
 */

public class Secretary extends Notifier{
    @Override
    String getAction() {
        return "老板回来了";
    }
}
