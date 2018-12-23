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
 * Created by Jerry on 2018/12/23.
 */
public class PathMeasureAliPaySuccessView extends View {
    private Paint mPaint;
    private Path mCirclePath;
    private Path mDestPath;
    private float mCenterX, mCenterY;
    private float mRadis;

    private PathMeasure mPathMeasure;
    private ValueAnimator mAnimator;

    private float mCurrentAnimValue;
    public PathMeasureAliPaySuccessView(Context context) {
        super(context);
        init();
    }

    public PathMeasureAliPaySuccessView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureAliPaySuccessView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        NLog.d("PathMeasureAliPaySuccessView init");
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);
        mCirclePath = new Path();
        mDestPath = new Path();

        mCirclePath.addCircle(mCenterX,mCenterY,mRadis,Path.Direction.CW);
        mCirclePath.moveTo(mCenterX - mRadis / 2,mCenterY);
        mCirclePath.lineTo(mCenterX,mCenterY + mRadis / 2);
        mCirclePath.lineTo(mCenterY + mRadis / 2,mCenterY - mRadis / 3);

        mPathMeasure = new PathMeasure(mCirclePath,false);
        startAnimation();
    }

    private void startAnimation(){
        if (mAnimator != null){
            mAnimator.cancel();
        }
        mAnimator = ValueAnimator.ofFloat(0,2);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        mAnimator.setDuration(2000);
        mAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mCenterX = getMeasuredWidth() / 2;
        mCenterY = getMeasuredHeight() / 2;
        mRadis = getMeasuredWidth() / 2 - mPaint.getStrokeWidth() / 2;
        NLog.d("PathMeasureAliPaySuccessView onMeasure mCenterX = %s, mCenterY = %s, mRadis = %s",mCenterX,mCenterY,mRadis);
        init();
    }

    private  boolean nextContoured = false;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        NLog.d("PathMeasureAliPaySuccessView onDraw mCurrentAnimValue = %s",mCurrentAnimValue);
        if (mCurrentAnimValue < 1){
            float stop = mPathMeasure.getLength() * mCurrentAnimValue;
            mPathMeasure.getSegment(0,stop,mDestPath,true);
        }else if (!nextContoured && ( mCurrentAnimValue >= 1 || mCurrentAnimValue <= 1.1)){
            NLog.e("------>PathMeasureAliPaySuccessView onDraw mCurrentAnimValue = %s get nextContour ", mCurrentAnimValue);
            mPathMeasure.getSegment(0,mPathMeasure.getLength(),mDestPath,true);
            //移动到path的下一段路径
            mPathMeasure.nextContour();
            nextContoured = true;
        }else {
            //NLog.d("------>PathMeasureAliPaySuccessView onDraw hook  ");
            float stop = mPathMeasure.getLength() * (mCurrentAnimValue - 1);
            mPathMeasure.getSegment(0,stop,mDestPath,true);
        }
        canvas.drawPath(mDestPath,mPaint);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAnimator != null){
            mAnimator.cancel();
            mAnimator = null;
        }
    }

    public void doAgain(){
        nextContoured = false;
        init();
    }

}
