package com.cloudy.leetcode;

/**
 * Created by ljy_cloudy on 2018/11/15.
 */
public class MiniSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;
        int result = nums.length + 1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                result = Math.min(result, r - l + 1);
            }
        }
        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }


}
