package com.example.jestina.moveintro;

import android.util.Log;

/**
 * Created by JESTINA on 2018-08-27.
 *
 * 로깅 클래스
 */

public class YWLog {
    private static final String TAG = "MoveImg";
    private static final String FORMAT = "[%s]: %s";

    /**
     * verbose 로그
     *
     * @param msg 로그 내용
     */
    public static void v(String msg) {
        if(!BuildConfig.DEBUG) return;

        Log.v(TAG, String.format(FORMAT, getCallerInfo(), msg));
    }

    /**
     * debug log
     *
     * @param msg log messages
     */
    public static void d(String msg) {
        if(!BuildConfig.DEBUG) return;

        Log.d(TAG, String.format(FORMAT, getCallerInfo(), msg));
    }

    private static String getCallerInfo() {
        try {
            StackTraceElement[] elements = new Exception().getStackTrace();
            String className = elements[2].getClassName();
            String callerInfo = className.substring(className.lastIndexOf(".") + 1, className.length()) + "_" + elements[2].getLineNumber();

            return callerInfo;
        } catch (Exception e) {
            return "";
        }
    }
}
