package com.leetcode;

public class RemoveDuplicateNodesInList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        //删除重复节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
