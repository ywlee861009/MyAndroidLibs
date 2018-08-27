package com.example.jestina.myapplication.view;

/**
 * Created by JESTINA on 2018-08-24.
 *
 * 모든 View 가 공통적으로 사용하는 interface
 */

public interface BaseView {
    /**
     * Layout 초기화
     */
    void initLayout();

    /**
     * View 안에 포함된 멤버변수 presenter 를 초기화
     */
    void initMemberPresenter();
}
