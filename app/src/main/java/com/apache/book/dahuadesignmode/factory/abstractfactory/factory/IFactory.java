package com.apache.book.dahuadesignmode.factory.abstractfactory.factory;

import com.apache.book.dahuadesignmode.factory.abstractfactory.IDepartMent;
import com.apache.book.dahuadesignmode.factory.abstractfactory.IUser;

/**
 * Created by 01370340 on 2018/3/25.
 */

public interface IFactory {

    IUser createUser();

    IDepartMent createDepartMent();
}
