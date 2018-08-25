package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/23
 */
public class InsertSort extends SortBase {

    public InsertSort() {
        this.name = "insertSort";
    }

    /**
     * 类似于按顺序整理扑克牌
     * 插入排序：每次将元素插入到已有序的数组中
     * <p>
     * 在数组有序情况下，时间复杂度为O(n)
     * 一般情况下：O(n^2)
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //写法一
//            for (int j = i; j > 0; j--) {
//                if (array[j] < array[j - 1]) {
//                    swap(array, j, j - 1);
//                } else {
//                    //减少比较次数
//                    break;
//                }
//            }

            //写法二
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
            //写法三 ：优化减少比较次数
//            int tmp = array[i];
//            int j = i;
//            for (; j > 0 && array[j - 1] > tmp; j--) {
//                array[j] = array[j - 1];
//            }
//            array[j] = tmp;

        }
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] array = InsertSort.generateRandomArr(1000000, 1, 1000000);
//        Arrays.sort(array);

//        int[] array2 = InsertSort.generateRandomArr(1000000, 1, 1000000);

//        MergerSort mergerSort = new MergerSort("mergerSort");
//        mergerSort.testSort(array);
//        print(array);
        sort.testSort(array);

//        print(array);
    }
}
