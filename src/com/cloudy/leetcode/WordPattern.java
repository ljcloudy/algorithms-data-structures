package com.cloudy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljy_cloudy on 2018/11/19.
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");

        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> map = new HashMap();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(split[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), split[i]);
            }
        }

        return true;
    }
}
