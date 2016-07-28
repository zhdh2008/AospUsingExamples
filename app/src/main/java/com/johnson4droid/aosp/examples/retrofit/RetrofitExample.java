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

        //Writing down some fucking codes will be your mission to be finished.
        // TODO: 2016/7/20 You will never understand how to do it.  
        /***
         * My life is brilliant.
         * My life is brilliant.
         * My Love is pure.
         * You are beautiful.
         * You are beautiful.
         * You are beautiful. It's true.
         * I saw your face in a crowded place.
         * And I don't know what to do.
         */
        // For something you like

    }
}
