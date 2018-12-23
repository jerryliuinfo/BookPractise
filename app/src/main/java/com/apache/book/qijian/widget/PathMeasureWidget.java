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
public class PathMeasureWidget extends View {
    private Paint mPaint;
    private Path mPath;
    public PathMeasureWidget(Context context) {
        super(context);
        init();
    }

    public PathMeasureWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PathMeasureWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);
        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(50,50);
        mPath.moveTo(0,0);
        mPath.lineTo(0,100);
        mPath.lineTo(100,100);
        mPath.lineTo(100,0);


        PathMeasure pathMeasure1 = new PathMeasure(mPath,false);
        PathMeasure pathMeasure2 = new PathMeasure(mPath,true);
        NLog.d("forceClose = false , length = %s, isClosed = %s", pathMeasure1.getLength(), pathMeasure1.isClosed());
        NLog.d("forceClose = true , length = %s,  isClosed = %s",  pathMeasure2.getLength(), pathMeasure2.isClosed());
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        NLog.d("width = %s, height = %s", getMeasuredWidth(),getMeasuredHeight());
    }
}
