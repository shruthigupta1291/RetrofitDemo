package com.retrofitdemo.utils;

import android.app.Application;

import com.retrofitdemo.networkLevelDagger.component.DaggerNetComponent;
import com.retrofitdemo.networkLevelDagger.component.NetComponent;
import com.retrofitdemo.networkLevelDagger.module.AppModule;
import com.retrofitdemo.networkLevelDagger.module.NetModule;

/**
 * Created by NAGA VENKATESH on 31-01-2018.
 */

public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
