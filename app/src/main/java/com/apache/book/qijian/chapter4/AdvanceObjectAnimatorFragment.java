package com.apache.book.qijian.chapter4;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
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


    @Override
    public int inflateContentId() {
        return R.layout.fragment_advance_object_animator;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();
        tv_name = findViewById(R.id.tv_name);
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
}
