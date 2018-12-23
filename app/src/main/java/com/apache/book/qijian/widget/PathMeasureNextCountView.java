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
 * Created by Jerry on 2018/12/23.
 */
public class PathMeasureNextCountView extends View {
    private Paint mPaint;
    private Path mPath;
    public PathMeasureNextCountView(Context context) {
        super(context);
        init();
    }

    public PathMeasureNextCountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureNextCountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PathMeasureNextCountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

        canvas.translate(150,150);

        //mPath.addRect(-50,-50,50,50,Path.Direction.CW);
        //mPath.addRect(-100,-100,100,100,Path.Direction.CW);
        mPath.addRect(-120,-120,120,120,Path.Direction.CW);

        canvas.drawPath(mPath,mPaint);

        PathMeasure measure = new PathMeasure(mPath,false);

        do {
            float len = measure.getLength();
            NLog.d("NextCountView len = %s",len);
        }while (measure.nextContour());

    }
}
