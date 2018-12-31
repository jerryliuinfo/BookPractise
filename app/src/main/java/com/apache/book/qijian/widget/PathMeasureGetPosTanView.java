package com.apache.book.qijian.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.apache.book.R;
import com.apache.book.util.PaintConfigUtil;

/**
 * Created by Jerry on 2018/12/23.
 */
public class PathMeasureGetPosTanView extends View {
    private Paint mPaint;
    private Path mCirclePath, mDestPath;
    private PathMeasure mPathMeasure;
    private float mCurrentValue;
    private Bitmap mArrowBitmap;
    private float[] pos = new float[2];
    private float[] tan = new float[2];
    private ValueAnimator mAnimator;
    public PathMeasureGetPosTanView(Context context) {
        super(context);
        init(context);
    }

    public PathMeasureGetPosTanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PathMeasureGetPosTanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    float totalLength;
    private void init(Context context){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
       /* BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = DimensUtil.dp2px(context,5);
        options.outHeight = DimensUtil.dp2px(context,5);*/
        mArrowBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arrow);

        mPaint = new Paint();
        PaintConfigUtil.configStrokePaint(mPaint,Color.RED,20);

        mCirclePath = new Path();
        mCirclePath.addCircle(100,100,50,Path.Direction.CW);

        mPathMeasure = new PathMeasure(mCirclePath,true);
        totalLength = mPathMeasure.getLength();

        mDestPath = new Path();

        mAnimator = ValueAnimator.ofFloat(0,1);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(10 * 1000);
        mAnimator.start();

    }
    Matrix matrix = new Matrix();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float stop = totalLength * mCurrentValue;
        mPathMeasure.getPosTan(stop,pos,tan);
        float degress = (float) (Math.atan2(tan[1], tan[0]) * 180 / Math.PI);
        matrix.reset();
        matrix.postRotate(degress, mArrowBitmap.getWidth() / 2, mArrowBitmap.getHeight() /2);
        matrix.postTranslate(pos[0] - mArrowBitmap.getWidth() / 2,pos[1] - mArrowBitmap.getHeight() / 2);

        //清空之前的路径，重新绘制
        mDestPath.reset();
        // NLog.d("PathMeasureSegmentAnimationView onDraw start = %s, mCurAnimValue = %s,temp = %s, stop = %s", start,mCurAnimValue,temp,stop);
        mPathMeasure.getSegment(0,stop,mDestPath,true);

        canvas.drawBitmap(mArrowBitmap,matrix,mPaint);
    }
}
