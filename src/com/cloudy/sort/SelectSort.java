package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/22
 */
public class SelectSort extends SortBase implements Sort {

    public SelectSort(){
        this.name = "选择排序";
    }

    /**
     * 选择排序
     * 思路：每次从剩余数组中选择最小值
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //最小值的索引
            int minIndex = i;
            //寻找[i,array.length)之间最小值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] array = SelectSort.generateRandomArr(1000000, 1, 100000);
        sort.testSort(array);
//        print(array);
    }
}
