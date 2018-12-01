package com.apache.book.samples;

import android.graphics.Rect;

import java.lang.ref.WeakReference;

/**
 * Created by Jerry on 2018/11/24.
 */
public class MyDrawable {

    private WeakReference<MyCallback> mCallback = null;

    private static final Rect ZERO_BOUNDS_RECT = new Rect();

    private Rect mBounds = ZERO_BOUNDS_RECT;

    private boolean mVisible = true;


    public void setCallback(MyCallback cb) {
        mCallback = cb != null ? new WeakReference<>(cb) : null;
    }

    public void setBounds(int left, int top, int right, int bottom) {

        Rect oldBounds = mBounds;
        if (oldBounds ==  ZERO_BOUNDS_RECT){
            oldBounds = mBounds = new Rect();
        }
        if (oldBounds.left != left || oldBounds.top != top || oldBounds.right != right
                || oldBounds.bottom != bottom){

            if (!mBounds.isEmpty()){
                invalidateSelf();
            }
            mBounds.set(left, top, right, bottom);
            onBoundsChanged(mBounds);
        }
    }

    public Rect getBounds(){
        if (mBounds == ZERO_BOUNDS_RECT){
            mBounds = new Rect();
        }
        return mBounds;
    }

    public final Rect getCopyBounds(){
        return new Rect(mBounds);
    }


    public void invalidateSelf(){
        final MyCallback callback = getCallback();
        if (callback != null){
            callback.invalidateDrawable(this);
        }
    }


    public void scheduleSelf(Runnable what, long when){
        final MyCallback callback = getCallback();
        if (callback != null){
            callback.scheduleDrawable(this,what,when);
        }
    }

    public void unscheduleSelf(Runnable what){
        final MyCallback callback = getCallback();
        if (callback != null){
            callback.unscheduleDrawable(this,what);
        }
    }

    public boolean setVisible(boolean visible, boolean restart){
        boolean changed = mVisible != visible;
        if (changed){
            mVisible = visible;
            invalidateSelf();
        }
        return changed;
    }

    public final boolean isVisible(){
        return mVisible;
    }

    public interface MyCallback{

        void scheduleDrawable(MyDrawable drawable, Runnable what, long when);

        void unscheduleDrawable(MyDrawable drawable, Runnable what);

        void invalidateDrawable(MyDrawable drawable);

    }

    public MyCallback getCallback() {
        return mCallback != null ? mCallback.get(): null;
    }

    protected void onBoundsChanged(Rect bounds){

    }
}
