package com.apache.book.qijian.chapter2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.apache.book.R;
import com.apache.book.util.AnimateUtil;
import com.apache.book.util.BaseFragment;
import com.apache.book.util.FragmentArgs;
import com.apache.book.util.FragmentContainerActivity;

/**
 * Created by Jerry on 2018/11/23.
 */
public class AnimationFragment extends BaseFragment {
    public static void launch(Activity from) {
        FragmentArgs args =  new FragmentArgs();
        FragmentContainerActivity.launch(from,AnimationFragment.class,args);
    }

    private Button btn_anim;

    @Override
    public int inflateContentId() {
        return R.layout.fragment_animation;
    }

    @Override
    public void layoutInit() {
        super.layoutInit();

        btn_anim = getRootView().findViewById(R.id.btn_anim);
        btn_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(3000);
                ObjectAnimator tanslateAnimator = ObjectAnimator.ofFloat(btn_anim, AnimateUtil.PROPERTY_TRANSLATION_Y,0,200);
                ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(btn_anim, AnimateUtil.PROPERTY_SCALE_X,0f,1f,0.5f);


                ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(btn_anim,AnimateUtil.PROPERTY_ROTATION,0,360);
                animatorSet.playTogether(tanslateAnimator,scaleAnimator,rotateAnimator);
                animatorSet.start();

                Animation animation;
                AnimationDrawable animationDrawable;

            }
        });
    }
}
