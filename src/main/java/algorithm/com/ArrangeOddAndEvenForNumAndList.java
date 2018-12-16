package com;

public class ArrangeOddAndEvenForNumAndList {

    public static class ListNode {
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 交换元素的方式来 调整单链表的顺序
     * @param head
     */
    public static ListNode reArrangeOrder(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode p = head;
        while(odd.next != null && even.next != null){ //为什么都要满足，因为odd.next even.next 相互都引用了
                                                     // 如果一方空，另外一方还要走 造成空指针
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead; //[1,3,4,2,6,5]

        while (p != null) {
            System.out.print(p.val + "，");
            p = p.next;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n6 = new ListNode(6);

        n1.next = n3;
        n3.next = n5;
        n5.next = n2;
        n2.next = n4;
        n4.next = n6;

        reArrangeOrder(n1);

    }

    /**
     * 对数组中的数字做全排列，
     * @param data
     */
    public static void reArrangeOrder (int[] data) {
        int i = 0;
        int end = data.length;
        int j;
        // 这种做法从头开始
        while(i < end) {
            //找到第一个偶数
            while(i< end && data[i] % 2 != 0)i++; //找到第一个偶数
            j = i+1;
            while(j< end && data[j] % 2 == 0) j++ ;//找到第一个奇数
            if (j < end) {
                int tmp = data[j];
                for (int k=j-1;k>=i;k--) {
                    data[k+1] = data[k];
                }
                data[i] = tmp;
            } else {
                break;
            }
        }

        for (int d : data) {
            System.out.print(d + ",");
        }
    }

    /**
     * 快排的另一种写法，在需要的时候交换两个元素
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int arr[], int start, int end) {
        int tmp = arr[start];
        int pos = start;
        while (start < end) {
            while (start <end && arr[end] >= tmp) {
                end--;
            }
            while (start < end && arr[start] <= tmp) {
                start++;
            }
            if (start < end) {
                int tmp2 = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp2;
            }
        }
        int tmp3 = arr[start];
        arr[start] = arr[pos];
        arr[pos] = tmp3;
        return start;
    }

    public static void quickSort(int a[], int start, int end) {
        if (start < end) {
            int pos = partition(a,start,end);
            quickSort(a,start,pos-1);
            quickSort(a,pos+1,end);
        }
    }

    public static void main2(String args[]) {
        int a[] = new int[]{1,2,5,3,7,6};
//        quickSort(a, 0, 5);
//        for (int i: a) {
//            System.out.print(i + ",");
//        }
        reArrangeOrder(a);
    }
}
