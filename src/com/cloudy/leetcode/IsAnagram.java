package com.cloudy.leetcode;

/**
 * Created by ljy_cloudy on 2018/11/19.
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] sArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)-'a']++;
            sArr[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
