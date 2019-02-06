package com.apache.book.framewok.aroute.facade.service;

import android.net.Uri;

/**
 * Created by Jerry on 2019/2/6.
 * Prepare your path
 */
public interface PreReplaceService extends IProvider {

    String forString(String path);

    Uri forUrl(Uri uri);
}
