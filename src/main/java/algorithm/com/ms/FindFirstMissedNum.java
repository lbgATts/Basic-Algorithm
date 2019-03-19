package algorithm.com.ms;

public class FindFirstMissedNum {
    //找出缺失的第一个元素
    int find1stMissedNum(int a[]) {
        if (a ==null || a.length <=0) return -1;

        return 1;
    }

    //数组的方式构造Tree
    static TreeNode buildATree(int a[], int index) {
        TreeNode root = null;
        if (index < a.length) {
            int value = a[index];
            if(value ==0) return null;

            root = new TreeNode(value);
            root.left = buildATree(a, 2*index+1);
            root.right = buildATree(a, 2*index+2);
            return root;
        }
        return root;
    }

    public static void main(String args[]) {
        int a[] = new int[]{1,2,3,4,0,0,0};

        TreeNode root = buildATree(a, 0);

        preVisit(root);

    }

    //中序
    static void inOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
       inOrderVisit(root.left);
        System.out.println(root.value);
        inOrderVisit(root.right);
    }

    //后序
   static void postOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
       postOrderVisit(root.left);
       postOrderVisit(root.right);
       System.out.println(root.value);
    }

    //先序
    static void preVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preVisit(root.left);
        preVisit(root.right);
    }

    static class TreeNode {
        TreeNode left,right;
        int value;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
