package com.retrofitdemo.dagger;

import com.retrofitdemo.GithubRepositoryContractor;
import com.retrofitdemo.utils.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SHRUTHI on 31-01-2018.
 */
@Module
public class GitHubRepositoryModule {

    private final GithubRepositoryContractor.RepositoriesView mRepositoriesView;
    public GitHubRepositoryModule(GithubRepositoryContractor.RepositoriesView mRepositoriesView) {
        this.mRepositoriesView = mRepositoriesView;
    }

    @Provides
    GithubRepositoryContractor.RepositoriesView provideRepositoryModule(){
        return mRepositoriesView;
    }
}
