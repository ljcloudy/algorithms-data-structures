package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/25
 */
public class ShellSort extends SortBase {

    public ShellSort() {
        this.name = "shellSort";
    }


    @Override
    public void sort(int[] array) {
        int gap;
        for (gap = array.length / 2; gap > 0; gap = gap / 2) {
            //对每组内元素进行插入排序
            for (int i = 0; i < gap; i++) {
                groupInsertSort(array, i, gap);
            }
        }
    }

    private void groupInsertSort(int[] array, int i, int gap) {
        for (int j = i + gap; j < array.length; j += gap) {
            //注意k大于gap步长
            for (int k = j; k > gap && array[k] < array[k - gap]; k -= gap) {
                swap(array, k, k - gap);
            }
        }
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        InsertSort insertSort = new InsertSort();

        int[] array = generateRandomArr(1000000, 1, 100);
        int[] array2 = generateRandomArr(1000000, 1, 100);
        sort.testSort(array);
        insertSort.testSort(array2);
//        print(array);
    }
}
