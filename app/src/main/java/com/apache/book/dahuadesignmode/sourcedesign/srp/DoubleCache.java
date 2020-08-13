package com.apache.book.dahuadesignmode.sourcedesign.srp;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by jerryliu on 2017/4/23.
 */

public class DoubleCache implements IImageCache {
    private MemoryCache memoryCache;
    private DiskCache diskCache;

    public DoubleCache() {
        memoryCache = new MemoryCache();
        diskCache = new DiskCache();
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
        View view;
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap1 = memoryCache.get(url);
        if (bitmap1 == null){
            bitmap1 = diskCache.get(url);
        }

        return bitmap1;
    }
}
