package com.apache.book.samples.animation;

import android.os.Handler;

/**
 * Created by Jerry on 2018/11/23.
 */
public class MyAnimation {
    private boolean mEnded = false;

    private boolean mStarted = false;

    private MyAnimationListener mListener;

    private Handler mListenerHandler;

    private Runnable mOnStart;

    private Runnable mOnEnd;

    private Runnable mOnRepeat;

    /**
     * The time in milliseconds at which the animation must start;
     */
    long mStartTime = -1;

    public void cancel() {
        if (mStarted && !mEnded) {
            mEnded = true;
        }
        mStartTime = Long.MIN_VALUE;
    }

    private boolean isCanceled(){
        return mStartTime == Long.MIN_VALUE;
    }

    public void setStartTime(long startTimeMilles){
        this.mStartTime = startTimeMilles;
        mStarted = mEnded = false;


    }
    public void setListener(MyAnimationListener mListener) {
        this.mListener = mListener;
    }

    public void setHandler(Handler handler){
        if (mListenerHandler == null){
            mOnStart = new Runnable() {
                @Override
                public void run() {
                    if (mListener != null){
                        mListener.onAnimationStart(MyAnimation.this);
                    }
                }
            };

            mOnRepeat = new Runnable() {
                @Override
                public void run() {
                    if (mListener != null){
                        mListener.onAnimationRepeat(MyAnimation.this);
                    }
                }
            };

            mOnEnd = new Runnable(){

                @Override
                public void run() {
                    if (mListener != null){
                        mListener.onAnimationEnd(MyAnimation.this);
                    }
                }
            };
        }

    }

    private void fireAnimationStart(){
        if (mListener != null){
            if (mListenerHandler == null){
                mListener.onAnimationStart(MyAnimation.this);
            }else {
                mListenerHandler.postAtFrontOfQueue(mOnStart);
            }
        }
    }

    private void fireAnimationRepeat(){
        if (mListener != null){
            if (mListenerHandler == null){
                mListener.onAnimationRepeat(MyAnimation.this);
            }else {
                mListenerHandler.postAtFrontOfQueue(mOnRepeat);
            }
        }
    }

    private void fireAnimationEnd(){
        if (mListener != null){
            if (mListenerHandler == null){
                mListener.onAnimationEnd(MyAnimation.this);
            }else {
                mListenerHandler.postAtFrontOfQueue(mOnEnd);
            }
        }
    }






    public  interface MyAnimationListener{

        void onAnimationStart(MyAnimation animation);

        void onAnimationEnd(MyAnimation animation);

        void onAnimationRepeat(MyAnimation animation);

        void onAnmiationCancel(MyAnimation animation);

    }
}
