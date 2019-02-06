package com.apache.book.framewok.aroute;

/**
 * Created by Jerry on 2019/2/6.
 */
public enum RouteType {
    ACTIVITY(0, "android.app.Activity"),
    SERVICE(1, "android.app.Service"),
    PROVIDER(2, "com.alibaba.android.arouter.facade.template.IProvider"),
    UNKNOWN(-1, "Unknown route type");
    int id;
    String clzName;


    RouteType(int id, String clzName) {
        this.id = id;
        this.clzName = clzName;
    }

    public String getClzName() {
        return clzName;
    }

    public void setClzName(String clzName) {
        this.clzName = clzName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static RouteType parse(String name){
        for (RouteType routeType : values()) {
            if (name.equals(routeType.getClzName())){
                return routeType;
            }
        }
        return null;
    }
}
