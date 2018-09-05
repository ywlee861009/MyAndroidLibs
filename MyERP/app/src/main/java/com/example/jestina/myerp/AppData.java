package com.example.jestina.myerp;

import com.example.jestina.myerp.model.UserInfo;

/**
 * Created by JESTINA on 2018-09-05.
 *
 * 공용 데이터
 */

public class AppData {
    private volatile static AppData mAppData;

    public static AppData getInstance() {
        if(mAppData == null) {
            synchronized (AppData.class) {
                if (mAppData == null) {
                    mAppData = new AppData();
                }
            }
        }

        return mAppData;
    }

    // 유저 정보를 담은 객체
    private UserInfo mUserInfo;
    public UserInfo getmUserInfo() {
        return mUserInfo;
    }
    public void setmUserInfo(UserInfo mUserInfo) {
        this.mUserInfo = mUserInfo;
    }


}
