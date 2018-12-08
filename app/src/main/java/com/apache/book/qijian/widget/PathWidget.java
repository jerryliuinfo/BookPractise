package com.apache.book.qijian.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.util.PaintConfigUtil;
import com.apache.book.util.ScreenUtil;
import com.apache.book.util.log.NLog;

/**
 * Created by 01370340 on 2018/11/20.
 */
public class PathWidget extends View {
    public static final String TAG = PathWidget.class.getSimpleName();
    private Paint mPaint;
    private Path mPath;

    public PathWidget(Context context) {
        super(context);
        init();
    }

    public PathWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        PaintConfigUtil.configFillPaint(mPaint,Color.RED);

        mPath = new Path();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

//        mPath.moveTo(10,10);
//        mPath.lineTo(10,100);
//        mPath.lineTo(300,100);
//        mPath.close();
//        canvas.drawPath(mPath,mPaint);

//        mPath.moveTo(10,10);
//        RectF rectF = new RectF(100,10,200,100);
//        mPath.arcTo(rectF,90,270,true);
//        canvas.drawPath(mPath,mPaint);


        //final Region region = new Region(new Rect(50,50,200,100));
        //drawRegion(region,canvas,mPaint);


//        RectF rectF = new RectF(50,50,200,500);
//        mPath.addOval(rectF,Path.Direction.CCW);
//
//        Region region = new Region();
//        region.setPath(mPath,new Region(50,50,200,200));
//        drawRegion(region,canvas,mPaint);

        canvas.translate(ScreenUtil.getScreenWidth(getContext() )/ 2, ScreenUtil.getScreenHeight(getContext()) / 2);

//        Region unionRegion = new Region(10,10,200,100);
//        unionRegion.union(new Rect(10,10,100,300));
//        drawRegion(unionRegion,canvas,mPaint);


        Rect opRect1 = new Rect(100,100,400,200);
        Rect opRect2 = new Rect(200,0,300,300);

        Paint paint = new Paint();
        PaintConfigUtil.configStrokePaint(paint,Color.RED,2);

        canvas.drawRect(opRect1,paint);
        canvas.drawRect(opRect2,paint);

        Region opRegion1 = new Region(opRect1);
        Region opRegion2 = new Region(opRect2);

        opRegion1.op(opRegion2,Region.Op.XOR);

        drawRegion(opRegion1,canvas,mPaint);




    }

    private void drawRegion(Region region,Canvas canvas,Paint paint){
        RegionIterator iterator = new RegionIterator(region);
        Rect r = new Rect();
        while (iterator.next(r)){
            canvas.drawRect(r,paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        NLog.d(TAG, "onMeasure width = %s, height = %s", getMeasuredWidth(),getMeasuredHeight());

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        NLog.d(TAG, "onLayout width = %s, height = %s", getMeasuredWidth(),getMeasuredHeight());

    }
}
