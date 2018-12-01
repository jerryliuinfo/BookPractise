package com.apache.book.qijian.chapter3;

import android.animation.TimeInterpolator;

import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/11/25.
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        float value = ValueAnimatorFragment.MIN_VALUE + (ValueAnimatorFragment.MAX_VALUE - ValueAnimatorFragment.MIN_VALUE) * input;
        NLog.d("getInterpolation input = %s , value = %s", input,value);
        return input;
    }
}
