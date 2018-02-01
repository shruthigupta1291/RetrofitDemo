package com.retrofitdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.retrofitdemo.adapter.UserRepoAdapter;
import com.retrofitdemo.dagger.DaggerGithubRepositoryComponent;
import com.retrofitdemo.dagger.GitHubRepositoryModule;
import com.retrofitdemo.databinding.ActivityMainBinding;
import com.retrofitdemo.model.Repo;
import com.retrofitdemo.utils.App;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements GithubRepositoryContractor.RepositoriesView {


    RecyclerView recyclerView;
    private List<Repo> mRepoList = new ArrayList<>();
    UserRepoAdapter userRepoAdapter;
    ActivityMainBinding activityMainBinding;


    @Inject
    GithubRepositoryPresenter mGithubRepositoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView=findViewById(R.id.rvItems);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        activityMainBinding.rvItems.setLayoutManager(linearLayoutManager);
        userRepoAdapter = new UserRepoAdapter(mRepoList);
        activityMainBinding.rvItems.setAdapter(userRepoAdapter);

        DaggerGithubRepositoryComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .gitHubRepositoryModule(new GitHubRepositoryModule(this))
                .build().inject(this);
        mGithubRepositoryPresenter.getRepositoriesListApiData();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void setListToAdapter(ArrayList<Repo> repoArrayList) {
        userRepoAdapter.addList(repoArrayList);
    }

    @Override
    public void updateErrorView(String message) {
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_LONG).show();
    }
}
