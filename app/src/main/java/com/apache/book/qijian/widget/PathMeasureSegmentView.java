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
public class PathMeasureSegmentView extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mDest;
    public PathMeasureSegmentView(Context context) {
        super(context);
        init();
    }

    public PathMeasureSegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureSegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);
        mPath = new Path();
        mDest = new Path();
        setLayerType(LAYER_TYPE_SOFTWARE,null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(100,100);

        mPath.addRect(-50,-50,50,50,Path.Direction.CW);

        //mDest.lineTo(10,100);

        PathMeasure pathMeasure = new PathMeasure(mPath,false);
        //路径截取是以路径的左上角为起始点开始的，至于是顺时针截取还是逆时针截取，是根据生成Path的路径方式决定的
        //路径的截取方向与路径的生成方式相同
        pathMeasure.getSegment(0,150, mDest,true);
        NLog.d("PathMeasureSegmentView pathMeasure length = %s",pathMeasure.getLength());

        /*canvas.drawPath(mPath,mPaint);
        canvas.translate(0,120);
        canvas.drawPath(mDest,mPaint);*/

        mDest.lineTo(10,100);
        canvas.drawPath(mDest,mPaint);

    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        NLog.d("PathMeasureWidget2 width = %s, height = %s", getMeasuredWidth(),getMeasuredHeight());
    }
}

