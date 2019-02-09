package com.apache.book.framewok.aroute.facade.service;

import android.net.Uri;

import com.apache.book.framewok.aroute.facade.template.IProvider;

/**
 * Created by Jerry on 2019/2/6.
 * Prepare your path
 */
public interface PathReplaceService extends IProvider {

    String forString(String path);

    Uri forUrl(Uri uri);
}
