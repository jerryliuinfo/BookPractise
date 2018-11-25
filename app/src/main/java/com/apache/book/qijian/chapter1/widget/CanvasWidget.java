package com.apache.book.qijian.chapter1.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.util.PaintConfigUtil;
import com.apache.book.util.log.NLog;

/**
 * Created by 01370340 on 2018/11/20.
 */
public class CanvasWidget extends View {
    public static final String TAG = CanvasWidget.class.getSimpleName();
    private Paint mPaint;
    private Path mPath;

    public CanvasWidget(Context context) {
        super(context);
        init();
    }

    public CanvasWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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


//        canvas.translate(100,100);
//        RectF rectF = new RectF(0,0,400,200);
//        canvas.drawRect(rectF,mPaint);

        Paint paint_red = new Paint();
        PaintConfigUtil.configFillPaint(paint_red,Color.RED);
        Paint paint_green = new Paint();
        PaintConfigUtil.configFillPaint(paint_green,Color.GREEN);

       /* RectF rect1 = new RectF(0,0,400,200);
        canvas.drawRect(rect1,paint_green);

        canvas.translate(100,100);
        canvas.rotate(30);
        canvas.drawRect(rect1,paint_red);*/

       //canvas.drawRect(new RectF(0,0,400,400), paint_red);

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        canvas.drawColor(Color.RED);

        canvas.save();
        canvas.clipRect(new RectF(100,100,400,400));
        canvas.drawColor(Color.GREEN);

        canvas.restore();


        canvas.drawColor(Color.BLUE);
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
