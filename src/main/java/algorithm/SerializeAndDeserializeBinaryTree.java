package com.test.algorithm;

public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    /**
     *       12
     *     /   \
     *    3    1
     *   / \  / \
     *  nil nil nil
     *
     * 序列化成 12!3!#!#!1!#!#!
     *
     * @param root
     * @return
     */
    String serializeTree(TreeNode root) {
        if (root == null) return "#!";
        int val = root.val;
        String s = String.valueOf(val);
        s += serializeTree(root.left) + "!";
        s += serializeTree(root.right) + "!";
        return s;
    }

    TreeNode deserializeTree(String tree) {
        return null;
    }

    public static void main(String[] args) {

    }
}
