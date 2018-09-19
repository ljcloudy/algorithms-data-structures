package com.cloudy.graph;

/**
 * 求无权图的联通分量
 * created by lijianyun on 2018/9/18
 */
public class Components {
    Graph g;
    private boolean[] visited;  //记录dfs的过程中节点是否被访问
    private int ccount;  //记录联通分量个数
    private int[] id;    //每个节点所对应的联通分量标记


    public Components(Graph graph) {
        //算法初始化
        this.g = graph;
        visited = new boolean[g.v()];
        id = new int[g.v()];
        ccount = 0;
        for (int i = 0; i < g.v(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        //求图的联通分量
        for (int i = 0; i < g.v(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    //返回图的联通分量个数
    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < g.v();
        assert w >= 0 && w < g.v();
        return id[v] == id[w];
    }

    //图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i : g.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
