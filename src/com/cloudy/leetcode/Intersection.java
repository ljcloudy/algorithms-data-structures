package com.cloudy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ljy_cloudy on 2018/11/19.
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            result[idx++] = iterator.next();
        }

        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1Map.containsKey(nums1[i])) {
                nums1Map.put(nums1[i], nums1Map.get(nums1) + 1);
            } else {
                nums1Map.put(nums1[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(nums1Map.containsKey(nums2[i]) && nums1Map.get(nums2[i]) !=0){
                list.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) -1);
            }
        }
        int[] result = new int [list.size()];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            result[index++] = list.get(i);
        }

        return result;
    }
}
