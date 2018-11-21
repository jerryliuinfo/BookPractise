package com.apache.book.qijian.chapter1;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apache.book.R;
import com.apache.book.bean.ChapterBean;
import com.apache.book.qijian.chapter1.adapter.Chapter1Adapter;
import com.apache.book.util.BaseFragment;
import com.apache.book.util.FragmentArgs;
import com.apache.book.util.FragmentContainerActivity;

import java.util.ArrayList;
import java.util.List;


public class Chapter1ListFragment extends BaseFragment {

    private RecyclerView mRecycleView;

    public static void launch(Activity from) {
        FragmentArgs args =  new FragmentArgs();
        FragmentContainerActivity.launch(from,Chapter1ListFragment.class,args);
    }


    @Override
    public int inflateContentId() {
        return R.layout.chapter_1;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();

        mRecycleView = getRootView().findViewById(R.id.recycle_view);
        mRecycleView.setAdapter(new Chapter1Adapter(getActivity(),generateDatas(),R.layout.item_chapter1));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        //mRecycleView.setLayoutManager(linearLayoutManager);

        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

    }


    private List<ChapterBean> generateDatas(){
        List<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(ChapterBean.TYPE_1, "Chapter1"));
        list.add(new ChapterBean(ChapterBean.TYPE_2, "Chapter2"));
        list.add(new ChapterBean(ChapterBean.TYPE_3, "Chapter3"));
        return list;
    }
}
