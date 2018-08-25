package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/24
 */
public class QuickSort extends SortBase {

    public QuickSort() {
        this.name = "quickSort";
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int r) {
        if (l > r)
            return;

        int p = partition(array, l, r);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, r);
    }

    private int partition(int[] array, int l, int r) {

        return 0;
    }
}
