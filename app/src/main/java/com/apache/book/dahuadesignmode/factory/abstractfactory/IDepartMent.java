package com.apache.book.dahuadesignmode.factory.abstractfactory;

import com.apache.book.dahuadesignmode.bean.DepartMent;
import com.apache.book.dahuadesignmode.bean.User;

/**
 * Created by 01370340 on 2018/3/25.
 */

public interface IDepartMent {

    void insertDepartMent(DepartMent departMent);

    User getDepartMent(int id);
}
