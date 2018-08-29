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

        //优化：小数组可以使用插入排序
        if (l > r)
            return;

        int p = partition2(array, l, r);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, r);
    }

    /**
     * 对array[l...r]部分进行partition操作
     * 返回p，使得array[l...p-1] < array[p]  ;  array[p+1..i] > array[p]
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] array, int l, int r) {
        //优化 ：随机选择一个基准点
        swap(array, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = array[l];
        // array[l+1...j] < v; array[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < v) {
                swap(array, j + 1, i);
                j++;
            }
        }
        swap(array, l, j);
        return j;
    }

    /**
     * 返回p 使得 array[l,p-1] < array[p]  array[p+1,r] > array[p]
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partition2(int[] array, int l, int r) {
        //优化：随机选择一个基准点
        swap(array, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = array[l];

        int i = l + 1, j = r;
        while (true) {
            while (i <= r && array[i] < v) {
                i++;
            }
            while (j >= l + 1 && array[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, l, j);
        return j;
    }




    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        MergerSort mergerSort = new MergerSort();

        int[] array = generateRandomArr(100000, 1, 10);
        int[] array2 = generateRandomArr(100000, 1, 10);
//        int[] array = generateNearlyOrderedArray(10000000, 100);
//        int[] array2 = generateNearlyOrderedArray(10000000, 100);
//        int[] array2 = generateRandomArr(1000000, 1, 100000);
//        mergerSort.testSort(array2);
//        quickSort.testSort(array);

        quickSort.testSort(array);


    }
}
