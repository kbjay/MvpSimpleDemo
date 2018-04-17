package com.example.kb_jay.mvpdemo.view;

/**
 * Created by kb_jay on 2018/4/17.
 */
 /**
  * *
  *
  * 1:该操作需要什么？（getName, getPwd）
    2:该操作的结果，对应的反馈？(jump2main, showErrorToast  clearName  clearPwd)
    3:该操作过程中对应的友好的交互？(showLoading, hideLoading)
  * @author kb_jay
  * created at 2018/4/17 下午6:00
  */
public interface IViewLogin {
    String getName();
    String getPwd();
    void showLoading();
    void hideLoading();
    void clearName();
    void clearPwd();
    void jump2main();
    void showErrorToast(String msg);
}
