package com.apache.book.qijian.chapter4;


import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.apache.book.R;
import com.apache.book.qijian.chapter3.evaluator.CharEvaluator;
import com.apache.book.util.AnimateUtil;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/8.
 */
public class AdvanceObjectAnimatorFragment extends BaseFragment {

    private TextView tv_name;

    private ImageView iv_girl;


    @Override
    public int inflateContentId() {
        return R.layout.fragment_advance_object_animator;
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
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCharacterAnimation();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doKeyFrameAnimation();
            }
        });

    }

    private void doAnimation(){
        PropertyValuesHolder rotationValuesHolder = PropertyValuesHolder.ofFloat(AnimateUtil.PROPERTY_ROTATION,60,-60,40,-40,20,-20,
                10,-10,0);
        PropertyValuesHolder alphaValuesHolder = PropertyValuesHolder.ofFloat(AnimateUtil.PROPERTY_ALPHA,0.1f,1f,0.1f,1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv_name,rotationValuesHolder,alphaValuesHolder);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
    private void doCharacterAnimation(){
        PropertyValuesHolder charValuesHolder = PropertyValuesHolder.ofObject("CharText",new CharEvaluator(),
                new Character('A'),new Character('Z'));
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv_name,charValuesHolder);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    private void doKeyFrameAnimation(){
        Keyframe keyframe0 = Keyframe.ofFloat(0,0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.1f,-20f);
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f,20f);
        Keyframe keyframe3 = Keyframe.ofFloat(0.3f,-20f);
        //keyframe3.setInterpolator(new BounceInterpolator());
        Keyframe keyframe4 = Keyframe.ofFloat(0.4f,20f);
        Keyframe keyframe5 = Keyframe.ofFloat(0.5f,-20f);
        Keyframe keyframe6 = Keyframe.ofFloat(0.6f,20f);
        Keyframe keyframe7 = Keyframe.ofFloat(0.7f,-20f);
        Keyframe keyframe8 = Keyframe.ofFloat(0.8f,20f);
        Keyframe keyframe9 = Keyframe.ofFloat(0.9f,-20f);
        Keyframe keyframe10 = Keyframe.ofFloat(1f/*,0*/);
        keyframe10.setValue(160);
        keyframe10.setInterpolator(new LinearInterpolator());
        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe(AnimateUtil.PROPERTY_ROTATION,
                keyframe0,keyframe1,keyframe2,keyframe3,keyframe4,keyframe5,keyframe6,keyframe7,keyframe8
                ,keyframe9,keyframe10);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv_girl,valuesHolder);
        animator.setDuration(5000);
        animator.start();


    }
}
