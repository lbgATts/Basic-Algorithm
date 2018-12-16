package com;

import java.util.ArrayList;

public class ReverseLinkList {

    static class ListNode {
    	ListNode next;
    	int val;
    	ListNode(int val) {
    		this.val = val;
    	}
    }



    /**
    * 非递归版本，就地翻转
    */
    public static ListNode reverseListNotRecur(ListNode root) {
    	ListNode preNode = null;
    	ListNode curNode = root;
    	ListNode reverseHead = null;
    	while (curNode != null) {
    		ListNode nextNode = curNode.next;
    		if (nextNode == null) reverseHead = curNode;
    		curNode.next = preNode;
    		preNode = curNode;
    		curNode = nextNode;
    	}
    	return reverseHead;
    }

    /**
    * 递归版本，一直往下递归，找到最后一个节点，
    */
    public static ListNode reverseListRecur2(ListNode root) {
		if (root == null || root.next == null) return root;
		ListNode retNode = reverseListRecur2(root.next);
        retNode.next.next = retNode; //递归完成以后  retNode 返回的是5  ，然后5.next 会有空指针错误
        retNode.next = null;
        return retNode;
    }

    /**
    * 递归版本，一直往下递归，找到最后一个节点，
    */
    public static ListNode reverseListRecur(ListNode preNode, ListNode curNode) {
		if (curNode == null) return null;
		if (curNode.next == null) {
			curNode.next = preNode;
			return curNode;
		}
		ListNode pNext = curNode.next;
		curNode.next = preNode;
		ListNode retNode = reverseListRecur(curNode, pNext);
		return retNode;
    }

    public static void main(String args[]) {

    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;

		ListNode reverseHead;
    	
//    	reverseHead = reverseListRecur(null, l1);

    	 reverseHead = reverseListNotRecur(l1);

    	while (reverseHead != null) {
    		System.out.print(reverseHead.val);
    		reverseHead = reverseHead.next;
    	}

    }
}
