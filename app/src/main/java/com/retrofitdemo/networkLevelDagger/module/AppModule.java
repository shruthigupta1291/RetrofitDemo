package com.retrofitdemo.networkLevelDagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SHRUTHI on 31-01-2018.
 */
@Module
public class AppModule {

    Application mApplication;

     public AppModule(Application mApplication){
         this.mApplication = mApplication;
     }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}
