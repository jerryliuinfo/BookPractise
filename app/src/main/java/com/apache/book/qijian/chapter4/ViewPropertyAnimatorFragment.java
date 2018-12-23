package com.apache.book.qijian.chapter4;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apache.book.R;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/8.
 */
public class ViewPropertyAnimatorFragment extends BaseFragment {

    private TextView tv_name;

    private ImageView iv_girl;


    @Override
    public int inflateContentId() {
        return R.layout.fragment_view_property_animator;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();
        tv_name = findViewById(R.id.tv_name);
        iv_girl = findViewById(R.id.iv_girl);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });

    }

    private void doAnimation(){
        tv_name.animate().x(200).y(200);
    }

}
