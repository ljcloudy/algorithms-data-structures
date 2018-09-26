package com.cloudy.graph;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by ljy_cloudy on 2018/9/19.
 */
public class Path {
    //图的引用
    private Graph g;
    //起始点
    private int s;

    //记录dfs的过程中节点是否被访问过
    private boolean[] visited;
    //记录路径，from[i]表示查找的路径上i的上一个节点
    private int[] from;

    /**
     * 构造函数，寻路算法，寻找图graph从s点到其他节点的路径
     *
     * @param g
     * @param s
     */
    public Path(Graph g, int s) {
        this.g = g;
        assert s >= 0 && s < g.v();

        visited = new boolean[g.v()];
        from = new int[g.v()];
        for (int i = 0; i < g.v(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    /**
     * 图的深度遍历
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int i : g.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    /**
     * 查询s点到w点是否有路径
     *
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < g.v();
        return visited[w];
    }

    /**
     * 查询从s点到w点的路径
     *
     * @param w
     * @return
     */
    public Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> stack = new Stack<>();
        //通过from数组逆向查找到s到w的路径，存放到栈中。
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        Vector<Integer> vector = new Vector<>();
        while (!stack.isEmpty()) {
            vector.add(stack.pop());
        }
        return vector;
    }
    public void showPath(int w){
        assert hasPath(w);

        Vector<Integer> vector = path(w);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.elementAt(i));
            if( i == vector.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
