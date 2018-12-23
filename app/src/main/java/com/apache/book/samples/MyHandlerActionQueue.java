package com.apache.book.samples;

import android.os.Handler;

/**
 * Created by Jerry on 2018/12/9.
 */
public class MyHandlerActionQueue {
    private HandlerAction[] mActions;

    private int mCount;

    public Runnable getRunnable(int index){
        if (index >= mCount){
            throw  new IndexOutOfBoundsException();
        }
        return mActions[index].runnable;
    }

    public long getDelay(int index){
        if (index >= mCount){
            throw  new IndexOutOfBoundsException();
        }
        return mActions[index].delay;
    }

    public int size(){
        return mCount;
    }

    public void postDelay(Runnable runnable){
        postDelay(runnable,0);
    }


    public void postDelay(Runnable runnable, long delay){
        final HandlerAction handlerAction = new HandlerAction(runnable,delay);
        synchronized (this){
            if (mActions == null){
                mActions = new HandlerAction[4];
            }
            mCount++;
        }
    }

    public void removeCallbacks(Runnable runnable){
        synchronized (this){
            final  int count = mCount;
            final HandlerAction [] actions = mActions;
            int j = 0;
            for (int i = 0; i < count; i++) {
                if (actions[i].match(runnable)){
                    continue;
                }
                if (j != i){
                    actions[j] = actions[i];
                }
                j++;
            }
            mCount = j;
            for (; j < count;j++){
                actions[j] = null;
            }
        }
    }


    public void executeActions(Handler handler){
        synchronized (this){
            final HandlerAction [] actions = mActions;
            for (int i = 0, count = mCount; i < count; i++) {
                final HandlerAction handlerAction = mActions[i];
                handler.postDelayed(handlerAction.runnable,handlerAction.delay);
            }
            mActions = null;
            mCount = 0;
        }
    }

    private static class HandlerAction{
        final Runnable runnable;
        final long delay;

        public HandlerAction(Runnable runnable, long delay) {
            this.runnable = runnable;
            this.delay = delay;
        }

        public boolean match(Runnable other){
            return( other == null && runnable == null) || (other != null && other.equals(runnable));
        }
    }
}
