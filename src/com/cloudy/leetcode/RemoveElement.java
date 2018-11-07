package com.cloudy.leetcode;

import java.util.Arrays;

/**
 *
 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * Created by ljy_cloudy on 2018/11/7.
 */
public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2};
        int size = removeElement(nums, 2);
        System.out.println(size);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int target) {
        int index = 0;
        //维护[0,index)之间不存在target 元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                continue;
            } else {
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }
}
