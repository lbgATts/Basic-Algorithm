package com;

import java.util.ArrayList;
import java.util.Stack;

public class printByZshape {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int layer = 1;

        Stack<TreeNode> oddLayer = new Stack<TreeNode>();
        oddLayer.push(pRoot);

        Stack<TreeNode> evenLayer = new Stack<TreeNode>();

        //为什么是这种条件？
        while(!oddLayer.isEmpty() || !evenLayer.isEmpty()) {
            //奇数层
            if (layer %2 != 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                //这什么条件，因为 empty, 该层访问完了， 下一层的节点也全部放好了
                // 这个层序访问 不一样，层序上下层公用一个栈，混着上下层的节点
                while(!oddLayer.empty()) {
                    TreeNode node = oddLayer.pop();
                    if (node != null) {
                        list.add(node.val);
                        evenLayer.push(node.left);
                        evenLayer.push(node.right);
                    }
                }
                if (!list.isEmpty()) {
                    ret.add(list);
                    layer++;
                }
                while(!evenLayer.isEmpty()){
                    System.out.print("偶 " + evenLayer.peek().val + ",");
                }
            } else {
                //偶数层
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(!evenLayer.empty()) {
                    TreeNode node = evenLayer.pop();
                    if (node != null) {
                        list.add(node.val);
                        oddLayer.push(node.right);
                        oddLayer.push(node.left);
                    }
                }
                if (!list.isEmpty()) {
                    ret.add(list);
                    layer++;
                }
                while(!oddLayer.isEmpty()){
                    System.out.println("奇 " + oddLayer.peek().val + ",");
                }
            }
        }
        return ret;
    }

    public static void printList(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.println("-----");
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


        printList(Print(node1));

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


    }
}
