package com.apache.book.qijian;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apache.book.R;
import com.apache.book.bean.ChapterBean;
import com.apache.book.util.BaseFragment;
import com.apache.book.util.FragmentArgs;
import com.apache.book.util.FragmentContainerActivity;

import java.util.ArrayList;

/**
 * Created by Jerry on 2018/11/23.
 */
public class BaseCharListFragment extends BaseFragment {

    private RecyclerView mRecycleView;

    private ArrayList<ChapterBean> mChapterList;



    public static void launch(Activity from,ArrayList<ChapterBean> chapterBeans) {
        FragmentArgs args =  new FragmentArgs();
        args.add("data",chapterBeans);
        FragmentContainerActivity.launch(from,BaseCharListFragment.class,args);
    }

    @Override
    public int inflateContentId() {
        return R.layout.chapter_1;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();

        if (getArguments() != null &&  getArguments().containsKey("data")){
            mChapterList = (ArrayList<ChapterBean>) getArguments().getSerializable("data");
        }
        if (mChapterList == null){
            mChapterList = new ArrayList<>();
        }
        mRecycleView = getRootView().findViewById(R.id.recycle_view);
        mRecycleView.setAdapter(new ChapterAdapter(getActivity(),mChapterList,R.layout.item_chapter1));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        //mRecycleView.setLayoutManager(linearLayoutManager);

        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

    }
}
