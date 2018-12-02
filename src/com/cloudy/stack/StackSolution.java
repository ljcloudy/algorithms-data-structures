package com.cloudy.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ljy_cloudy on 2018/11/29.
 */
public class StackSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (s.charAt((i)) == ')' && stack.pop() != '(') {
                return false;
            }
            if (s.charAt((i)) == ']' && stack.pop() != '[') {
                return false;
            }
            if (s.charAt((i)) == '}' && stack.pop() != '{') {
                return false;
            }

        }

        return true;
    }

    public static String simplifyPath(String path) {
        if (path == null)
            return "";
        Stack<String> stack = new Stack();
        String[] words = path.split("/");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0 || words[i].equals("."))
                continue;
            if (words[i].equals("..")) {
                stack.pop();

            } else {
                stack.push(words[i]);
            }
        }
        String result = "";
        if (stack.isEmpty()) {
            result = "/";
        } else {
            for (String str : stack) {
                result += "/" + str;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                cur =stack.pop();
                cur = cur.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "/a/./b/../../c/";
        System.out.println(simplifyPath(s));

    }
}
