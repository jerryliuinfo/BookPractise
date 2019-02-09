package com.apache.book.framewok.aroute.launcher;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.core.LogisticsCenter;
import com.apache.book.framewok.aroute.exception.HandlerException;
import com.apache.book.framewok.aroute.exception.InitException;
import com.apache.book.framewok.aroute.exception.NoRouteFoundException;
import com.apache.book.framewok.aroute.facade.callback.NavigationCallback;
import com.apache.book.framewok.aroute.facade.service.InterceptorService;
import com.apache.book.framewok.aroute.facade.service.PathReplaceService;
import com.apache.book.framewok.aroute.facade.template.ILogger;
import com.apache.book.framewok.aroute.thread.DefaultPoolExecutor;
import com.apache.book.framewok.aroute.utils.Consts;
import com.apache.book.framewok.aroute.utils.DefaultLogger;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * Created by Jerry on 2019/2/7.
 */
public class _ARouter {
    static ILogger logger = new DefaultLogger("ARouter");

    private volatile static boolean monitorMode = false;
    private volatile static boolean debuggable = false;
    private volatile static boolean autoInject = false;


    private static volatile _ARouter instance = null;
    private static volatile boolean sHasInit = false;
    private static Handler sHandler;
    private static Context sContext;

    private static InterceptorService interceptorService;

    private _ARouter(){

    }
    public static _ARouter getInstance() {
        if (!sHasInit){
            throw new InitException("ARouter::Init::Invoke init(Context) first");
        }else {
            if (instance == null) {
                synchronized (_ARouter.class) {
                    if (instance == null){
                        instance = new _ARouter();
                    }
                }
            }
        }
        return instance;
    }
    private volatile static ThreadPoolExecutor executor = DefaultPoolExecutor.getInstance();

    public static synchronized boolean init(Application application){
        sContext = application;
        LogisticsCenter.init(sContext,executor);
        sHasInit = true;
        sHandler = new Handler(Looper.getMainLooper());
        return true;
    }

    static synchronized void printStackTrace() {
        logger.showStackTrace(true);
        logger.info(Consts.TAG, "ARouter printStackTrace");
    }

    static synchronized void setExecutor(ThreadPoolExecutor tpe) {
        executor = tpe;
    }

    static synchronized void monitorMode() {
        monitorMode = true;
        logger.info(Consts.TAG, "ARouter monitorMode on");
    }

    static boolean isMonitorMode() {
        return monitorMode;
    }

    static boolean debuggable() {
        return debuggable;
    }

    static void setLogger(ILogger userLogger) {
        if (null != userLogger) {
            logger = userLogger;
        }
    }

    public void afterInit(){

    }

    protected Postcard build(Uri uri){
        if (uri == null || TextUtils.isEmpty(uri.toString())){
            throw new HandlerException("Parameter is invalid!");
        }
        PathReplaceService pService = ARouter.getInstance().navigation(PathReplaceService.class);
        if (pService != null){
            uri = pService.forUrl(uri);
        }
        return new Postcard(uri.getPath(),extractGroup(uri.getPath()),uri,null);
    }

    protected Postcard build(String path){
        if (TextUtils.isEmpty(path)){
            throw new HandlerException("Parameter is invalid!");
        }
        PathReplaceService pService = ARouter.getInstance().navigation(PathReplaceService.class);
        if (pService != null){
            path = pService.forString(path);
        }
        return build(path,extractGroup(path));
    }

    protected Postcard build(String path, String group){
        if (!TextUtils.isEmpty(path) || !TextUtils.isEmpty(group)){
            throw new HandlerException("Parameter is invalid!");
        }
        PathReplaceService pService = ARouter.getInstance().navigation(PathReplaceService.class);
        if (pService != null){
            path = pService.forString(path);
        }
        return new Postcard(path,group);

    }

    /**
     * Extract the default group from path.
     */
    private String extractGroup(String path) {
        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            throw new HandlerException(Consts.TAG + "Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }

        try {
            String defaultGroup = path.substring(1, path.indexOf("/", 1));
            if (TextUtils.isEmpty(defaultGroup)) {
                throw new HandlerException(Consts.TAG + "Extract the default group failed! There's nothing between 2 '/'!");
            } else {
                return defaultGroup;
            }
        } catch (Exception e) {
            logger.warning(Consts.TAG, "Failed to extract default group! " + e.getMessage());
            return null;
        }
    }

    protected <T> T navigation(Class<? extends T> service) {
        try {
            /*Postcard postcard = LogisticsCenter.buildProvider(service.getName());

            // Compatible 1.0.5 compiler sdk.
            // Earlier versions did not use the fully qualified name to get the service
            if (null == postcard) {
                // No service, or this service in old version.
                postcard = LogisticsCenter.buildProvider(service.getSimpleName());
            }

            if (null == postcard) {
                return null;
            }

            LogisticsCenter.completion(postcard);
            return (T) postcard.getProvider();*/
        } catch (NoRouteFoundException ex) {
            logger.warning(Consts.TAG, ex.getMessage());
            return null;
        }
        return null;
    }


    public Object navigation(Context mContext, int requestCode, Postcard postcard, NavigationCallback callback){
        return null;
    }
}
