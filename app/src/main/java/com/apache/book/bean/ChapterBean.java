package com.apache.book.bean;

/**
 * Created by Jerry on 2018/11/21.
 */
public class ChapterBean {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_5 = 5;

    public ChapterBean(int type, String name) {
        this.type = type;
        this.name = name;
    }

    private int type;

    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"type\":").append(type);
        sb.append(",\"name\":\"").append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
