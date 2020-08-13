package com.apache.book.dahuadesignmode.factory.abstractfactory;

/**
 * Created by 01370340 on 2018/3/25.
 */

public class DataAccess {



    public static final String DB_TYPE = "oracle";
    //public static final String DB_TYPE = "sqlServer";




    public static final String TYPE_ORACLE = "oracle";
    public static final String TYPE_SQLSERVER = "sqlServer";

    public static IUser createUser(){
        IUser iUser = null;
        switch (DB_TYPE){
            case TYPE_ORACLE:
                iUser =  new OracleUser();
                break;
            case TYPE_SQLSERVER:
                iUser = new SqlServerUser();
                break;
        }
        return iUser;
    }

    public static IDepartMent createDepartMent(){
        IDepartMent iDepartMent = null;
        switch (DB_TYPE){
            case TYPE_ORACLE:
                iDepartMent = new OracleDepartMent();
                break;
            case TYPE_SQLSERVER:
                iDepartMent = new SqlServerDepartMent();
                break;

        }
        return iDepartMent;
    }


    //public static final String DB_NAME = OracleUser.class.getName();
    public static final String DB_NAME = SqlServerUser.class.getName();
    public static IUser createUserByReflection(){
        IUser iuser = null;
        try {
            iuser = (IUser) Class.forName(DB_NAME).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iuser;
    }
}
