package com;

public class rebuildBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) return null;
        return constructCore(pre,0, pre.length-1, in, 0, in.length-1);
    }
    public TreeNode constructCore(int [] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd) {
        //find the root
        int value = pre[0];
        TreeNode root = new TreeNode(value);
        root.left = root.right = null;
        if (preStart == preEnd) {
            if (inStart == inEnd && pre[preStart] == in[inStart]) {
                return root;
            }
        }
        //find root in in order array
        int rootIdxInOrder = inStart;
        while(rootIdxInOrder <=inEnd && in[rootIdxInOrder] != value) {
            ++rootIdxInOrder;
        }
        int leftLen = rootIdxInOrder-inStart;
        int leftPreOrderEnd = preStart + leftLen;

        if (leftLen  > 0) {
            root.left = constructCore(pre,preStart+1,preStart+leftLen,in,inStart,rootIdxInOrder-1);
        }
        if (leftLen < preEnd-preStart) {
            root.right = constructCore(pre,leftPreOrderEnd+1,preEnd,in,rootIdxInOrder+1,inEnd);
        }
        return root;
    }

    public static void preOrderVisit(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderVisit(root.left);
            preOrderVisit(root.right);
        }
    }

    public static void main(String args[]) {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,9};
        TreeNode t = new rebuildBinaryTree().reConstructBinaryTree(pre,in);
        preOrderVisit(t);
    }
}
