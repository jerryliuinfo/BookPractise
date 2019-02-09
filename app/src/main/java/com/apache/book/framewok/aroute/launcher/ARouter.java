package com.apache.book.framewok.aroute.launcher;

import android.app.Application;
import android.content.Context;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.exception.InitException;
import com.apache.book.framewok.aroute.facade.callback.NavigationCallback;
import com.apache.book.framewok.aroute.facade.template.ILogger;
import com.apache.book.framewok.aroute.utils.Consts;

/**
 * Created by Jerry on 2019/2/7.
 */
public class ARouter {
    // Key of raw uri
    public static final String RAW_URI = "NTeRQWvye18AkPd6G";
    public static final String AUTO_INJECT = "wmHzgD4lOj5o4241";

    private static volatile ARouter instance = null;
    private static volatile boolean sHasInit = false;
    public static ILogger logger;
    private ARouter(){}
    public static ARouter getInstance() {
        if (!sHasInit){
            throw new InitException("ARouter::Init::Invoke init(Context) first");
        }
        else {
            if (instance == null) {
                synchronized (ARouter.class) {
                    if (instance == null){
                        instance = new ARouter();
                    }
                }
            }
        }
        return instance;
    }
    public static boolean debuggable() {
        return _ARouter.debuggable();
    }

    public static void init(Application application){
        if (!sHasInit){
            logger = _ARouter.logger;
            _ARouter.logger.info(Consts.TAG, "ARouter init start.");
            sHasInit = _ARouter.init(application);
            if (sHasInit){
            }

        }
    }

    /**
     * Launch the navigation by type
     *
     * @param service interface of service
     * @param <T>     return type
     * @return instance of service
     */
    public <T> T navigation(Class<? extends T> service) {
        return _ARouter.getInstance().navigation(service);
    }



    public Object navigation(Context mContext, int requestCode, Postcard postcard,NavigationCallback callback){
        return _ARouter.getInstance().navigation(mContext, requestCode,postcard, callback);
    }
}
