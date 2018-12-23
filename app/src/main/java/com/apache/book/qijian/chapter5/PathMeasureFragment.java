package com.apache.book.qijian.chapter5;

import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.apache.book.R;
import com.apache.book.qijian.widget.PathMeasureAliPaySuccessView;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/9.
 */
public class PathMeasureFragment extends BaseFragment {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    public int inflateContentId() {
        return R.layout.fragment_path_measure;
    }

    private PathMeasureAliPaySuccessView pathMeasureAliPaySuccessView;

    @Override
    public void layoutInit() {
        super.layoutInit();

        pathMeasureAliPaySuccessView = findViewById(R.id.pathMeasureAliPaySuccessView);

        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pathMeasureAliPaySuccessView.doAgain();
            }
        });

    }
}
