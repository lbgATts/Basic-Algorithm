package com;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    //检测树A 是否是 树B的镜像
    public boolean checkTreeAIsMirrorOfTreeB(TreeNode tA, TreeNode tB) {
        if (tA == null && tB == null) return true;
        if (tA==null || tB == null) {
            return false;
        }
        if (tA.value != tB.value) {
            return false;
        }
        boolean leftIsMirror = false;
        boolean rightIsMirror = false;
        if (tA.left != null && tB.right != null) {
            leftIsMirror = checkTreeAIsMirrorOfTreeB(tA.left, tB.right);
        }
        if (tA.right != null && tB.left != null) {
            rightIsMirror = checkTreeAIsMirrorOfTreeB(tA.right, tB.left);
        }
        return leftIsMirror && rightIsMirror;
    }


    //将一棵树翻转成一个镜像树
    public static void mirrorTree(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        //交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null)
            mirrorTree(root.left);
        if (root.right != null)
            mirrorTree(root.right);
    }

    //将一棵树翻转成一个镜像树, 非递归的方式，使用了队列
    public static void mirrorTree2(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int curQSize = q.size();
            count = 0;
            while (count < curQSize) {
                count++;
                TreeNode curNode = q.poll();
                //避免了在叶子节点还要做null 交换
                if(curNode.left != null && curNode.right != null) {
                    TreeNode tmpNode = curNode.left;
                    curNode.left = curNode.right;
                    curNode.right = tmpNode;
                }
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
        }
    }


    public void constructTree(int preOrder[], int inOrder[]) {

    }

    public void constructTreeCore() {

    }

    /**
     * 判断两棵树是不是同一棵树
     * @return
     */
    public static boolean isSameTree(TreeNode tA, TreeNode tB) {
        if (tA == null && tB == null) return true;
        if (tA.value == tB.value) return true;
        if (tA==null || tB == null) {
            return false;
        }
        boolean leftTreeSame = false;
        boolean rightTreeSame = false;
        if (tA.left != null && tB.left != null) {
            leftTreeSame = isSameTree(tA.left, tB.left);
        }
        if (tA.right != null && tB.right != null) {
            rightTreeSame = isSameTree(tA.right, tB.right);
        }
        return leftTreeSame && rightTreeSame;
    }

    static int index = 0; //计数器
    public static TreeNode KthNode(TreeNode root,int k) {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null) {
                System.out.println("---:" + node.value);
                return node;
            }
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null) {
                System.out.println("+++:" + node.value);
                return node;
            }
        }
        return null;
    }


    public static void main(String args[]) {


        if (false) {
            TreeNode node33 = new TreeNode(5);
            TreeNode node34 = new TreeNode(3);
            TreeNode node35 = new TreeNode(7);
            TreeNode node36 = new TreeNode(2);
            TreeNode node37 = new TreeNode(4);
            TreeNode node38 = new TreeNode(6);
            TreeNode node39 = new TreeNode(8);

            node33.left = node34;
            node33.right = node35;

            node34.left = node36;
            node34.right = node37;

            node35.left = node38;
            node35.right = node39;

            InOrderVisit(node33);

            System.out.println(KthNode(node33,3).value);
        }




        //=================测试mirror 树==========
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;




        //==============另外一棵树，并测试是否是同一棵树================

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(5);
        TreeNode node16 = new TreeNode(6);

        node11.left = node12;
        node11.right = node13;

        node12.left = node14;
        node12.right = node15;

        node13.left = node16;


//        System.out.println(isSameTree(node1, node11));


//        mirrorTree(node1);

        mirrorTree2(node1);

        preOrderVisit(node1);


        //===============测试翻转树是否成功==========
        node1.left = node3;
        node1.right = node2;

        node3.left = node6;

        node2.left = node5;
        node2.right = node4;

//        preOrderVisit(node1);
    }

    public static void preOrderVisit(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderVisit(root.left);
            preOrderVisit(root.right);
        }
    }

    public static TreeNode InOrderVisit(TreeNode root) {
        if (root != null) {
            TreeNode node = InOrderVisit(root.left);
            if (node != null) {
                System.out.println("before:" + node.value);
                return node;
            }
            node = InOrderVisit(root.right);
            if (node != null) {
                System.out.println("after:" + node.value);
                return node;
            }
        }
        return null;
    }

    public void postOrderVisit(TreeNode root) {
        if (root != null) {
            postOrderVisit(root.left);
            postOrderVisit(root.right);
            System.out.println(root.value);
        }

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
