package com.example.jestina.myerp.presenter;

import android.content.Context;

import com.example.jestina.myerp.contract.LoginContract;

/**
 * Created by JESTINA on 2018-09-05.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private Context mContext;

    public static final int USER_INFO_ID = 1;
    public static final int USER_INFO_PW = 2;

    @Override
    public void initPresenter() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override
    public String getUserInfo(int type) {
        String result = "";

        if(type == USER_INFO_ID)
            result = "test";

        if(type == USER_INFO_PW)
            result = "test";

        return result;
    }
}

