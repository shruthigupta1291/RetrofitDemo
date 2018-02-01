package com.retrofitdemo;

import com.retrofitdemo.model.Repo;

import java.util.ArrayList;


public interface GithubRepositoryContractor {

    interface RepositoriesView {
       void showProgressDialog();
       void hideProgressDialog();
       void setListToAdapter(ArrayList<Repo> mRepositoriesList);
       void updateErrorView(String message);
    }

    interface RepositoriesPresenter {
        void getRepositoriesListApiData();
    }
}
