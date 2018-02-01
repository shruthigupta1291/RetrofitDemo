package com.retrofitdemo;

import com.retrofitdemo.model.Repo;

import java.util.ArrayList;

/**
 * Created by SHRUTHI on 31-01-2018.
 */

public interface GithubRepositoryContractor {

    interface RepositoriesView{
       void showProgressDialog();
       void hideProgressDialog();
       void setListToAdapter(ArrayList<Repo> mRepositoriesList);
       void updateErrorView(String message);
    }

    interface RepositoriesPresenter{
        void getRepositoriesListApiData();
    }
}
