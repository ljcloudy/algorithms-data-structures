package com.cloudy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大逆数对
 * created by lijianyun on 2018/8/28
 */
public class InversionCount {

    public static long solve(int[] array) {
        return solve(array, 0, array.length - 1);
    }

    private static long solve(int[] array, int l, int r) {

        if (l >= r) {
            return 0L;
        }
        int mid = (r - l)/2 + l;
        //求出array[r,mid]范围的最大逆数对
        long s1 = solve(array, l, mid);
        long s2 = solve(array, mid + 1, r);

        return s1 + s2 + merge(array, l, mid, r);

    }

    private static long merge(int[] array, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(array, l, r + 1);
        long res = 0L;
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {//左半部分已处理完
                array[k] = aux[j - l];
                j++;
            } else if (j > r) {//右半部分已处理完
                array[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                array[k] = aux[i - l];
                i++;
            } else {
                array[k] = aux[j - l];
                j++;
                //此时，因为右半部分k所指的元素小，这个元素和左半部分的所有未处理元素构成逆数对
                res += mid - i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] array = {5,2,1,6,7,3,0,4,9,8};
        Arrays.sort(array);

        int [] arr = {9,8,7,6,5,4,3,2,1,0};

        long solve = solve(arr);
        System.out.println(solve);
    }
}
