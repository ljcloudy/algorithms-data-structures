package com.cloudy.search;

import java.util.Arrays;

/**
 * 二分查找
 * created by lijianyun on 2018/9/3
 */
public class BinarySearch {
    /**
     * 非递归二分查找
     *
     * @param array
     * @param target
     * @return
     */
    public static int find(int[] array, int target) {
        //在array[l,r]之间查找target
        int l = 0, r = array.length - 1;
        while (l <= r) {//查找元素在首尾需要=
            //防止溢出
            int mid = l + (r - l + 1) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分查找
     *
     * @param array
     * @param target
     * @return
     */
    public static int findByRecursion(int[] array, int target) {
        int l = 0, r = array.length - 1;
        return findByRecursion(array, l, r, target);
    }

    private static int findByRecursion(int[] array, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l + 1) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return findByRecursion(array, l, mid - 1, target);
        } else {
            return findByRecursion(array, mid + 1, r, target);
        }
    }

    /*
    二分查找的变种：
    当存在大量重复的元素时，floor找的是第一个，ceil找的是最后一个。
    当不存在指定的元素时，floor是比其小最大的一个，而ceil是比其大最小的一个。
     */
    public static int floor(int[] array, int target) {
        int l = -1, r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (array[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        assert l == r;
        if (l + 1 < array.length - 1 && array[l + 1] == target) {
            return l + 1;
        }
        return l;
    }

    public static int ceil(int[] array, int target) {
        int l = 0, r = array.length;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (array[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        assert l == r;
        if (r - 1 < array.length - 1 && array[r - 1] == target) {
            return r - 1;
        }
        return r;
    }

    /**
     * 返回比target小的元素个数
     * @param array
     * @param target
     * @return
     */
    public static int rank(int[] array, int target) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        int[] array = SortBase.generateRandomArr(10, 1, 100);
        int[] array = {10, 2, 90, 13, 29, 90, 30, 50, 190, 91};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int i = BinarySearch.floor(array, 90);
        int ceil = BinarySearch.ceil(array, 90);

        System.out.println(i + ":" + array[i]);
        System.out.println(ceil + ":" + array[ceil]);


    }
}
