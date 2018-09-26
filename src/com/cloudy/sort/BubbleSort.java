package com.cloudy.sort;

/**
 * Created by ljy_cloudy on 2018/9/26.
 */
public class BubbleSort extends SortBase {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是排序数组是有序的，排序已完成
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                    flag = false;
                }
            }
            if(flag)
                break;

        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int [] array = generateRandomArr(10,1,20);
        print(array);
        bubbleSort.sort(array);
        print(array);
    }
}
