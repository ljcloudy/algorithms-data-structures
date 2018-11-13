package com.cloudy.leetcode;

import java.util.Arrays;

/**
 * Created by ljy_cloudy on 2018/11/8.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int l = -1, r = nums.length;
        //将数组分为三部分[0 ~ l] (l ~ r) [r ~ nums.length -1]
        for (int i = 0; i < r; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --r);
            } else {
                assert nums[i] == 1;
                swap(nums, i++, ++l);
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortColors2(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount != 0) {
                nums[i] = 0;
                zeroCount--;
            } else if (oneCount != 0) {
                nums[i] = 1;
                oneCount--;
            } else if (twoCount != 0) {
                nums[i] = 2;
                twoCount--;
            }
        }
    }
}
