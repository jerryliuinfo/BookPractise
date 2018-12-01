package com.apache.book.samples.animation;

import android.animation.TypeEvaluator;

/**
 * Created by Jerry on 2018/11/25.
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;

        //return (int) (startInt + (endValue - startInt) * fraction);
        //return (int)  (200 + startInt + (endValue - startInt) * fraction);
        return (int)  (endValue - (endValue - startInt) * fraction);
    }
}
