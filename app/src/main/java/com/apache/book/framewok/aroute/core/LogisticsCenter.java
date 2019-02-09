package com.apache.book.framewok.aroute.core;

import android.content.Context;
import android.net.Uri;

import com.apache.book.bean.RouteMeta;
import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.enums.TypeKind;
import com.apache.book.framewok.aroute.exception.HandlerException;
import com.apache.book.framewok.aroute.exception.NoRouteFoundException;
import com.apache.book.framewok.aroute.facade.template.IProvider;
import com.apache.book.framewok.aroute.facade.template.IRouteGroup;
import com.apache.book.framewok.aroute.launcher.ARouter;
import com.apache.book.framewok.aroute.utils.Consts;
import com.apache.book.framewok.aroute.utils.MapUtils;
import com.apache.book.framewok.aroute.utils.TextUtils;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * Created by Jerry on 2019/2/7.
 */
public class LogisticsCenter {
    private static Context mContext;
    static ThreadPoolExecutor executor;
    private static boolean registerByPlugin;
    public synchronized static void init(Context context, ThreadPoolExecutor tpe){
        mContext = context;
        executor = tpe;
    }

    public synchronized static void completion(Postcard postcard){
        if (postcard == null){
            throw new NoRouteFoundException("No postcard");
        }
        RouteMeta routeMeta = Warehouse.routes.get(postcard.getPath());
        if (routeMeta == null){
            Class<? extends IRouteGroup> groupMeta = Warehouse.groupsIndex.get(postcard.getGroup());
            if (groupMeta == null){
                throw new NoRouteFoundException(Consts.TAG + "There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
            }else {

                postcard.setDestination(routeMeta.getDestination());
                postcard.setType(routeMeta.getType());
                postcard.setPriority(routeMeta.getPriority());
                postcard.setExtra(routeMeta.getExtra());

                Uri rawUri = postcard.getUri();
                if (null != rawUri) {   // Try to set params into bundle.
                    Map<String, String> resultMap = TextUtils.splitQueryParameters(rawUri);
                    Map<String, Integer> paramsType = routeMeta.getParamsType();

                    if (MapUtils.isNotEmpty(paramsType)) {
                        // Set value by its type, just for params which annotation by @Param
                        for (Map.Entry<String, Integer> params : paramsType.entrySet()) {
                            setValue(postcard,
                                    params.getValue(),
                                    params.getKey(),
                                    resultMap.get(params.getKey()));
                        }

                        // Save params name which need auto inject.
                        postcard.getExtras().putStringArray(ARouter.AUTO_INJECT, paramsType.keySet().toArray(new String[]{}));
                    }

                    // Save raw uri
                    postcard.withString(ARouter.RAW_URI, rawUri.toString());
                }

                switch (routeMeta.getType()) {
                    case PROVIDER:  // if the route is provider, should find its instance
                        // Its provider, so it must implement IProvider
                        Class<? extends IProvider> providerMeta = (Class<? extends IProvider>) routeMeta.getDestination();
                        IProvider instance = Warehouse.providers.get(providerMeta);
                        if (null == instance) { // There's no instance of this provider
                            IProvider provider;
                            try {
                                provider = providerMeta.getConstructor().newInstance();
                                provider.init(mContext);
                                Warehouse.providers.put(providerMeta, provider);
                                instance = provider;
                            } catch (Exception e) {
                                throw new HandlerException("Init provider failed! " + e.getMessage());
                            }
                        }
                        postcard.setProvider(instance);
                        postcard.greenChannel();    // Provider should skip all of interceptors
                        break;
                    case FRAGMENT:
                        postcard.greenChannel();    // Fragment needn't interceptors
                    default:
                        break;
                }
            }
        }


    }


    /**
     * Set value by known type
     *
     * @param postcard postcard
     * @param typeDef  type
     * @param key      key
     * @param value    value
     */
    private static void setValue(Postcard postcard, Integer typeDef, String key, String value) {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return;
        }

        try {
            if (null != typeDef) {
                if (typeDef == TypeKind.BOOLEAN.ordinal()) {
                    postcard.withBoolean(key, Boolean.parseBoolean(value));
                } else if (typeDef == TypeKind.BYTE.ordinal()) {
                    postcard.withByte(key, Byte.valueOf(value));
                } else if (typeDef == TypeKind.SHORT.ordinal()) {
                    postcard.withShort(key, Short.valueOf(value));
                } else if (typeDef == TypeKind.INT.ordinal()) {
                    postcard.withInt(key, Integer.valueOf(value));
                } else if (typeDef == TypeKind.LONG.ordinal()) {
                    postcard.withLong(key, Long.valueOf(value));
                } else if (typeDef == TypeKind.FLOAT.ordinal()) {
                    postcard.withFloat(key, Float.valueOf(value));
                } else if (typeDef == TypeKind.DOUBLE.ordinal()) {
                    postcard.withDouble(key, Double.valueOf(value));
                } else if (typeDef == TypeKind.STRING.ordinal()) {
                    postcard.withString(key, value);
                } else if (typeDef == TypeKind.PARCELABLE.ordinal()) {
                    // TODO : How to description parcelable value with string?
                } else if (typeDef == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(key, value);
                } else {    // Compatible compiler sdk 1.0.3, in that version, the string type = 18
                    postcard.withString(key, value);
                }
            } else {
                postcard.withString(key, value);
            }
        } catch (Throwable ex) {
            ARouter.logger.warning(Consts.TAG, "LogisticsCenter setValue failed! " + ex.getMessage());
        }
    }

    /**
     * Suspend bussiness, clear cache.
     */
    public static void suspend() {
        Warehouse.clear();
    }
}
