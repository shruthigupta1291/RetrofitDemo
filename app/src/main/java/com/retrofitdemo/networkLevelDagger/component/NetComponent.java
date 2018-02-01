package com.retrofitdemo.networkLevelDagger.component;

import com.retrofitdemo.networkLevelDagger.module.AppModule;
import com.retrofitdemo.networkLevelDagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by SHRUTHI on 31-01-2018.
 */

    @Singleton
    @Component(modules = {AppModule.class, NetModule.class})

         public interface NetComponent
    {
        // downstream components need these exposed with the return type
         // method name does not really matter
         Retrofit retrofit();
    }
