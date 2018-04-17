package com.example.kb_jay.mvpdemo.model;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kb_jay on 2018/4/17.
 */

public class UserModel implements IUserModel {

    @Override
    public void login(final String name, final String pwd, final OnLoginListener listener) {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("123".equals(name) && "123".equals(pwd)) {
                    subscriber.onNext(1);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new Throwable("login failed"));
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        UserBean userBean = new UserBean();
                        //.....
                        if (listener != null) {
                            listener.onSuccess(userBean);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if(listener!=null){
                            listener.onFailed(500,throwable.getMessage());
                        }
                    }
                }, new Action0() {
                    @Override
                    public void call() {

                    }
                });
    }
}
