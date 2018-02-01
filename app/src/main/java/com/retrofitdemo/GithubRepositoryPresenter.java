package com.retrofitdemo;

import com.retrofitdemo.model.Repo;
import com.retrofitdemo.utils.API;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by SHRUTHIon 31-01-2018.
 */

public class GithubRepositoryPresenter implements GithubRepositoryContractor.RepositoriesPresenter {

    public Retrofit mRetrofit;
    GithubRepositoryContractor.RepositoriesView mRepositoriesView;

    @Inject
    GithubRepositoryPresenter(Retrofit retrofit, GithubRepositoryContractor.RepositoriesView  mView){
        this.mRetrofit = retrofit;
        this.mRepositoriesView = mView;
    }

    @Override
    public void getRepositoriesListApiData() {
            mRepositoriesView.showProgressDialog();
            mRetrofit.create(API.class).listRepos("JakeWharton")
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .unsubscribeOn(Schedulers.io())
                   .subscribe(new Observer<List<Repo>>() {
               @Override
               public void onCompleted() {
                   mRepositoriesView.hideProgressDialog();
               }

               @Override
               public void onError(Throwable e) {
                    mRepositoriesView.updateErrorView(e.getMessage());
               }

               @Override
               public void onNext(List<Repo> mRepositoriesList) {
                        mRepositoriesView.setListToAdapter((ArrayList<Repo>) mRepositoriesList);
               }
           });
    }
}
