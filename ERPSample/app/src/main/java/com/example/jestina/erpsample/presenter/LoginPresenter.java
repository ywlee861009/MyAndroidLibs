package com.example.jestina.erpsample.presenter;

import android.content.Context;

import com.example.jestina.erpsample.contract.LoginContract;

/**
 * Created by JESTINA on 2018-09-05.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private Context mContext;

    @Override
    public void initPresenter() {

    }

    /**
     * 현재 View 의 Context 전달
     *
     * @param context 현재 View 의 Context
     */
    public void setContext(Context context) {
        this.mContext = context;
    }
}
