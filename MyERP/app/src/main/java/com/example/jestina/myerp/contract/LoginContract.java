package com.example.jestina.myerp.contract;

import android.content.Context;

import com.example.jestina.myerp.presenter.BasePresenter;
import com.example.jestina.myerp.view.BaseView;

/**
 * Created by JESTINA on 2018-09-05.
 */

public interface LoginContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter {

        /**
         * 현재 View 의 Context 전달
         *
         * @param context 현재 View 의 Context
         */
        void setContext(Context context);

        /**
         * 서버로부터 유저 정보를 get
         *
         * @param type
         *              1 = user id
         *              2 = user pw
         *
         * @return parameter 에 따른 id 또는 pw String
         */
        String getUserInfo(int type);
    }
}
