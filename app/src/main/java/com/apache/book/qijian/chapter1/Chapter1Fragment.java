package com.apache.book.qijian.chapter1;

import android.app.Activity;

import com.apache.book.R;
import com.apache.book.util.BaseFragment;
import com.apache.book.util.FragmentArgs;
import com.apache.book.util.FragmentContainerActivity;


public class Chapter1Fragment extends BaseFragment {



    public static void launch(Activity from) {
        FragmentArgs args =  new FragmentArgs();
        FragmentContainerActivity.launch(from,Chapter1Fragment.class,args);
    }


    @Override
    public int inflateContentId() {
        return R.layout.chapter_1;
    }
}
