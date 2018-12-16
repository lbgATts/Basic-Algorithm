package com;




public class FirstCommonNode {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = 0,len2=0;
        ListNode tmp1=pHead1;
        ListNode tmp2 = pHead2;
        while(pHead1 != null) {
            len1++;
            pHead1 = pHead1.next;
        }
        while(pHead2 != null) {
            len2++;
            pHead2 = pHead2.next;
        }
        if (len1 > len2) {
            for (int i=0;i<len1-len2;i++) {
                tmp1 = tmp1.next;
            }
        }
        if (len1 < len2) {
            for (int i=0;i<len2-len1;i++) {
                tmp1 = tmp2.next;
            }
        }
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val == tmp2.val) {
                return tmp1;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return null;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(3);
        ListNode n16 = new ListNode(6);
        ListNode n17 = new ListNode(7);

        n1.next= n12;
        n12.next=n13;
        n13.next=n16;
        n16.next=n17;

        ListNode n2 = new ListNode(4);
        ListNode n22 = new ListNode(5);

        n2.next=n22;
        n22.next=n16;
        n16.next=n17;

        ListNode common = FindFirstCommonNode(n1,n2);

        while (common != null) {
            System.out.println(common.val);
            common = common.next;
        }
    }

}
