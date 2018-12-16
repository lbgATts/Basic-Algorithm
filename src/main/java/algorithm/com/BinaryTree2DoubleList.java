package com;

public class BinaryTree2DoubleList {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode head = null;
    TreeNode tail = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        visit(pRootOfTree);
        return head;
    }
    public void visit(TreeNode curNode) {
        if (curNode == null) return;
        visit(curNode.left);
        createList(curNode); // 先是造左孩子的节点
        visit(curNode.right);
    }
    //以当前节点创建链表
    public void createList(TreeNode curNode) {
        if (tail != null) {
            curNode.left = tail;
            tail.right = curNode;
            tail = curNode;
        } else {
            head = curNode;
            tail = curNode;//没有尾节点，当前节点设置为第一个节点
        }
    }

    private static void SetSubTreeNode(TreeNode root, TreeNode lChild, TreeNode rChild)
    {
        if (root == null)
        {
            return;
        }

        root.left = lChild;
        root.right = rChild;
    }




    private TreeNode convertDllToBST(int len) {
        if (len == 0) {
            return null;
        }
        TreeNode left = convertDllToBST(len / 2);
        TreeNode root = head;
        root.left = left;
        head = head.right;
        TreeNode right = convertDllToBST(len - (len / 2) - 1);
        root.right = right;
        return root;
    }


    TreeNode root;
    public TreeNode Convert2(TreeNode head) {
        int cnt = 0;
        TreeNode cur = head;
        while(cur!=null){
            cur = cur.right;
            cnt++;
        }
        return create(head,0,cnt-1);
    }
    private TreeNode create(TreeNode head, int left, int right){
        if (left>right)
            return null;
        int mid = left + (right - left)/2;
        TreeNode leftChild = create(head,left,mid-1);
        TreeNode parent = new TreeNode(head.val);
        parent.left = leftChild;
        head = head.right;
        parent.right = create(head,mid+1,right);
        return parent;
    }

    public static void preOrder(TreeNode t) {
        if (t == null) return;
        System.out.print(t.val + ",");
        preOrder(t.left);
        preOrder(t.right);
    }
    public static void main(String args[]) {

        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node14 = new TreeNode(14);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);

        SetSubTreeNode(node10, node6, node14);
        SetSubTreeNode(node6, node4, node8);
        SetSubTreeNode(node14, node12, node16);


        TreeNode retNode = new BinaryTree2DoubleList().Convert(node10);

//        while (retNode != null) {
//            System.out.print(retNode.val + ",");
//            retNode = retNode.right;
//        }

        TreeNode t = new BinaryTree2DoubleList().convertDllToBST(7);

//        TreeNode t = new BinaryTree2DoubleList().Convert2(retNode);
        preOrder(t);
    }
}
