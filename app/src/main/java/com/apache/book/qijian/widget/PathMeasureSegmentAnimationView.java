package com.apache.book.qijian.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.util.PaintConfigUtil;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/12/9.
 */
public class PathMeasureSegmentAnimationView extends View {
    private Paint mPaint;
    private Path mCirclePath;
    private Path mDest;

    private PathMeasure mPathMeasure;

    private float mCurAnimValue;
    public PathMeasureSegmentAnimationView(Context context) {
        super(context);
        init();
    }

    public PathMeasureSegmentAnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureSegmentAnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PathMeasureSegmentAnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    ValueAnimator mAnimator;
    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,10);
        mCirclePath = new Path();
        mDest = new Path();


        mCirclePath.addCircle(100,100,50,Path.Direction.CW);
        mPathMeasure = new PathMeasure(mCirclePath,true);
        NLog.d("SegmentView init length = %s", mPathMeasure.getLength());

        mAnimator = ValueAnimator.ofFloat(0,1);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(10 * 1000);
        mAnimator.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        float totalLength = mPathMeasure.getLength();
        float stop = totalLength * mCurAnimValue;

        //float temp = (float) (0.5 - Math.abs(mCurAnimValue - 0.5));
        //float start = stop - temp * totalLength;

        float start;
        if (mCurAnimValue <= 0.5){
            start = 0;
        }else {
            start = (2 * mCurAnimValue - 1) * totalLength;
        }
        //清空之前的路径，重新绘制
        mDest.reset();
       // NLog.d("PathMeasureSegmentAnimationView onDraw start = %s, mCurAnimValue = %s,temp = %s, stop = %s", start,mCurAnimValue,temp,stop);
        mPathMeasure.getSegment(start,stop,mDest,true);
        canvas.drawPath(mDest,mPaint);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (mAnimator != null){
            mAnimator.cancel();
            mAnimator = null;
        }
    }
}

