package com;

public class DeleteDuplicationListNode {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead){
        ListNode tmp = pHead;
        ListNode newHead = pHead;
        ListNode p = newHead;
        while(tmp.next != null && tmp != null){
            if(tmp.val == tmp.next.val) {
                int val = tmp.val;
                while(tmp.val == val && tmp != null) {
                    tmp = tmp.next;
                }
                newHead.next = tmp;
            } else {
                newHead = tmp;
                tmp = tmp.next;
            }
        }
        return p;
    }

    public static void print(ListNode p) {
        while(p.next != null){
            System.out.print(p.val + ",");
            p = p.next;
        }
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node44;
        node44.next = node5;

        print(deleteDuplication(node1));
    }
}
