package com.apache.book.dahuadesignmode.util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jerry
 * @Description:
 * @date 2016/8/5 15:37
 * @copyright TCL-MIG
 */

public class TimeStrUtil {
    //获得当天0点时间
    public static long getTimesmorning(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    //获得当天24点时间
    public static long getTimesnight(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    //获得当天给定小时的时间
    public static long getTimes(int hour){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }


    public static String getTodayDateStr(){
       /* String dataStr = getDateString();
        NLog.e(BaseNotifyPush.TAG, "getTodayDateStr = %s", dataStr);
        if (!TextUtils.isEmpty(dataStr)){
            return dataStr;
        }*/
        StringBuilder builder = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        builder.append(year).append("-").append(month).append("-").append(day);
        return builder.toString();
    }

    public static String getTodayDateHourStr(){
        String dataTimeStr = getDateTimeString();
        if (!TextUtils.isEmpty(dataTimeStr)){
            return dataTimeStr;
        }
        StringBuilder builder = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        builder.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour).append(":").append(minute).append(":").append(second);
        return builder.toString();
    }

    public static SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static String getDateTimeString() {
        return formatDateTime.format(new Date(System.currentTimeMillis()));// 2016-11-09  12:41
    }

    public static String getDateString() {
        return formatDate.format(new Date(System.currentTimeMillis()));// 2016-11-09
    }
}
