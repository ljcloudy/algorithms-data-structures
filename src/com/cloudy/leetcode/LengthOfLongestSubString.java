package com.cloudy.leetcode;

/**
 * Created by ljy_cloudy on 2018/11/15.
 */
public class LengthOfLongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        int[] freq = new int[256];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(freq[s.charAt(j)], i);
            result = Math.max(result, j - i + 1);
            freq[s.charAt(j)] = j + 1;
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        int l = 0, r = 0;
        int result = 0;

        while (r < s.length()) {
            if (freq[s.charAt(r)] == 0 &&  r < s.length()) {
                freq[s.charAt(r++)] ++;
            } else {
                freq[s.charAt(l++)] --;
            }
            if (r - l > result) {
                result = r - l;
            }
        }
        return result;
    }
}
