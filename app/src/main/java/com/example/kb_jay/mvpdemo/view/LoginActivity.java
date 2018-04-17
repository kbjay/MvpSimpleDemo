package com.example.kb_jay.mvpdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kb_jay.mvpdemo.R;
import com.example.kb_jay.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IViewLogin {

    private EditText mEtName;
    private EditText mEtPwd;
    private Button mBtLogin;
    private Button mBtClear;
    private ProgressBar mPbLogin;

    private LoginPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        mPresenter=new LoginPresenter(this);
        mBtClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clear();
            }
        });
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });
    }

    private void findViews() {
        mEtName = (EditText) this.findViewById(R.id.et_name);
        mEtPwd = (EditText) this.findViewById(R.id.et_pwd);
        mBtLogin = (Button) this.findViewById(R.id.bt_login);
        mBtClear = (Button) this.findViewById(R.id.bt_clear);
        mPbLogin = (ProgressBar) this.findViewById(R.id.pb_login);
    }

    @Override
    public String getName() {
        return mEtName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mPbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLogin.setVisibility(View.INVISIBLE);
    }


    @Override
    public void clearName() {
        mEtName.setText("");
    }

    @Override
    public void clearPwd() {
        mEtPwd.setText("");
    }

    @Override
    public void jump2main() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void showErrorToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
