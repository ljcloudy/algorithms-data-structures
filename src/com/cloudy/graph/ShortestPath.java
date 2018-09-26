package com.cloudy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by ljy_cloudy on 2018/9/19.
 */
public class ShortestPath {
    //图的引用
    private Graph g;
    //起始点
    private int s;
    //记录dfs节点是否被访问过
    private boolean[] visited;
    //记录路径，from[i]表示查找的路径上i的上一个节点
    private int[] from;
    //记录路径中节点次序。ord[i]表示节点i在路径中次序。
    private int[] ord;

    public ShortestPath(Graph g, int s) {
        assert s >= 0 && s < g.v();
        this.g = g;
        this.s = s;

        visited = new boolean[g.v()];
        from = new int[g.v()];
        ord = new int[g.v()];
        for (int i = 0; i < g.v(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        //无向图的最短路径算法，从s开始广度优先遍历整张图
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int i : g.adj(s)) {
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < g.v();
        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w) {

        assert hasPath(w);

        Stack<Integer> s = new Stack<Integer>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<Integer>();
        while (!s.empty())
            res.add(s.pop());

        return res;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {

        assert hasPath(w);

        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w) {
        assert w >= 0 && w < g.v();
        return ord[w];
    }
}
