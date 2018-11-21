package com.cloudy.leetcode;

/**
 * 是否为回文字符串
 *
 * Created by ljy_cloudy on 2018/11/14.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        boolean result = true;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }
            String str1 = String.valueOf(chars[l]);
            String str2 = String.valueOf(chars[r]);
            if (!str1.equalsIgnoreCase(str2)) {
                return false;
            }
            l++;
            r--;
        }

        return result;
    }
}
