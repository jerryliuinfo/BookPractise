package com.apache.book.framewok.aroute.facade.service;

import android.content.Context;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.facade.template.IProvider;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface DegradeService extends IProvider {

    void onLost(Context context, Postcard postcard);
}
