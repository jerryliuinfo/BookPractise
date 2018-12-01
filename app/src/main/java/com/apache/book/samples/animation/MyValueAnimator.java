package com.apache.book.samples.animation;

import java.util.ArrayList;

/**
 * Created by Jerry on 2018/11/25.
 */
public class MyValueAnimator {

    private ArrayList<MyAnimatorUpdateListener> mUpdateListeners;

    public void addUpdateListener(MyAnimatorUpdateListener listener){
        if (mUpdateListeners == null){
            mUpdateListeners = new ArrayList<>();
        }
        mUpdateListeners.add(listener);
    }

    public void remoteUpdateListener(MyAnimatorUpdateListener listener){
        if (mUpdateListeners == null){
            return;
        }
        mUpdateListeners.remove(listener);
        if (mUpdateListeners.size() == 0){
            mUpdateListeners = null;
        }
    }

    public void removeAllUpdateListener(){
        if (mUpdateListeners == null){
            return;
        }
        mUpdateListeners.clear();
        mUpdateListeners = null;
    }


    public  interface MyAnimatorUpdateListener{
        void onAnimationUpdate(MyValueAnimator valueAnimator);
    }
}
