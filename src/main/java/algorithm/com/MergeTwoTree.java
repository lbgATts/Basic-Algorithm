package com;

import java.util.Stack;

public class MergeTwoTree {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
              this.left = null;
              this.right = null;
          }
      }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        if (t1 == null && t2 == null) return null;
        int leftValOfT1 = t1.val;
        int leftValOfT2 = t2.val;
        TreeNode newRoot = new TreeNode(leftValOfT1 + leftValOfT2);
        newRoot.left = mergeTrees(t1.left,t2.left);
        newRoot.right = mergeTrees(t1.right,t2.right);
        return newRoot;
    }

    public static void preOrderVisit(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderVisit(root.left);
            preOrderVisit(root.right);
        }
    }

    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);

        node1.left = node12;
        node1.right = node13;
        node12.left = node14;
        node12.right = null;

        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(4);
        TreeNode node25 = new TreeNode(7);

        node2.left = node22;
        node2.right = node23;
        node22.left = null;
        node22.right = node24;
        node23.left = null;
        node23.right=node25;

//        TreeNode t = mergeTrees(node1,node2);
//        preOrderVisit(t);

//        preOrder(node1);
        inOrder(node1);
    }


    /**
     *      1
     *     / \
     *    3  2
     *   /
     *  5
     */
    //三种遍历方式的非递归实现
    public static void preOrder(TreeNode root) {
      Stack<TreeNode> s = new Stack<TreeNode>();
      TreeNode p = root;
      while (!s.isEmpty() || p != null) {
          while(p != null) {
             System.out.println("Current node:" + p.val);
             s.push(p);
             p = p.left;
          }
          if (!s.isEmpty()) {
            p = s.pop();
            p = p.right;
          }
      }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(!s.isEmpty() || p != null) {
            while(p != null) {
                s.push(p);
                p = p.left;//found the most left node
            }
            // find the most left node and enter into stack
            if (!s.isEmpty()) {
                p = s.pop();
                System.out.println("Current node:" + p.val);
                p = p.right;
            }
        }
    }

    // 参考实现 https://blog.csdn.net/snow_7/article/details/51788172

    public static void postOrder(TreeNode root) {
        //后续就比较难了 还是算了吧
    }
}

