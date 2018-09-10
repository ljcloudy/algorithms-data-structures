package com.cloudy.heap;

/**
 * 最大索引堆，增加反向索引
 * created by lijianyun on 2018/9/3
 */
public class IndexMaxHeap2 {

    private int[] data;

    private int[] indexes; //最大索引堆中的索引，indexes[x] =i 表示索引在x位置
    private int[] reverse; // 最大索引堆中的反向索引，reverse[i] = x
    private int count;
    private int capacity;

    public IndexMaxHeap2(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, int item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        assert !contain(i);
        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    public int extracMax() {
        assert count > 0;
        int ret = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public int extractMax() {
        assert count > 0;

        int ret = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    // 从最大索引堆中取出堆顶元素的索引
    public int extractMaxIndex() {
        assert count > 0;

        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最大索引堆中的堆顶元素
    public int getMax() {
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, int newItem) {

        assert contain(i);

        i += 1;
        data[i] = newItem;

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
//        for( int j = 1 ; j <= count ; j ++ )
//            if( indexes[j] == i ){
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
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

    private boolean contain(int i) {
        assert i + 1 < capacity && i + 1 >= 1;
        return reverse[i + 1] != 0;
    }
}
