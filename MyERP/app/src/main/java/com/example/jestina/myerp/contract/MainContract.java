package com.example.jestina.myerp.contract;

import android.support.v4.app.Fragment;

import com.example.jestina.myerp.view.BaseView;

/**
 * Created by JESTINA on 2018-09-05.
 */

public interface MainContract {

    interface View extends BaseView {
        /**
         * Main Container Fragment 를 초기화면으로 되돌려 주는 함수
         */
        void initFragment();

        /**
         * 현재 쌓여있는 Fragment Stack 들의 초기화
         */
        void clearFragment();

        void addFragment(Fragment f, String tag);

        /**
         *
         */
        void removeFragment();
    }
}
