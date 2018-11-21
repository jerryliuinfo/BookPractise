package com.apache.book.qijian.chapter1.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.apache.book.R;
import com.apache.book.bean.ChapterBean;
import com.apache.book.qijian.adapter.BaseRecyclerViewAdapter;
import com.apache.book.qijian.adapter.BaseViewHolder;
import com.apache.book.qijian.chapter1.PathFragment;

import java.util.List;

/**
 * Created by Jerry on 2018/11/21.
 */
public class Chapter1Adapter extends BaseRecyclerViewAdapter<ChapterBean> {
    TextView tv_name;
    public Chapter1Adapter(Activity context, List<ChapterBean> datas, int layoutId) {
        super(context, datas, layoutId);


    }

    @Override
    protected void bindData(BaseViewHolder holder, final ChapterBean data, int position) {
        tv_name = holder.getView(R.id. tv_name);
        tv_name.setText(data.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getType() == ChapterBean.TYPE_1){
                    PathFragment.launch(getmActivity());

                }
            }
        });
    }
}
