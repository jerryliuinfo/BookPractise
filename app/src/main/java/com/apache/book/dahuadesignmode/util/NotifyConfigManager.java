package com.apache.book.dahuadesignmode.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.apache.book.MyApplication;

;

/**
 * @author Jerry
 * @Description:
 * @date 2016/10/20 15:30
 * @copyright TCL-MIG
 */

public  class NotifyConfigManager extends BaseSharedPrefConfigManager {
    public static final String NOTIFY_PARAM_CONFIG_SP_NAME = "cloud_contrl_common";

    private SharedPreferences sharedPreference;
    @Override
    public SharedPreferences getSharedPreference() {
        if (sharedPreference == null){
            sharedPreference = MyApplication.getContext().getSharedPreferences(NOTIFY_PARAM_CONFIG_SP_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreference;
    }
    private static NotifyConfigManager instance = null;
    private NotifyConfigManager(){}
    public static NotifyConfigManager getInstance() {
            if (instance == null) {
                synchronized (NotifyConfigManager.class) {
                    if (instance == null){
                        instance = new NotifyConfigManager();
                    }
            }
        }
        return instance;
    }


}
