package com.example.jestina.retrofitex.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jestina.retrofitex.R;
import com.example.jestina.retrofitex.contract.MainContract;
import com.example.jestina.retrofitex.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.initPresenter(this);
    }
}
