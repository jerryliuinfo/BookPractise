package com.apache.book.qijian.chapter2;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;

import com.apache.book.R;
import com.apache.book.qijian.chapter3.ObjectAnimatorView;
import com.apache.book.qijian.chapter3.evaluator.FallingBallEvaluator;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/3.
 */
public class ObjectAnimationFragment extends BaseFragment {

    private ObjectAnimatorView objectAnimatorView;
    @Override
    public int inflateContentId() {
        return R.layout.fragment_object_animator;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();

        objectAnimatorView = findViewById(R.id.objectAnimatorView);
        findViewById(R.id.btn_evaluator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });
    }

    ObjectAnimator mObjectAnimator;
    private void doAnimation(){
        mObjectAnimator = ObjectAnimator.ofObject(objectAnimatorView, "position", new FallingBallEvaluator(),new Point(100,100), new Point(200,200));
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }
}
