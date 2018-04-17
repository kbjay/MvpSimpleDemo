package com.example.kb_jay.mvpdemo.presenter;

import com.example.kb_jay.mvpdemo.model.OnLoginListener;
import com.example.kb_jay.mvpdemo.model.UserBean;
import com.example.kb_jay.mvpdemo.model.UserModel;
import com.example.kb_jay.mvpdemo.view.IViewLogin;

/**
 * Created by kb_jay on 2018/4/17.
 */

public class LoginPresenter {

    private IViewLogin mLoginView;
    private UserModel mUserModel;

    public LoginPresenter(IViewLogin view) {
        mLoginView = view;
        mUserModel = new UserModel();
    }

    public void login(){
        mLoginView.showLoading();
        mUserModel.login(mLoginView.getName(), mLoginView.getPwd(), new OnLoginListener() {
            @Override
            public void onSuccess(UserBean bean) {
                mLoginView.hideLoading();
                mLoginView.jump2main();
            }

            @Override
            public void onFailed(int code, String msg) {
                mLoginView.hideLoading();
                mLoginView.showErrorToast(msg);
            }
        });
    }
    public void clear(){
        mLoginView.clearName();
        mLoginView.clearPwd();
    }

}
