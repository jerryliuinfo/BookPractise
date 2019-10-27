package com.apache.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.apache.book.arithmetic.ArrayQueue;
import com.apache.book.arithmetic.QueueBaseOnLinkedList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private int count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final ArrayQueue queue = new ArrayQueue(8);

        findViewById(R.id.btn_enqueue).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              boolean result = queue.enqueue("item "+count);
              if (result){
                  Log.d(TAG,"入队成功 enqueue "+ queue.toString());
              }else {
                  Log.e(TAG,"添加失败,队列已满: "+ queue.toString());

              }
              count++;
          }
        });
        findViewById(R.id.btn_dequeue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = queue.dequeue();
                if (item != null) {
                    Log.d(TAG, "出队成功: " + item + ", queue = " + queue.toString());
                }else {
                    Log.e(TAG, "出队失败,队列为空 " + item + ", queue = " + queue.toString());
                }
            }
        });


        final QueueBaseOnLinkedList linkedListQueue = new QueueBaseOnLinkedList();
        findViewById(R.id.btn_linkedlist_enqueue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedListQueue.enqueue("item "+count);
                linkedListQueue.printAll();
                count++;
            }
        });
        findViewById(R.id.btn_linkedlist_dequeue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = linkedListQueue.dequeue();
                if (item != null) {
                    Log.d(TAG, "出队成功: " + item );
                    linkedListQueue.printAll();
                }else {
                    Log.e(TAG, "出队失败,队列为空 " );
                    linkedListQueue.printAll();
                }
            }
        });

    }


}
