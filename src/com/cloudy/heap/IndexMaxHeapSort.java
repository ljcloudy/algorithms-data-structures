package com.cloudy.heap;

import com.cloudy.sort.SortBase;

/**
 * created by lijianyun on 2018/9/2
 */
public class IndexMaxHeapSort extends SortBase{

    @Override
    public void sort(int[] array) {
        IndexMaxHeap heap = new IndexMaxHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            heap.insert(i,array[i]);
        }
        for (int i = array.length-1; i >=0 ; i--) {
            array[i] = heap.extractMax();
        }
    }

    public static void main(String[] args) {
        IndexMaxHeapSort sort = new IndexMaxHeapSort();
        int[] array = generateRandomArr(10,1,100);
        print(array);
        sort.sort(array);
        print(array);
    }
}
