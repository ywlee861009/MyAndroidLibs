package com.example.jestina.myapplication.utils;

/**
 * Created by JESTINA on 2018-08-24.
 */

public class Utils {

    /**
     * parameter 로 들어온 String 이 숫자인지 판단.
     * P.S : try-catch 를 통한 숫자 판단은 memory 비용이 많이 든다고 함.
     *
     * @param str 판별대상 string
     * @return 숫자 1, 아님 0
     */
    public static boolean checkNumber(String str) {
        boolean result = false;

        try {
            Double.parseDouble(str);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}
