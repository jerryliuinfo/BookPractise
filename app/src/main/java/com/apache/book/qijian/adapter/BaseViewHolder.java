package com.apache.book.qijian.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Jerry on 2018/11/21.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    public BaseViewHolder(View itemView) {
        super(itemView);

        mViews = new SparseArray<>();

    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getRootView(){
        return itemView;
    }
}
