package com.cloudy.unionfind;

/**
 * created by lijianyun on 2018/9/15
 */
public class UnionFind1 {
    private int[] id;
    private int count;


    public UnionFind1(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    /**
     * 查找元素p和元素q是都所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }
        //遍历所有元素，将两个元素所属集合编号合并。
        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
