package com.example.jestina.mpandroidchart.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jestina.mpandroidchart.R;
import com.example.jestina.mpandroidchart.contract.MainContract;
import com.example.jestina.mpandroidchart.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter mainPresenter;

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
        mainPresenter = new MainPresenter();
    }
}
