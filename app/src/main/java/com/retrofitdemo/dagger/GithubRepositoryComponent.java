package com.retrofitdemo.dagger;

import com.retrofitdemo.MainActivity;
import com.retrofitdemo.networkLevelDagger.component.NetComponent;
import com.retrofitdemo.utils.CustomScope;

import dagger.Component;

/**
 * Created by SHRUTHI on 31-01-2018.
 */
    @CustomScope
    @Component(dependencies = NetComponent.class, modules = GitHubRepositoryModule.class)
    public interface GithubRepositoryComponent {
        void inject(MainActivity activity);
}


