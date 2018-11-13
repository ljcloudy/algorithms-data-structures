package com.cloudy.leetcode;

import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] result = twoSum1(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }
        }
        return result;

    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int searchTarget = target - numbers[0];
            int record = binarySearch(numbers, i + 1, numbers.length, searchTarget);
            if (record != -1) {
                result[0] = i + 1;
                result[1] = record + 1;
                return result;
            } else {
                continue;
            }
        }

        return result;

    }

    public static int binarySearch(int[] nums, int l, int r, int target) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return -1;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && i < j) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }
}