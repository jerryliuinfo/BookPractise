package com.apache.book.dahuadesignmode.sourcedesign.srp;

import android.graphics.Bitmap;

/**
 * Created by jerryliu on 2017/4/23.
 */

public interface IImageCache {
    void put(String url, Bitmap bitmap);
    Bitmap get(String url);
}
