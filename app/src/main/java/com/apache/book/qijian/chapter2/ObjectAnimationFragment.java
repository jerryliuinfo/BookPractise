package com.apache.book.qijian.chapter2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.widget.TextView;

import com.apache.book.R;
import com.apache.book.qijian.chapter3.ObjectAnimatorView;
import com.apache.book.qijian.chapter3.evaluator.FallingBallEvaluator;
import com.apache.book.util.AnimateUtil;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/3.
 */
public class ObjectAnimationFragment extends BaseFragment {

    private ObjectAnimatorView objectAnimatorView;

    private TextView tv_desc;

    private TextView tv_desc2;
    @Override
    public int inflateContentId() {
        return R.layout.fragment_object_animator;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();

        objectAnimatorView = findViewById(R.id.objectAnimatorView);
        tv_desc = findViewById(R.id.tv_desc);
        tv_desc2 = findViewById(R.id.tv_desc2);
        findViewById(R.id.btn_evaluator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPositionAnimation();
            }
        });
        findViewById(R.id.btn_scaleSize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScaleAnimation();
            }
        });
        findViewById(R.id.btn_animator_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimationSetPlaySequentially();
            }
        });



    }

    ObjectAnimator mObjectAnimator;
    private void doPositionAnimation(){
        mObjectAnimator = ObjectAnimator.ofObject(objectAnimatorView, "position", new FallingBallEvaluator(),
                new Point(0,0), new Point(500,500));
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }
    private void doScaleAnimation(){
        mObjectAnimator = ObjectAnimator.ofFloat(objectAnimatorView, "scaleSize", 0.8f);
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }


    private void doAnimationSetPlaySequentially(){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator tvBgAnimator = ObjectAnimator.ofInt(tv_desc,AnimateUtil.PROPERTY_BACKGROUND_COLOR,
                0xffff00ff,0xffffff00,0xffff00ff);
        tvBgAnimator.setDuration(4000);
        tvBgAnimator.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator tranlationXAnimator = ObjectAnimator.ofFloat(tv_desc,AnimateUtil.PROPERTY_TRANSLATION_Y,
                0,300,0);
        ObjectAnimator tranlationYAnimator = ObjectAnimator.ofFloat(tv_desc2,AnimateUtil.PROPERTY_TRANSLATION_Y,
                0,400,0);
        animatorSet.setDuration(2000);
        //animatorSet.playSequentially(tvBgAnimator,tranlationXAnimator,tranlationYAnimator);
        animatorSet.playTogether(tvBgAnimator,tranlationXAnimator/*,tranlationYAnimator*/);
        animatorSet.setTarget(tv_desc2);
        animatorSet.start();

    }
}
