package com.apache.book.dahuadesignmode.factory.factorymethod;

import com.apache.book.dahuadesignmode.factory.IOperation;
import com.apache.book.dahuadesignmode.factory.simplefactory.OperationMulti;

/**
 * Created by lenovo on 2016/11/1.
 */

public class MultiFactory implements IFactory{

    @Override
    public IOperation createOperation() {
        return new OperationMulti();
    }
}
