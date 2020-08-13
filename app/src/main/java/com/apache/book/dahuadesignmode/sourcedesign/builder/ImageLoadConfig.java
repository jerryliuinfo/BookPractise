package com.apache.book.dahuadesignmode.sourcedesign.builder;

/**
 * Created by jerryliu on 2017/4/23.
 */

public class ImageLoadConfig {
    DisplayConfig displayConfig = new DisplayConfig();
    ILoadPolicy loadPolicy = new SerialLoadPolicy();

    private ImageLoadConfig() {
    }

    public static class Builder{

        DisplayConfig displayConfig = new DisplayConfig();
        ILoadPolicy loadPolicy = new SerialLoadPolicy();

        public Builder setLoadingRes(int loadingRes){
            displayConfig.loadingRes = loadingRes;
            return this;
        }

        public Builder setLoadFailedRes(int loadingRes){
            displayConfig.loadFailedRes = loadingRes;
            return this;
        }

        public Builder setLoadPolicy(ILoadPolicy loadPolicy){
            this.loadPolicy = loadPolicy;
            return this;
        }


        void applyConfig(ImageLoadConfig config){
            config.displayConfig = this.displayConfig;
            config.loadPolicy = this.loadPolicy;
        }

        public ImageLoadConfig create(){
            ImageLoadConfig config = new ImageLoadConfig();
            applyConfig(config);
            return config;
        }
    }
}
