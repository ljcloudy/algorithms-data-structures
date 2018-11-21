package com.cloudy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ljy_cloudy on 2018/11/19.
 */
public class HappyNum {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int i = nSum(n);
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
            n = i;
        }


        return n == 1;
    }

    public static int nSum(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i * i;
            n /= 10;
        }

        return sum;
    }
}
