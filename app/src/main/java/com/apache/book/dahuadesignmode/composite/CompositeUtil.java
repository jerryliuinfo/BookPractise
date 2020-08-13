package com.apache.book.dahuadesignmode.composite;

/**
 * Created by jerryliu on 2017/8/23.
 */

public class CompositeUtil {
    public static String getLine(int depth){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            buffer.append("-");
        }
        return buffer.toString();
    }
}
