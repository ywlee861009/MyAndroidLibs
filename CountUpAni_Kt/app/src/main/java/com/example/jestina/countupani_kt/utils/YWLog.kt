package com.example.jestina.countupani_kt.utils

import android.util.Log

/**
 * Created by JESTINA on 2018-09-01.
 */
class YWLog {
    companion object {
        val TAG = "====>"

        fun d(debugMsg: String) {
            val logStr = buildLogMsg(debugMsg)
            Log.d(TAG, logStr)
        }


        private fun buildLogMsg(message: String): String {
            val ste = Thread.currentThread().stackTrace[4]
            val sb = StringBuilder()
            sb.append("[")
            sb.append(ste.fileName)
            /*
             * sb.append(" > "); sb.append(ste.getMethodName());
             */
            sb.append(" > #")
            sb.append(ste.lineNumber)
            sb.append("] ")
            sb.append(message)
            return sb.toString()
        }
    }
}