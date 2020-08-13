package com.apache.book.dahuadesignmode.factory.simplefactory;

import com.apache.book.dahuadesignmode.factory.IOperation;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/29 10:40
 * @copyright TCL-MIG
 */

public class OperationSub implements IOperation {
    @Override
    public double caculate(double num1, double num2) {
        return num1 - num2;
    }
}
