package com.apache.book.dahuadesignmode.factory.abstractfactory;

import com.apache.book.dahuadesignmode.bean.User;

/**
 * Created by 01370340 on 2018/3/25.
 */

public class SqlServerUser implements IUser {
    @Override
    public void insertUser(User user) {
        System.out.println("SqlServerUser insertUser");
    }

    @Override
    public User getUser(int id) {
        System.out.println("SqlServerUser getUser");

        return null;
    }
}
