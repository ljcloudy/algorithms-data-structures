package com.cloudy.unionfind;

/**
 * created by lijianyun on 2018/9/16
 */
public class UnionFind2 {
    //表示元素所指向的父节点
    private int[] parent;

    private int count;//数据个数

    public UnionFind2(int count) {
        parent = new int[count];
        this.count = count;
        //初始化，每个parent[i]指向自己，表示每个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        assert (p >= 0 && p < count);
        //不断去查询自己的父节点，直到根节点
        //根节点的特点 p == parent[p]
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查找p和q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属集合
     * 时间复杂度O(h),h为树的高度
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    public static void main(String[] args) {
        int n = 100000;
        UnionFindTestHelper.testUF2(n);
        UnionFindTestHelper.testUF1(n);
    }
}
