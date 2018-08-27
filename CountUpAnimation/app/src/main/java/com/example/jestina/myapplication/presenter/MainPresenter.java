package com.example.jestina.myapplication.presenter;

import android.content.Context;

import com.example.jestina.myapplication.contract.MainContract;

/**
 * Created by JESTINA on 2018-08-24.
 *
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;

    @Override
    public void initPresenter(MainContract.View view) {
        this.mView = view;
        this.mContext = (Context) view;
    }
}