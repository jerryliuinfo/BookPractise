package com.apache.book.util;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 01370340 on 2018/11/20.
 */
public abstract class BaseFragment extends Fragment {

    public abstract int inflateContentId();

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (inflateContentId() > 0){
            ViewGroup contentView = (ViewGroup) inflater.inflate(inflateContentId(),null);
            contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup
                    .LayoutParams.MATCH_PARENT));

            mRootView = contentView;

            layoutInit();
            return contentView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    protected View getRootView(){
        return mRootView;
    }


    public  void layoutInit(){

    }


    public final <T extends View> T findViewById(@IdRes int id){
        return getRootView().findViewById(id);
    }
}
