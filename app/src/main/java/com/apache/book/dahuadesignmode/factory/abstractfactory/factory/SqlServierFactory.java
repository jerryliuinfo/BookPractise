package com.apache.book.dahuadesignmode.factory.abstractfactory.factory;

import com.apache.book.dahuadesignmode.factory.abstractfactory.IDepartMent;
import com.apache.book.dahuadesignmode.factory.abstractfactory.IUser;
import com.apache.book.dahuadesignmode.factory.abstractfactory.SqlServerDepartMent;
import com.apache.book.dahuadesignmode.factory.abstractfactory.SqlServerUser;

/**
 * Created by 01370340 on 2018/3/25.
 */

public class SqlServierFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDepartMent createDepartMent() {
        return new SqlServerDepartMent();
    }
}
