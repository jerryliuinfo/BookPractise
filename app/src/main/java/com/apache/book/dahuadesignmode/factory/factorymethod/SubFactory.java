package com.apache.book.dahuadesignmode.factory.factorymethod;

import com.apache.book.dahuadesignmode.factory.IOperation;
import com.apache.book.dahuadesignmode.factory.simplefactory.OperationSub;

/**
 * Created by lenovo on 2016/11/1.
 */

public class SubFactory implements IFactory{

    @Override
    public IOperation createOperation() {
        return new OperationSub();
    }
}
