package com.leetcode;

public class ReverseListFromM2N {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) return head;
        ListNode pre;
        ListNode curNode;
        ListNode workNode = head;
        ListNode newPre;
        int i=1;
        while (workNode.next != null && i != m) {
            workNode = workNode.next;
            i++;
        }
        newPre = workNode;
        pre = workNode;
        curNode = workNode.next;
        ListNode nextNode = null;
        while(i != n && curNode.next != null) {
            nextNode = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = nextNode;
            i++;
        }
        head.next = pre;
        newPre.next = nextNode;
        return head;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(3);
        ListNode n14 = new ListNode(4);
        ListNode n15 = new ListNode(5);

        n1.next= n12;
        n12.next=n13;
        n13.next=n14;
        n14.next=n15;

        ListNode n11 = new ListNode(3);
        ListNode n121 = new ListNode(5);

        reverseBetween(n11 ,1,1);
    }
}
