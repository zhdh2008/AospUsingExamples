package com.johnson4droid.aosp.examples.retrofit;

import android.os.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by zhoudaihui on 2016/7/15.
 */
public class RetrofitExample {

    public static void test() {
        // TODO: 2016/7/15
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");

        Message.obtain();


    }
}
