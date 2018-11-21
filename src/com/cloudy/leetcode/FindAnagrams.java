package com.cloudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Created by ljy_cloudy on 2018/11/18.
 */
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a'] += 1;
        }
        int[] freqS = new int[26];
        int l =0, r = -1;
        while(r+1 < s.length()){
            r++;
            freqS[s.charAt(r)-'a']++;
            if(r-l+1 >p.length()){
                freqS[s.charAt(l++)-'a']--;
            }
            if(r-l+1==p.length()&& same(freqS,freq)){
                result.add(l);
            }
        }
        return result;
    }

    private static boolean same(int[] freqS, int[] freq) {
        for (int i = 0; i < 26; i++) {
            if(freq[i] != freqS[i])
                return false;
        }
        return true;
    }
}
