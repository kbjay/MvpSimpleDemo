package com.example.kb_jay.mvpdemo.model;

/**
 * Created by kb_jay on 2018/4/17.
 */

public interface OnLoginListener {
    void onSuccess(UserBean bean);
    void onFailed(int code,String msg);
}
