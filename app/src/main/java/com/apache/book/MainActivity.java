package com.apache.book;

import android.os.Bundle;
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
        findViewById(R.id.chapter_1).setOnClickListener(new View.OnClickListener() {
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

    }


    public ArrayList<ChapterBean> generateChapter1Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(1,ChapterBean.TYPE_1, "Region"));
        list.add(new ChapterBean(1,ChapterBean.TYPE_2, "Canvas"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter2Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(2,ChapterBean.TYPE_1, "Animation"));
        //list.add(new ChapterBean(2,ChapterBean.TYPE_2, "Canvas"));
        return list;
    }
    public ArrayList<ChapterBean> generateChapter3Datas(){
        ArrayList<ChapterBean> list = new ArrayList<>();
        list.add(new ChapterBean(3,ChapterBean.TYPE_1, "ValueAnimator"));
        list.add(new ChapterBean(3,ChapterBean.TYPE_2, "LoadingImageView"));
        list.add(new ChapterBean(3,ChapterBean.TYPE_3, "ValueAnimatorOfObject"));
        return list;
    }
}
