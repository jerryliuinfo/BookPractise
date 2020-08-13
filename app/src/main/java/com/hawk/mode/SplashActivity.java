package com.hawk.mode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.apache.book.R;
import com.apache.book.dahuadesignmode.sourcedesign.builder.ImageLoadConfig;
import com.apache.book.dahuadesignmode.sourcedesign.srp.DoubleCache;
import com.apache.book.dahuadesignmode.sourcedesign.srp.ImageLoader;

/**
 * @author Jerry
 * @Description:
 * @date 2016/9/10 11:08
 * @copyright TCL-MIG
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_test = (Button) findViewById(R.id.btn_test);
        final ImageView imageView = (ImageView) findViewById(R.id.image);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageLoadConfig config = new ImageLoadConfig.Builder().setLoadFailedRes(R.mipmap.ic_launcher).create();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.init(config);
                imageLoader.setImageCache(new DoubleCache());
                imageLoader.displayImage(imageView,"www.baidu.com");
            }
        });



    }


}
