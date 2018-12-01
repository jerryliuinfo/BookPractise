package com.apache.book.samples.animation;

/**
 * Created by Jerry on 2018/11/25.
 *
 */
public interface MyTypeEvaluator<T> {

    T evaluate(float fraction, T startValue, T endValue);
}
