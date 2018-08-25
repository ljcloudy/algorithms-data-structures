package com.cloudy.sort;

/**
 * created by lijianyun on 2018/8/23
 */
public class MergerSort extends SortBase {

    public MergerSort() {
    }

    public MergerSort(String name) {
        super(name);
    }

    @Override
    public void sort(int[] array) {
        mergerSort(array, 0, array.length - 1);
    }

    /**
     * 自低而上
     *
     * @param array
     */
    public void sortBU(int array[]) {
        for (int sz = 1; sz <= array.length; sz += sz) {
            for (int i = 0; i + sz < array.length; i += sz + sz) {
                //对 arr[i,i+sz-1] 和arr[i+sz,i+2*sz-1]进行归并
                merger(array, i, i + sz - 1, Math.min(i + sz + sz - 1, array.length - 1));
            }

        }
    }

    /**
     * 递归使用归并排序，对array[l,r]的范围进行排序
     *
     * @param array
     * @param l
     * @param r
     */
    private void mergerSort(int[] array, int l, int r) {
//        int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        if (l >= r) {
            return;
        }
        //优化：小数组接近有序状态可以使用使用插入排序
//        if (l - r < 15) {
//            InsertSort insertSort = new InsertSort();
//            insertSort.sort(array);
//            return;
//        }

        mergerSort(array, l, mid);
        mergerSort(array, mid + 1, r);
        //优化归并
        if (array[mid] > array[mid + 1]) {
            merger(array, l, mid, r);
        }
    }

    //将数组 arr[l,mid] 和arr[mid+1,r] 进行归并
    private void merger(int[] array, int l, int mid, int r) {
        int[] tmpArr = new int[r - l + 1];
        //临时数组范围：l~r
        for (int i = l; i <= r; i++) {
            tmpArr[i - l] = array[i];
        }
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                array[k] = tmpArr[j - l];
                j++;
            } else if (j > r) {
                array[k] = tmpArr[i - l];
                i++;
            } else if (tmpArr[i - l] < tmpArr[j - l]) {
                array[k] = tmpArr[i - l];
                i++;
            } else {
                array[k] = tmpArr[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        MergerSort mergerSort = new MergerSort("mergerSort");
        InsertSort insertSort = new InsertSort();
//        int[] array = SortBase.generateRandomArr(100000, 1, 100);

        int[] array = SortBase.generateNearlyOrderedArray(100000, 10);
        int[] array2 = SortBase.generateNearlyOrderedArray(100000, 10);
        int[] array3 = SortBase.generateNearlyOrderedArray(10, 10);

//        Arrays.sort(array);
        mergerSort.sortBU(array3);
        print(array3);
        mergerSort.testSort(array);
        insertSort.testSort(array2);
//        selectSort.testSort(array);

//        SortBase.print(array);
    }
}
