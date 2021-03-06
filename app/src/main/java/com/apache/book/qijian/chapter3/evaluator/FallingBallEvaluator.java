package com.apache.book.qijian.chapter3.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * Created by Jerry on 2018/12/3.
 */
public class FallingBallEvaluator implements TypeEvaluator<Point> {
    private Point point = new Point();
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        point.x = (int) (startValue.x + fraction * (endValue.x - startValue.x));

        if (fraction * 2 <= 1){
            point.y = (int) (startValue.y + fraction * 2 *(endValue.y - startValue.y));
        }
        //到了1／2进度的时候，y值不变
        else {
            point.y = endValue.y;
        }
        return point;
    }
}
