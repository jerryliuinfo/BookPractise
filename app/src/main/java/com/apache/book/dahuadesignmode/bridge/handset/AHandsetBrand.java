package com.apache.book.dahuadesignmode.bridge.handset;

/**
 * Created by Jerry on 2019/1/5.
 * 手机品牌
 */
public abstract class AHandsetBrand {

    protected AHandsetSoft soft;

    public void setSoft(AHandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
