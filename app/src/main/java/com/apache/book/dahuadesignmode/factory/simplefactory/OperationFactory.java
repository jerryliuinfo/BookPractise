package com.apache.book.dahuadesignmode.factory.simplefactory;

import com.apache.book.dahuadesignmode.factory.IOperation;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 10:44
 * @copyright TCL-MIG
 */

public class OperationFactory {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_SUB = 2;
    public static final int TYPE_MULTI = 3;
    public static final int TYPE_DIV = 4;
    public static IOperation createOperation(int type){
        if (type == TYPE_ADD){
            return new OperationAdd();
        }else if (type == TYPE_SUB){
            return new OperationSub();
        }else if (type == TYPE_MULTI){
            return new OperationMulti();
        }else if (type == TYPE_DIV){
            return new OperationDiv();
        }
        return null;
    }
}
