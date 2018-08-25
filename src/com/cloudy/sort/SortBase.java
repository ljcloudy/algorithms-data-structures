package com.cloudy.sort;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * created by lijianyun on 2018/8/21
 */
public class SortBase implements Sort {

    protected String name;

    protected SortBase(String name) {
        this.name = name;
    }

    public SortBase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final SecureRandom RANDOM = new SecureRandom();

    public static final int[] generateRandomArr(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = RANDOM.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    protected void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public static final void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    protected void testSort(int[] array) {
        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        boolean sort = isSort(array);
        assert sort;
        System.out.println(this.name + " 耗时：" + (end - start) / 1000.0 + "s");
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){

        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    private boolean isSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void sort(int[] array) {

    }
}
