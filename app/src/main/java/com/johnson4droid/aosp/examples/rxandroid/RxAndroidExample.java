package com.johnson4droid.aosp.examples.rxandroid;

import android.os.Looper;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhoudaihui on 2016/6/29.
 */
public class RxAndroidExample {
    /**
     * 1. Firstly, you should add the dependency to the 'build.gradle' file.
     */

    /**
     * 2. Observing on the main thread
     *    or
     *    Observing on arbitrary loopers.
     */

    // On the main thread
    public void observeOnMainThread() {
        Observable.just("one", "two", "three", "four", "five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(/* an Observer */);
    }

    // On arbitrary loopers
    public void observeOnArbitraryLooper() {
        Looper backgroundLooper = null;// ...
        Observable.just("one", "two", "three", "four", "five")
                .observeOn(AndroidSchedulers.from(backgroundLooper))
                .subscribe(/* an Observer */);
    }

}
