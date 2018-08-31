package com.cloudy.heap;

import com.cloudy.sort.SortBase;

/**
 * created by lijianyun on 2018/8/30
 */
public class HeapSort extends SortBase {

    /**
     * 需要额外的空间
     *
     * @param array
     */
    public void sort1(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = maxHeap.extracMax();
        }
    }

    /**
     * 原地堆排序，不需要额外空间
     *
     * @param array
     */
    public void sort(int[] array) {
        int n = array.length;
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, n - 1, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            shiftDown(array, i, 0);
        }
    }

    private void shiftDown(int[] array, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && array[j + 1] > array[j]) {
                j += 1;
            }
            if (array[k] >= array[j]) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] array = generateRandomArr(10, 1, 100);
        heapSort.sort(array);
        print(array);
    }
}
