package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/28
 */
public class Quick3WaysSort extends SortBase {

    public Quick3WaysSort() {
        this.name = "quick3WaysSort";
    }

    @Override
    public void sort(int[] array) {
        quickSort3Ways(array, 0, array.length - 1);
    }

    /**
     * 针对大量重复的元素优化:数组分成三块 小于v  等于v  大于v
     *
     * @param array
     * @param l
     * @param r
     */
    public void quickSort3Ways(int[] array, int l, int r) {
        if (l > r) {
            return;
        }
        swap(array, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = array[l];

        int lt = l; // array[l+1,lt] < v
        int gt = r + 1; //array[gt,r] > v
        int i = l + 1; // array[lt +1, i) == v

        while (i < gt) {
            if (array[i] < v) {
                swap(array, i, lt + 1);
                lt++;
                i++;
            } else if (array[i] > v) {
                swap(array, i, gt - 1);
                gt--;
            } else {//array[i] == v
                i++;
            }
        }
        swap(array, l, lt);
        quickSort3Ways(array, l, lt - 1);
        quickSort3Ways(array, gt, r);

    }
}
