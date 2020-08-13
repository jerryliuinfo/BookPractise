package com.apache.book.dahuadesignmode.flyweight;

import java.util.Hashtable;

/**
 * Created by 01370340 on 2017/8/31.
 */

public class WebsiteFactory {
    private Hashtable<String,IWebsite> flyWeights = new Hashtable<>();

    public IWebsite getWebsiteCategory(String key){
        if (!flyWeights.contains(key)){
            flyWeights.put(key,new ConcreteWebsite(key));
        }
        return flyWeights.get(key);
    }

    public int getWebsiteCount(){
        return flyWeights.size();
    }
}
