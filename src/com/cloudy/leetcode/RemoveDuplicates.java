package com.cloudy.leetcode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * Created by ljy_cloudy on 2018/11/7.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,3};
        int i = removeDuplicates2(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int index = 0;
        //维护[0,index]不重复元素数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index;
    }

    /**
     *
     给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {

        int index = 0;
        //维护[0,index]重复元素不超过2次数组
        for (int i = 0; i < nums.length; i++) {
           if(index <2 || nums[index-2] != nums[i]){
               nums[index++] = nums[i];
           }
        }

        return index;
    }
}
