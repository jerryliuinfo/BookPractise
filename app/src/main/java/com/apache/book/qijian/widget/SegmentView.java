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
public class SegmentView extends View {
    private Paint mPaint;
    private Path mCirclePath;
    private Path mDest;

    private PathMeasure mPathMeasure;

    private float mCurAnimValue;
    public SegmentView(Context context) {
        super(context);
        init();
    }

    public SegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);
        mCirclePath = new Path();
        mDest = new Path();


        mCirclePath.addCircle(100,100,50,Path.Direction.CW);
        mPathMeasure = new PathMeasure(mCirclePath,true);
        NLog.d("SegmentView init length = %s", mPathMeasure.getLength());

        ValueAnimator animator = ValueAnimator.ofFloat(0,1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        float stop = mPathMeasure.getLength() * mCurAnimValue;
        //mDest.reset();
        mPathMeasure.getSegment(0,stop,mDest,true);
        canvas.drawPath(mDest,mPaint);
    }



}

