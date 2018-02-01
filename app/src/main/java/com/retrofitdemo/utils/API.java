package com.retrofitdemo.utils;

import com.retrofitdemo.model.Repo;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yashwant on 20/12/17.
 */

public interface API {
    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
}
