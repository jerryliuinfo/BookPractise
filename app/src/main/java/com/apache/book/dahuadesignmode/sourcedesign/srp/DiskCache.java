package com.apache.book.dahuadesignmode.sourcedesign.srp;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.apache.book.dahuadesignmode.util.NLog;

import static com.apache.book.dahuadesignmode.permission.APermissionGroupAction.TAG;

/**
 * Created by jerryliu on 2017/4/23.
 */

public class DiskCache implements IImageCache {
    private LruCache<String,Bitmap> mMemoryCache;

    public DiskCache() {
        mMemoryCache = new LruCache<>(128);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        NLog.d(TAG, "DiskCache put");
    }

    @Override
    public Bitmap get(String url) {
        NLog.d(TAG, "DiskCache get");
        return null;
    }

    public static DiskCache newInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final DiskCache sInstance = new DiskCache();
    }


}
