package com;

public class ReplaceBlank {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        return ReverseListCore(null, head);
    }

    public ListNode ReverseListCore(ListNode pre, ListNode cur) {
        if (cur.next == null) {
            cur.next = pre;
            return cur;
        }
        ListNode next = cur.next;
        cur.next = pre;
        ListNode retNode = ReverseListCore(cur,next);
        return retNode;
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        int numberOfBlanks = 0;
        int originLength = str.length();
        int newLength = 0;
        int i=0;
        int j;
        while (i<originLength) {
            if (str.charAt(i) == ' ') {
                numberOfBlanks++;
            }
            i++;
        };
        newLength = originLength + numberOfBlanks * 2;
        originLength--;
        str.setLength(newLength);
        newLength--;
        while (originLength < newLength) {
            if (str.charAt(originLength) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
                originLength--;//替换完之后，要前移动
            } else {
                str.setCharAt(newLength--, str.charAt(originLength--));
                //也要前移
            }
        }
        return str.toString();
    }

    public static void main(String args[]) {
        replaceSpace(new StringBuffer("We are happy."));
    }
}
