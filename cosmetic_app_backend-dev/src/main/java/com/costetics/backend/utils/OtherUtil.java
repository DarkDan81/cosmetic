package com.costetics.backend.utils;

import java.util.Random;

public class OtherUtil {

    public static String generatePwd(int length)
    {
        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String passSymbols = charsCaps + nums;
        Random rnd = new Random();

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(passSymbols.charAt(rnd.nextInt(passSymbols.length())));
        }
        return sb.toString();
    }
}