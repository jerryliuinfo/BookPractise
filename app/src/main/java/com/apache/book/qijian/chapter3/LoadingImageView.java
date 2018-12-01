package com.apache.book.qijian.chapter3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.apache.book.samples.animation.ReverseEvaluator;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/11/24.
 */
public class LoadingImageView extends AppCompatImageView {
    public LoadingImageView(Context context) {
        super(context);
        init();
    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    ValueAnimator valueAnimator;

    private void init(){
        cancelAnimator();
        valueAnimator = ValueAnimator.ofInt(0,400);
        //valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                NLog.d("onAnimationUpdate dx = %s",currentValue);
                //setTop(mTop - dx);
                layout(getLeft(), currentValue, getRight(),currentValue +getHeight());
            }
        });
        //valueAnimator.setInterpolator(new MyInterpolator());
        valueAnimator.setEvaluator(new ReverseEvaluator());
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        NLog.d("onMeasure widthMeasureSpec widthMode = %s, widthSize = %s, heightMode = %s, " +
                        "heightSize = %s",widthMode,widthSize, heightMode,heightSize);
    }



    private int mTop;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;

        NLog.d("onMeasure onLayout left = %s, top = %s, right = %s, " +
                "bottom = %s",left,top, right,bottom);
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
            OvershootInterpolator overshootInterpolator;
        }
    }
}
