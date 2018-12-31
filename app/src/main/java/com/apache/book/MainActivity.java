package com.apache.book;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apache.book.bean.ChapterBean;
import com.apache.book.qijian.BaseCharListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.chapter_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(MainActivity.this,generateChapter1Datas());
            }
        });
        findViewById(R.id.chapter_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(MainActivity.this,generateChapter2Datas());
            }
        });
        findViewById(R.id.chapter_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(MainActivity.this,generateChapter3Datas());
            }
        });
        findViewById(R.id.chapter_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(MainActivity.this,generateChapter4Datas());
            }
        });
        findViewById(R.id.chapter_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseCharListFragment.launch(MainActivity.this,generateChapter5Datas());
            }
        });
        handler.sendEmptyMessage(100);

    }
    Handler handler = new Handler();


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
}
