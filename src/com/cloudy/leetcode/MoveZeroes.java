package com.cloudy.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * Created by ljy_cloudy on 2018/11/5.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int p = 0;
        //定义数组区间[0,p]不存在0元素，维护这个定义
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (p != i) {
                    swap(nums, i, p);
//                    nums[p] = nums[i];
                }
                p++;
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
