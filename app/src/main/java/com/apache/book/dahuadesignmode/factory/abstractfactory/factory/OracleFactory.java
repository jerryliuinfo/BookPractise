package com.apache.book.dahuadesignmode.factory.abstractfactory.factory;

import com.apache.book.dahuadesignmode.factory.abstractfactory.IDepartMent;
import com.apache.book.dahuadesignmode.factory.abstractfactory.IUser;
import com.apache.book.dahuadesignmode.factory.abstractfactory.OracleDepartMent;
import com.apache.book.dahuadesignmode.factory.abstractfactory.OracleUser;

/**
 * Created by 01370340 on 2018/3/25.
 */

public class OracleFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }

    @Override
    public IDepartMent createDepartMent() {
        return new OracleDepartMent();
    }
}
