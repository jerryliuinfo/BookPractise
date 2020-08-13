package com.apache.book.dahuadesignmode.util;

import android.content.SharedPreferences;

/**
 * @author Jerry
 * @Description:
 * @date 2016/8/4 10:47
 * @copyright TCL-MIG
 */

public abstract class BaseSharedPrefConfigManager {
    public abstract SharedPreferences getSharedPreference();

    public boolean hasKey(String key){
        return getSharedPreference().contains(key);
    }

    public long getLongValue(String key, long defValue) {
        return getSharedPreference().getLong(key, defValue);
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        return getSharedPreference().getBoolean(key, defValue);
    }

    public int getIntValue(String key, int defValue) {
        return getSharedPreference().getInt(key, defValue);
    }

    public String getStringValue(String key, String defValue) {
        return getSharedPreference().getString(key, defValue);
    }


    public void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putBoolean(key, value);
        SharePreferenceUtil.applyToEditor(editor);
    }

    public void setLongValue(String key, long value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putLong(key, value);
        SharePreferenceUtil.applyToEditor(editor);
    }

    public void setIntValue(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putInt(key, value);
        SharePreferenceUtil.applyToEditor(editor);
    }

    public void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putString(key, value);
        SharePreferenceUtil.applyToEditor(editor);
    }
}
