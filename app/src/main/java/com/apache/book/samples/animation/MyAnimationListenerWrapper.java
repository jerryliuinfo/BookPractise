package com.apache.book.samples.animation;

/**
 * Created by Jerry on 2018/12/8.
 */
public class MyAnimationListenerWrapper implements MyAnimation.MyAnimationListener {

    private MyAnimation.MyAnimationListener mWrapped;

    public MyAnimationListenerWrapper(MyAnimation.MyAnimationListener mWrapped) {
        this.mWrapped = mWrapped;
    }

    @Override
    public void onAnimationStart(MyAnimation animation) {
        if (mWrapped != null){
            mWrapped.onAnimationStart(animation);
        }
    }

    @Override
    public void onAnimationEnd(MyAnimation animation) {
        if (mWrapped != null){
            mWrapped.onAnimationEnd(animation);
        }
    }

    @Override
    public void onAnimationRepeat(MyAnimation animation) {
        if (mWrapped != null){
            mWrapped.onAnimationRepeat(animation);
        }
    }

    @Override
    public void onAnimationCancel(MyAnimation animation) {
        if (mWrapped != null){
            mWrapped.onAnimationCancel(animation);
        }
    }
}
