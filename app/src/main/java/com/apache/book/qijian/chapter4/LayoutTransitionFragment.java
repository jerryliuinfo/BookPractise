package com.apache.book.qijian.chapter4;


import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.apache.book.R;
import com.apache.book.util.AnimateUtil;
import com.apache.book.util.BaseFragment;

/**
 * Created by Jerry on 2018/12/8.
 */
public class LayoutTransitionFragment extends BaseFragment {

    private ViewGroup layout_container;


    @Override
    public int inflateContentId() {
        return R.layout.fragment_layout_transition;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();
        layout_container = findViewById(R.id.layout_container);
        doLayoutTransition();
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButton();
            }
        });
        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButton();
            }
        });
        findViewById(R.id.btn_layout_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLayoutTransition();
            }
        });

    }
    int i = 0;

    private void addButton(){
        Button button = new Button(getActivity());
        button.setText("button"+i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layout_container.addView(button,i);
        i++;
    }
    private void removeButton(){
        if (i > 0){
            layout_container.removeViewAt(0);
            i--;
        }
    }

    private void doLayoutTransition(){
        LayoutTransition layoutTransition = new LayoutTransition();
        ObjectAnimator animator = ObjectAnimator.ofFloat(null,AnimateUtil.PROPERTY_ROTATION,0f,90f,0f);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,animator);
        layout_container.setLayoutTransition(layoutTransition);
    }

}
