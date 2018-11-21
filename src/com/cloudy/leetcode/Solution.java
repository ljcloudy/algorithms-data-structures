package com.cloudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);

        System.out.println(new HashSet<>(lists));

    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int l, int r) {
        Map<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = l; i < r; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                result.add(Arrays.asList(value, nums[i]));
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> list = twoSum(nums, -nums[i], i + 1, nums.length);
            if (!list.isEmpty()) {
                for (List<Integer> integerList : list) {

                    List<Integer> asList = Arrays.asList(nums[i], integerList.get(0), integerList.get(1));
//                    Collections.sort(asList);
                    if (!set.contains(asList)) {
                        result.add(asList);
                        set.add(asList);
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    result.add(Arrays.asList(i, l, r));
                    while (l < r && nums[l] == nums[l + 1])
                        ++l;
                    while (l < r && nums[r] == nums[r + 1])
                        --r;
                    ++l;
                    --r;
                } else if (nums[l] + nums[r] < target)
                    l++;
                else
                    r--;
            }
        }
        return result;
    }


}