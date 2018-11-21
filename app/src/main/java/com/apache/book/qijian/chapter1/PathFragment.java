package com.apache.book.qijian.chapter1;

import android.app.Activity;

import com.apache.book.R;
import com.apache.book.util.BaseFragment;
import com.apache.book.util.FragmentArgs;
import com.apache.book.util.FragmentContainerActivity;

/**
 * Created by Jerry on 2018/11/21.
 */
public class PathFragment extends BaseFragment {
    
    public static void launch(Activity from) {
        FragmentArgs args =  new FragmentArgs();
        FragmentContainerActivity.launch(from,PathFragment.class,args);
    }
    @Override
    public int inflateContentId() {
        return R.layout.fragment_chapter1_path;
    }
}
