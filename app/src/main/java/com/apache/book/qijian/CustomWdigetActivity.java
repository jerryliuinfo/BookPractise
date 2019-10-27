package com.apache.book.qijian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apache.book.R;
import com.apache.book.bean.ChapterBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jerry on 2019/3/4.
 */
public class CustomWdigetActivity extends AppCompatActivity {
    public static void launch(Activity from) {
        Intent intent = new Intent(from, CustomWdigetActivity.class);
        from.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_widget);

        findViewById(R.id.chapter_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter1Datas());
            }
        });
        findViewById(R.id.chapter_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter2Datas());
            }
        });
        findViewById(R.id.chapter_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter3Datas());
            }
        });
        findViewById(R.id.chapter_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter4Datas());
            }
        });
        findViewById(R.id.chapter_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter5Datas());
            }
        });
        findViewById(R.id.chapter_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(CustomWdigetActivity.this,generateChapter6Datas());
            }
        });

    }


    public ArrayList<ChapterBean> generateChapter1Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(1,ChapterBean.TYPE_1, "Region"));
        list.add(new ChapterBean(1,ChapterBean.TYPE_2, "Canvas"));
        list.add(new ChapterBean(1,ChapterBean.TYPE_3, "HashMapp"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter2Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(2,ChapterBean.TYPE_1, "Animation"));
        list.add(new ChapterBean(2,ChapterBean.TYPE_2, "Canvas"));
        list.add(new ChapterBean(2,ChapterBean.TYPE_3, "Camera_STRETCH"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter3Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(3,ChapterBean.TYPE_1, "ValueAnimator"));
        list.add(new ChapterBean(3,ChapterBean.TYPE_2, "LoadingImageView"));
        list.add(new ChapterBean(3,ChapterBean.TYPE_3, "ValueAnimatorOfObject"));
        list.add(new ChapterBean(3,ChapterBean.TYPE_4, "ObjectAnimator"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter4Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_4,ChapterBean.TYPE_1, "PropertyValuesViewHolder"));
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_4,ChapterBean.TYPE_2, "ViewPropertyAnimator"));
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_4,ChapterBean.TYPE_3, "LayoutTransition"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter5Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_5,ChapterBean.TYPE_1, "PathMeasure"));
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_5,ChapterBean.TYPE_2, "PosTan"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter6Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_6,ChapterBean.TYPE_1, "DrawText"));
        //list.add(new ChapterBean(ChapterBean.CHAPTER_INDEX_6,ChapterBean.TYPE_2, "DrawText2"));
        return list;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        List<String> newList = Collections.unmodifiableList(list);
        newList.add("ccc");
        System.out.println("newList size = "+ newList.size());

    }
}
