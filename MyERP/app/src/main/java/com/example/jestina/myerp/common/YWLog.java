package com.example.jestina.myerp.common;

import android.util.Log;

import com.example.jestina.myerp.BuildConfig;


/**
 * Created by JESTINA on 2018-09-05.
 *
 * Custom Log Class
 */
public class YWLog {
    //  Log Filter
    private static final String TAG = "ERP_Android";
    //  Logging Format
    private static final String FORMAT = "[%s]: %s";


    /**
     * Verbose 로그
     *
     * @param msg 로그 메세지
     */
    public static void v(String msg) {
        if(!BuildConfig.DEBUG) return;

        Log.v(TAG, String.format(FORMAT, getcallerInfo(), msg));
    }

    /**
     * Debug 로그
     *
     * @param msg 로그 메세지
     */
    public static void d(String msg) {
        if(!BuildConfig.DEBUG) return;

        Log.d(TAG, String.format(FORMAT, getcallerInfo(), msg));
    }

    /**
     * Error 로그
     *
     * @param msg 로그 메세지
     */
    public static void e(String msg) {
        if(!BuildConfig.DEBUG) return;

        Log.e(TAG, String.format(FORMAT, getcallerInfo(), msg));
    }

    /**
     * Log 를 남길때,
     * 호출한 Class Name 과 Line Number 를 리턴해 주는 함수
     *
     * @return ClassName + LineNumber
     */
    private static String getcallerInfo() {
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
