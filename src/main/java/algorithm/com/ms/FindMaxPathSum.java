package com.ms;

import com.printByZshape;

import java.util.List;
import java.util.stream.Collectors;

public class FindMaxPathSum {

    static class TreeNode {
        TreeNode left,right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxPath = 0;
    static TreeNode left;
    static TreeNode right;
    public static int findMaxPatSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = findMaxPatSum(node.left);
        if (leftMax + node.val < leftMax) {
            maxPath = leftMax;
            left = node.left;
        }
        int rightMax = findMaxPatSum(node.right);
        if (rightMax + node.val < rightMax) {
            maxPath = rightMax;
            right = node.right;
        }
        if (leftMax + rightMax + node.val > maxPath) {
            maxPath = leftMax + rightMax + node.val;
        }
        return maxPath;
    }

    public static int findFirstMissingPositiveNum(int a[]) {
        if (a == null || a.length <=0) return Integer.MIN_VALUE;
        for (int i=0;i<a.length;i++) {
            if ( (i+1) < a.length && a[i] + 1 != a[i + 1] && a[i] >0 ){
                System.out.println("---> 1 " + (a[i] + 1));
                if (a[i] != 1) {
                    return 1;
                }
                return a[i] + 1;
            }
        }
        int tmp = a[a.length-1] + 1;
        System.out.println("---> 2 " + tmp);
        return tmp;
    }

    public static void main2(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);

        node1.left = node12;
        node1.right = node13;
        node12.left = node14;
        node12.right = null;


        int a[] = new int[]{-100,-99,-1,2};
        findFirstMissingPositiveNum(a);
        int b[] = new int[]{1,3,4};
//        findFirstMissingPositiveNum(b);
    }

    public static void main(String args[]) {
        List<String> list = java.util.Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        List<String> list2 = list.stream().filter(e -> e.length() > 5).collect(Collectors.toList());

        for (String s : list2) {
            System.out.println(s + ":");
        }
    }
}
