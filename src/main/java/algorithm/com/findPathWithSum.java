package com;

import java.util.ArrayList;

public class findPathWithSum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return ret;
        list.add(root.val);
        if (target ==0 && root.left == null && root.right == null){
            ret.add(new ArrayList<Integer>(list));
        }
        target -= root.val;
        if (root.left != null) {
            FindPath(root.left,target);
        }
        if (root.right != null) {
            FindPath(root.right,target);
        }
        //上述 root.left ==null && root.right == null 才能运行到这里，
        // 也就是说 是叶子节点，并且 target 等于 0 还是其他值不知道，如果等于0 是一条路径
        // 如果不是0 那么是其他值，不是一条路径，
        // 不管是不是等于一条合法的路径，都需要将其删除 然后重新计算新的路径
        System.out.println("-----------");
        print(list);
        list.remove(list.size()-1);
        //FindPath(root,target,list,ret,0);
        return ret;
    }

    static void print(ArrayList<Integer> list) {
        System.out.println("");
        for (Integer i :list) {
            System.out.print(i + ",");
        }
        System.out.println("-----------");
    }


    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node12 = new TreeNode(5);
        TreeNode node13 = new TreeNode(12);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(7);

        node1.left = node12;
        node1.right = node13;
        node12.left = node14;
        node12.right = node15;
        FindPath(node1, 22);
    }
}
