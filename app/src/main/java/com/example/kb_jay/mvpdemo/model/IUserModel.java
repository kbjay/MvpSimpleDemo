package com.example.kb_jay.mvpdemo.model;

/**
 * Created by kb_jay on 2018/4/17.
 */

public interface IUserModel {
    void login(String name,String pwd,OnLoginListener listener);
}
