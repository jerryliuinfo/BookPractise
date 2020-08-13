package com.apache.book.dahuadesignmode.factory.abstractfactory;

import com.apache.book.dahuadesignmode.bean.DepartMent;
import com.apache.book.dahuadesignmode.bean.User;

/**
 * Created by 01370340 on 2018/3/25.
 */

public class SqlServerDepartMent implements IDepartMent {

    @Override
    public void insertDepartMent(DepartMent user) {
        System.out.println("SqlServer insertDepartMent");
    }

    @Override
    public User getDepartMent(int id) {
        System.out.println("SqlServer getDepartMent");

        return null;
    }
}
