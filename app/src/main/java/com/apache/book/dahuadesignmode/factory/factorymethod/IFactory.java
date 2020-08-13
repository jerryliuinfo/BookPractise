package com.apache.book.dahuadesignmode.factory.factorymethod;

import com.apache.book.dahuadesignmode.factory.IOperation;

/**
 * Created by lenovo on 2016/11/1.
 */

public interface IFactory {
    IOperation createOperation();
}
