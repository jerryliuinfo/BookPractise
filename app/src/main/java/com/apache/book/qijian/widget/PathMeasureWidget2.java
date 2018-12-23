package com.apache.book.qijian.widget;

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
public class PathMeasureWidget2 extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mDest;
    public PathMeasureWidget2(Context context) {
        super(context);
        init();
    }

    public PathMeasureWidget2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureWidget2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PathMeasureWidget2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);
        mPath = new Path();
        mDest = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(100,100);

        mPath.addRect(-50,-50,50,50,Path.Direction.CW);

        mDest.lineTo(10,100);

        PathMeasure pathMeasure = new PathMeasure(mPath,false);
        pathMeasure.getSegment(0,150, mDest,false);

        canvas.drawPath(mDest,mPaint);

    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        NLog.d("PathMeasureWidget2 width = %s, height = %s", getMeasuredWidth(),getMeasuredHeight());
    }
}

