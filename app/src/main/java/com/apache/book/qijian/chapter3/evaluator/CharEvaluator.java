package com.apache.book.qijian.chapter3.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by Jerry on 2018/11/25.
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int) startValue;
        int endInt = (int) endValue;
        int curInt = (int) (startInt + fraction * (endInt - startInt));

       /* NLog.d("CharEvaluator evaluate startInt = %s,  endInt = %s,curInt = %s, curStr = %s", startInt,endInt,
                curInt,String.valueOf((char) curInt));*/
        return (char) curInt;
    }
}
