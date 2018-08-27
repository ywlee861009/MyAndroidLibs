package com.example.jestina.myapplication.utils;

import android.util.Log;

/**
 * Created by JESTINA on 2018-08-24.
 *
 */
public class YWLog {
    private static final String TAG = "====>";

    public static void d(String debugMsg) {
        String logStr = buildLogMsg(debugMsg);
        Log.d(TAG, logStr);
    }

    private static String buildLogMsg(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(ste.getFileName());
        /*
         * sb.append(" > "); sb.append(ste.getMethodName());
         */
        sb.append(" > #");
        sb.append(ste.getLineNumber());
        sb.append("] ");
        sb.append(message);
        return sb.toString();
    }
}
