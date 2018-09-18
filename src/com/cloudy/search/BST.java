package com.cloudy.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * created by lijianyun on 2018/9/10
 */
public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key k, Value v) {
            this.key = k;
            this.value = v;
            left = right = null;
        }

        public Node(Node node) {
            this.left = node.left;
            this.right = node.right;
            this.key = node.key;
            this.value = node.value;
        }
    }

    private Node root; //根节点
    private int count;//树的总节点数

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //向二分搜索树种插入一个节点
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 查看二分搜索树种是否存在key
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return contains(root, key);
    }

    /**
     * 在二分搜索树中搜索键为key所对应的值，如果存在则返回，否则返回null
     *
     * @param key
     * @return
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 层序遍历二叉搜索树
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    /**
     * 返回二叉搜索树中最小键值的节点
     *
     * @return
     */
    public Key minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    /**
     * 返回二叉搜索树中最大键值的节点
     *
     * @return
     */
    public Key maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 删除最小节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 删除最大节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 删除键值为key的节点
     * @param key
     */
    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {//删除最小值
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {//删除最大值
            node.right = remove(node.right, key);
            return node;
        } else {//key == node.key

            //左节点为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            //右节点为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }
            //待删除节点左右节点都不为空
            //找到比删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替删除节点
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            count--;
            return successor;
        }

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }


    private Node minimum(Node node) {
//        while (node.left != null) {
//            minimum(node.left);
//        }
//        return node;
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //后序遍历：释放节点
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    //中序遍历 有序
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    //前序遍历
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node.value;
        } else if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * @param node
     * @param key
     * @return
     */
    private boolean contains(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) > 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    public static void main(String[] args) throws Exception {

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 100;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMin
        // 输出的元素应该是从小到大排列的
        System.out.println("Test removeMin: ");
        while (!bst.isEmpty()) {
            System.out.print("min: " + bst.minimum() + " , ");
            bst.removeMin();
            System.out.println("After removeMin, size = " + bst.size());
        }
        System.out.println();


        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMax
        // 输出的元素应该是从大到小排列的
        System.out.println("Test removeMax: ");
        while (!bst.isEmpty()) {
            System.out.print("max: " + bst.maximum() + " , ");
            bst.removeMax();
            System.out.println("After removeMax, size = " + bst.size());
        }

        System.out.println(Integer.MAX_VALUE);
    }

}
