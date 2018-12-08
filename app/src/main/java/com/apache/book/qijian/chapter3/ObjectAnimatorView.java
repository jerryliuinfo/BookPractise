package com.apache.book.qijian.chapter3;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

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
}
