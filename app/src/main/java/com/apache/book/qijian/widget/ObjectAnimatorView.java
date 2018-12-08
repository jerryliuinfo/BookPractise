package com.apache.book.qijian.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/12/3.
 */
public class ObjectAnimatorView extends AppCompatImageView {
    public ObjectAnimatorView(Context context) {
        super(context);
    }

    public ObjectAnimatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObjectAnimatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


     public void setPosition(Point point){
        layout(point.x,point.y,point.x + getWidth(),point.y + getHeight());
     }


     public void setScaleSize(float number){
        setScaleX(number);
         NLog.d("scale size = %s", getScaleX());
     }

     public float getScaleSize(){
        return 0.5f;
     }
}
