package com.apache.book.dahuadesignmode.factory.abstractfactory;

import com.apache.book.dahuadesignmode.bean.User;

/**
 * Created by 01370340 on 2018/3/25.
 */

public interface IUser {

    void insertUser(User user);

    User getUser(int id);
}
