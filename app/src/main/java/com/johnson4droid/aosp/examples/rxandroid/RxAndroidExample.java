package com.johnson4droid.aosp.examples.rxandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by zhoudaihui on 2016/6/29.
 */
public class RxAndroidExample extends Activity{

    private Looper backgroundLooper;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.start();
        backgroundLooper = backgroundThread.getLooper();

        //This method can be triggered by another way.
        onRunSchedulerExampleButtonClicked();
    }

    private void onRunSchedulerExampleButtonClicked(){
        sampleObservable()
                //run on a background thread
                .subscribeOn(AndroidSchedulers.from(backgroundLooper))
                // Be notified on the main thread
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        })
        ;
    }

    static Observable<String> sampleObservable(){
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                try {
                    // Do some long running operation.
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                }catch (InterruptedException e){
                    throw  OnErrorThrowable.from(e);
                }
                return Observable.just("one","two","three","four","five");
            }
        });
    }

    static class BackgroundThread extends HandlerThread{
        BackgroundThread(){
            super("SchedulerSample-BackgroundThread",Thread.MIN_PRIORITY);
        }
    }

}
