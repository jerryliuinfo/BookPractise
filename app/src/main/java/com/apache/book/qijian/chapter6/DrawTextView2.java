package com.apache.book.qijian.chapter6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.util.PaintConfigUtil;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2019/1/5.
 */
public class DrawTextView2 extends View {
    private Paint mPaint;
    private Paint mTextPaint;
    public DrawTextView2(Context context) {
        this(context,null);
    }

    public DrawTextView2(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DrawTextView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public DrawTextView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        mPaint = new Paint();
        mTextPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.BLACK,5);
        mTextPaint.setTextSize(120);
        mTextPaint.setColor(Color.GREEN);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        NLog.d("init top = %s, ascent = %s, descent = %s, bottom = %s",fontMetrics.top,fontMetrics.ascent,
                fontMetrics.descent,fontMetrics.bottom);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int baseLineX = 0 ;
        int baseLineY = 400;
        mPaint.setColor(Color.BLACK);
        //画基线
        mPaint.setColor(Color.RED);
        canvas.drawLine(baseLineX,baseLineY,3000,baseLineY,mPaint);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        NLog.d("onDraw top = %s, ascent = %s, descent = %s, bottom = %s",fontMetrics.top,fontMetrics.ascent,
                fontMetrics.descent,fontMetrics.bottom);
        float top = baseLineY + fontMetrics.top;
        float ascentY = baseLineY + fontMetrics.ascent;
        float descent = baseLineY + fontMetrics.descent;
        float bottom = baseLineY + fontMetrics.bottom;
        NLog.d("DrawTextView2 ononDrawDraw2 top = %s, ascent = %s, descent = %s, bottom = %s",top,ascentY,
                descent,bottom);

        String text = "havic's blog";
        canvas.drawText(text,baseLineX,baseLineY,mTextPaint);
       int height = (int) (bottom - top);
       int width = (int) mTextPaint.measureText(text);
        NLog.d("DrawTextView2 onDraw textview width = %s, height = %s",width,height);

        Rect minRect = new Rect();
        mTextPaint.getTextBounds(text,0,text.length(), minRect);
        NLog.d("DrawTextView2 onDraw textview width = %s, height = %s, rect = %s",width,height,minRect.toShortString());

        int minTop = minRect.top + baseLineY;
        int minBottom = minRect.bottom + baseLineX;
        NLog.d("DrawTextView2 onDraw textview minTop = %s, minBottom = %s",minTop,minBottom);

    }
}
