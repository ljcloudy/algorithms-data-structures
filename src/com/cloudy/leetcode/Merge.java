package com.cloudy.leetcode;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * Created by ljy_cloudy on 2018/11/8.
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m + n > 0) {
            if (m == 0) {
                nums1[n - 1] = nums2[n - 1];
                n--;
            } else if (n == 0) {
                m--;
            } else if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int l = 0, r = 0;
        while (l + r < m + n) {
            if (l == m) {
                result[l + r] = nums2[r];
                r++;
            } else if (r == n) {
                result[l + r] = nums1[l];
                l++;
            } else if (nums1[l] > nums2[r]) {
                result[l + r] = nums2[r];
                r++;
            } else {
                result[l + r] = nums1[l];
                l++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }
}
