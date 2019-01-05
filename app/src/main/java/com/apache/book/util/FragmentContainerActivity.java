package com.apache.book.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.apache.book.R;

import java.lang.reflect.Method;


public class FragmentContainerActivity extends AppCompatActivity {

    private int overrideTheme = -1;

    public static final String FRAGMENT_TAG = "FRAGMENT_CONTAINER";


    public static final String EXTRA_CLASS_NAME = "className";
    public static final String EXTRA_ARGS = "args";

    /**
     * 启动一个界面
     *
     * @param activity
     * @param clazz
     * @param args
     */
    public static void launch(Activity activity, Class<? extends Fragment> clazz, FragmentArgs args) {

        Intent intent = new Intent(activity, FragmentContainerActivity.class);
        intent.putExtra(EXTRA_CLASS_NAME, clazz.getName());
        if (args != null)
            intent.putExtra(EXTRA_ARGS, args);
        activity.startActivity(intent);
    }



    public static void launchForResult(Activity from, Class<? extends Fragment> clazz, FragmentArgs args, int requestCode) {
        Intent intent = new Intent(from, FragmentContainerActivity.class);
        intent.putExtra(EXTRA_CLASS_NAME, clazz.getName());
        if (args != null)
            intent.putExtra(EXTRA_ARGS, args);
        from.startActivityForResult(intent, requestCode);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String className = getIntent().getStringExtra(EXTRA_CLASS_NAME);
        if (TextUtils.isEmpty(className)) {
            finish();
            return;
        }





        int contentId = R.layout.comm_ui_fragment_container;

        FragmentArgs values = (FragmentArgs) getIntent().getSerializableExtra(EXTRA_ARGS);

        Fragment fragment = null;
        if (savedInstanceState == null) {
            try {
                Class clazz = Class.forName(className);
                fragment = (Fragment) clazz.newInstance();
                // 设置参数给Fragment
                if (values != null && values.getValues().size() > 0) {
                    try {
                        Method method = clazz.getMethod("setArguments", new Class[] { Bundle.class });
                        method.invoke(fragment, FragmentArgs.transToBundle(values));
                    } catch (Exception e) {
                    }
                }
                // 重写Activity的主题
                try {
                    Method method = clazz.getMethod("setTheme");
                    if (method != null)
                        overrideTheme = Integer.parseInt(method.invoke(fragment).toString());
                } catch (Exception e) {
                }
                // 重写Activity的contentView
                try {
                    Method method = clazz.getMethod("setActivityContentView");
                    if (method != null)
                        contentId = Integer.parseInt(method.invoke(fragment).toString());
                } catch (Exception e) {
                }
            } catch (Exception e) {
                finish();
                return;
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(contentId);


        if (fragment != null) {
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment, FRAGMENT_TAG).commit();
        }

        if (getSupportActionBar() != null)
        	getSupportActionBar().setDisplayShowHomeEnabled(false);
    }


}
