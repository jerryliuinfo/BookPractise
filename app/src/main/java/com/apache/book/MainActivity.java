package com.apache.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.apache.book.qijian.chapter1.Chapter1ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chapter1ListFragment.launch(MainActivity.this);
            }
        });
    }
}
