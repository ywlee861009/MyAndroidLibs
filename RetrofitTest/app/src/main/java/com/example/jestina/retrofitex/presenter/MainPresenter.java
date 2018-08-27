package com.example.jestina.retrofitex.presenter;

import android.content.Context;

import com.example.jestina.retrofitex.contract.MainContract;

/**
 * Created by JESTINA on 2018-08-27.
 */

public class MainPresenter implements MainContract.Presenter {
    private Context mContext;

    @Override
    public void initPresenter(Context context) {
        this.mContext = context;
    }
}
