package com.cloudy.heap;

import java.util.Arrays;

/**
 * 最大索引堆
 * 堆化索引，不改变原数组的位置，这样查找数组中的元素为O(1)
 * created by lijianyun on 2018/9/2
 */
public class IndexMaxHeap {

    protected int[] data; //最大堆中的数据
    protected int[] indexes; //最大索引堆中的索引

    protected int count;
    protected int capacity;

    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向最大堆中插入一个新的元素，新的元素的索引为，元素为item
     * 传入i对用户而言，是从0索引开始的
     *
     * @param i
     * @param item
     */
    public void insert(int i, int item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        count++;
        shiftUp(count);
    }

    /**
     * 从最大堆中取出堆顶元素，即所有数据中最大值
     *
     * @return
     */
    public int extractMax() {
        assert count > 0;
        int ret = data[indexes[1]];
        swapIndexes(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
     *
     * @return
     */
    public int extracMaxIndex() {
        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 获取对重最大元素
     *
     * @return
     */
    public int getMax() {
        assert count > 0;

        return data[indexes[1]];
    }

    /**
     * 获取最大堆中最大元素的索引
     *
     * @return
     */
    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    public int getItem(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i + 1];
    }

    /**
     * 修改索引位置的元素
     *
     * @param i
     * @param newItem
     */
    public void change(int i, int newItem) {
        i += 1;
        data[i] = newItem;
        //找到indexes[j] = i, j表示data[i]在堆中的位置
        //查找data[i] 在堆中的位置==》可优化
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                j++;
            }
            if (data[indexes[k]] >= data[indexes[j]]) {
                break;
            }
            swapIndexes(k, j);
            k = j;
        }
    }


    /**
     * 索引堆中，数据之间的比较根据data的大小进行比较，但实际操作的是索引
     *
     * @param k
     */

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }

    private void swapIndexes(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
    }

    // 测试索引堆中的索引数组index
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes() {

        int[] copyIndexes = new int[count + 1];

        for (int i = 0; i <= count; i++)
            copyIndexes[i] = indexes[i];

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= count; i++)
            if (copyIndexes[i - 1] + 1 != copyIndexes[i]) {
                res = false;
                break;
            }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    // 测试 IndexMaxHeap
    public static void main2(String[] args) {

        int N = 1000000;
        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        assert indexMaxHeap.testIndexes();
    }

    public static void main(String[] args) {
        IndexMaxHeap heap = new IndexMaxHeap(10);
        int[] array = {2, 90, 23, 10, 4, 59, 3, 29, 0, 5};

        for (int i = 0; i < array.length; i++) {
            heap.insert(i,array[i]);
        }

        for (int i = 0; i <array.length ; i++) {
            System.out.print(heap.extractMax()+" ");
        }
    }
}
