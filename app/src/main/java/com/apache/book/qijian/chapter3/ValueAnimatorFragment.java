package com.apache.book.qijian.chapter3;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;

import com.apache.book.R;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/11/24.
 */
public class ValueAnimatorFragment extends BaseFragment {


    @Override
    public int inflateContentId() {
        return R.layout.fragment_value_animator;
    }

    private Button btnStart;

    private Button btnCancel;

    @Override
    public void layoutInit() {
        super.layoutInit();

        btnStart = getRootView().findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });
        btnCancel = getRootView().findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animator != null){
                    animator.cancel();
                }
            }
        });
    }

    ValueAnimator animator;
    private void doAnimation(){
        animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                btnStart.layout(curValue,curValue,curValue + btnStart.getWidth(), curValue + btnStart.getHeight());
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setStartDelay(3000);
        animator.start();


        animator.removeUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
    }


}
