package com.apache.book.qijian;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import com.apache.book.R;
import com.apache.book.bean.ChapterBean;
import com.apache.book.qijian.adapter.BaseRecyclerViewAdapter;
import com.apache.book.qijian.adapter.BaseViewHolder;
import com.apache.book.qijian.chapter1.CanvasFragment;
import com.apache.book.qijian.chapter1.PathFragment;
import com.apache.book.qijian.chapter2.AnimationFragment;
import com.apache.book.qijian.chapter3.ValueAnimatorFragment;
import com.apache.book.util.BizFragment;
import com.apache.book.util.FragmentContainerActivity;

import java.util.List;

/**
 * Created by Jerry on 2018/11/21.
 */
public class ChapterAdapter extends BaseRecyclerViewAdapter<ChapterBean> {
    TextView tv_name;
    public ChapterAdapter(Activity context, List<ChapterBean> datas, int layoutId) {
        super(context, datas, layoutId);


    }

    @Override
    protected void bindData(BaseViewHolder holder, final ChapterBean data, int position) {
        tv_name = holder.getView(R.id. tv_name);
        tv_name.setText(data.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (data.getChapterIndex() == 1){
                    if (data.getSectionIndex() == ChapterBean.TYPE_1){
                        PathFragment.launch(getActivity());

                    }
                    else if (data.getSectionIndex() == ChapterBean.TYPE_2){
                        CanvasFragment.launch(getActivity());
                    }
                }
                else if (data.getChapterIndex() == 2){
                    if (data.getSectionIndex() == ChapterBean.TYPE_1){
                        AnimationFragment.launch(getActivity());
                    }
                }
                else if (data.getChapterIndex() == 3){
                    if (data.getSectionIndex() == ChapterBean.TYPE_1){
                        FragmentContainerActivity.launch(getActivity(),ValueAnimatorFragment.class,null);
                    }
                    else if (data.getSectionIndex() == ChapterBean.TYPE_2){
                        BizFragment.launch(getActivity(),R.layout.fragment_loading_imageview);
                    }
                    else if (data.getSectionIndex() == ChapterBean.TYPE_3){
                        BizFragment.launch(getActivity(),R.layout.fragment_value_animator_ofobject);
                    }
                }


            }
        });
        Animation animation;
    }
}
