package com.cloudy.leetcode;

/**
 * Created by ljy_cloudy on 2018/11/14.
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            int row = r - l;
            int result = row * Math.min(height[l], height[r]);
            if(result > max){
                max = result;
            }
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}
