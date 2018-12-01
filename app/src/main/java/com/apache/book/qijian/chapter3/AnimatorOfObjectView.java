package com.apache.book.qijian.chapter3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.qijian.chapter3.evaluator.CharEvaluator;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/11/25.
 */
public class AnimatorOfObjectView extends AppCompatTextView {
    public AnimatorOfObjectView(Context context) {
        super(context);
        init();
    }

    public AnimatorOfObjectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimatorOfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    ValueAnimator valueAnimator;

    private void init(){
        cancelAnimator();
        valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), 'A','Z');
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(13 * 1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char) animation.getAnimatedValue();
                NLog.d("onAnimationUpdate text = %s", text);

                setText(String.valueOf(text));
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueAnimator.isRunning()){
                    valueAnimator.cancel();
                }else {
                    valueAnimator.start();
                }
            }
        });
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        cancelAnimator();
    }

    private void cancelAnimator(){
        if (valueAnimator != null){
            valueAnimator.cancel();
            valueAnimator = null;
        }
    }
}
