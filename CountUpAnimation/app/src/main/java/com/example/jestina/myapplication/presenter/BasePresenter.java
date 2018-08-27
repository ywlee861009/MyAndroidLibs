package com.example.jestina.myapplication.presenter;

import com.example.jestina.myapplication.contract.MainContract;

/**
 * Created by JESTINA on 2018-08-24.
 *
 * 모든 Presenter 가 공통으로 사용하는 interface
 */

public interface BasePresenter {
    void initPresenter(MainContract.View view);
}
