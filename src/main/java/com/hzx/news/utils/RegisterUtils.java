package com.hzx.news.utils;

public class RegisterUtils {

    /**
     * @param str
     * @return 如果unick为空，则返回true，否则返回false
     */
    public static boolean checkStringIsNull(String str) {
        if (str == null) {
            return true;
        }
        if (str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkEmailFormat(String email) {
        if (email == null) {
            return false;
        }
        boolean flag = true;
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            flag = false;
        }
        return flag;
    }

}
