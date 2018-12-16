package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class multiLevelPrint {

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

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> list1 = new  ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(pRoot == null)
        {
            return list1;
        }
        TreeNode current = pRoot;
        queue.offer(current);
        int count;//记录当前层已经打印的个数
        int last;//记录当前层一个有多少个
        while(!queue.isEmpty())
        {
            count = 0;
            last = queue.size();
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            //打印一层
            while(count < last)
            {
                current = queue.poll();//出队一个节点并将气质加入到list2中
                list2.add(current.val);
                count++;//每出队一个几点就增加一个当前层已经打印的节点个数
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            list1.add(list2);
        }
        return list1;
    }


    static ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if(pRoot == null)
            return ret;
        q.add(pRoot);
        int now = 1, next = 0;
        while(!q.isEmpty()) {
            TreeNode t = q.remove();
            now--;
            tmp.add(t.val);
            if(t.left != null) {
                q.add(t.left);
                next++;
            }
            if(t.right != null) {
                q.add(t.right);
                next++;
            }
            if(now == 0) {
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now = next;
                next = 0;
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

    //这种方式的实现奥妙是
    static ArrayList<ArrayList<Integer> > Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrs;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(pRoot);
        int last=q.size(), count=0;
        while(!q.isEmpty()){
            count = 0;
            last = q.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            //怎么保证整个程序的正确性
            //模拟下  如果当前是 [2，3], size = 2, 都弹出的时候，arr = [2,3]
            // 并且现在队列中，不为空，上一层[2,3] 全部清理了出去，剩下的都是2，3的子孩子
            while(count<last){
                TreeNode tr = q.poll();
                count++;
                arr.add(tr.val);
                if(tr.left != null){
                    q.add(tr.left);
                }
                if(tr.right != null){
                    q.add(tr.right);
                }
            }
            arrs.add(arr);
        }
        return arrs;
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

        printList(Print3(node1));

    }
}


/**
 *
 * 利用层次遍历的算法，设置变量last指向当前层的最后一个节点，设置变量count记录当前层已经访问的节点的个数，当count等于last时，表示该层访问结束。

 *  层次遍历在求树的宽度、输出某一层节点，某一层节点个数，每一层节点个数都可以采取类似的算法。

 *  树的宽度：在树的深度算法基础上，加一个记录访问过的层节点个数最多的变量max,在访问每层前max与last比较，

 *  如果max比较大，max不变，如果max小于last，把last赋值给max;
 *
 *
 */


