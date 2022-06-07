package com.brandis.brandisweb.util;

public class PasswordUtil {
    final static String REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public static boolean isValid(String password){
        return password.matches(REGEXP);
    }
}
