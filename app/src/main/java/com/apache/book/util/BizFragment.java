package com.apache.book.util;

import android.app.Activity;
import android.support.annotation.LayoutRes;

/**
 * Created by Jerry on 2018/11/25.
 */
public class BizFragment extends BaseFragment {
    public static final String EXTRA_LAYOUTID = "layoutId";

    public static void launch(Activity from,  @LayoutRes int layoutId) {
        FragmentArgs args =  new FragmentArgs();
        args.add(EXTRA_LAYOUTID,layoutId);
        FragmentContainerActivity.launch(from,BizFragment.class,args);
    }



    @Override
    public int inflateContentId() {
        if (getArguments().containsKey(EXTRA_LAYOUTID)){
            return Integer.parseInt(String.valueOf(getArguments().get(EXTRA_LAYOUTID)));
        }
        return 0;
    }
}
