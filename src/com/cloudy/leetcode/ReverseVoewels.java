package com.cloudy.leetcode;

/**
 * 反转元音字母
 * Created by ljy_cloudy on 2018/11/14.
 */
public class ReverseVoewels {

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l < r) {
            while (l < r && !isVowel(chars[l])) {
                l++;
            }
            while (l < r && isVowel(chars[r])) {
                r--;
            }
            if (l < r) {
                swap(chars, l, r);
                l++;
                r--;
            }
        }

        return new String(chars);
    }

    public static void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
