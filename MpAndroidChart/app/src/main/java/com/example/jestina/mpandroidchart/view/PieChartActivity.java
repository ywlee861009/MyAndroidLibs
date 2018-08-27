package com.example.jestina.mpandroidchart.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jestina.mpandroidchart.contract.PieChartContract;
import com.example.jestina.mpandroidchart.presenter.PieChartPresenter;

/**
 * Created by JESTINA on 2018-08-28.
 */

public class PieChartActivity extends AppCompatActivity implements PieChartContract.View {
    PieChartPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new PieChartPresenter();
    }
}
