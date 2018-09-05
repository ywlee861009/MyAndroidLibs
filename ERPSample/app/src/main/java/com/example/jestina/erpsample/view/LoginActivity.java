package com.example.jestina.erpsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jestina.erpsample.R;
import com.example.jestina.erpsample.contract.LoginContract;
import com.example.jestina.erpsample.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);

    }
}
