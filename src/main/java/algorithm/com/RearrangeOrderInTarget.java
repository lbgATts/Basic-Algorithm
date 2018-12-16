package com;

/**
 * 主要完成 单链表，以 target 为界限，大于的往后移动，小于的往前移动
 */
public class RearrangeOrderInTarget {

    public static class ListNode {
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 把 链表中比 target 小的放前面，大的放后面
     * @param root
     * @param target
     */
    public static void reorder(ListNode root, int target) {

    }

    /**
     * 链表排序，
     * @param start
     * @param end
     */
    public static ListNode partitionInStartItem(ListNode start, ListNode end) {
        ListNode p1 = start;
        ListNode p2 = start.next;
        int val = start.val;
        while (p2 != null && p2.next != end) {
            if (p2.val <= val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        int tmp = p1.val;
        p1.val = start.val;
        start.val = tmp;
        return p1;
    }

    /**
     * 链表排序，以key为基准元素，而且假定key 存在链表中
     * @param start
     * @param key
     */
    public static ListNode partitionInTargetLegacy(ListNode start, int key) {
        ListNode p1 = start;
        ListNode p2 = start.next;
        ListNode p3 = start;
        int index = 0;
        while (p3.next != null) {
            if (p3.val == key) { //假设存在
                break;
            }
            index++;
            p3 = p3.next;
        }
        int val = p3.val;
        while (p2 != null && p2.next != null) {
            if (p2.val <= val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        int tmp = p1.val;
        p1.val = p3.val;
        p3.val = tmp;


        //检测是否 key 前的数据都是很检验的
        p1 = start;
        while(p1.next != null && p1.val != p3.val) {
            System.out.print(p1.val + ",");
            p1 = p1.next;
        }

        return p1;
    }

    /**
     * 链表排序，以key为基准元素，而且假定key 存在链表中
     * @param start
     * @param key
     */
//    public static ListNode partitionInTarget(ListNode start, ListNode end, int key) {
    public static ListNode partitionInTarget(ListNode start, ListNode end) {
        ListNode p1 = start;
        ListNode p2 = start.next;
        //find the target Element

        // [2,5,3,8,6,7,10,1]

        // 交换key 跟当前首元素
        int tmp = start.val;

        while (p2 != end.next) {
            if (p2.val <= tmp) {
                p1 = p1.next;
                if (p1 != p2){
                    int tmp2 = p1.val;
                    p1.val = p2.val;
                    p2.val = tmp2;
                }
            }
            p2 = p2.next;
        }
        if(p1 != start) {
            int tmp3 = p1.val;
            p1.val = start.val;
            start.val = tmp3;
        }
        return p1;
    }

    /**
     * 链表排序，以key为基准元素，而且假定key不存在链表中
     * @param start
     * @param key
     */
    public static ListNode partitionInTargetNotExist(ListNode start, int key) {
        ListNode p1 = start;
        ListNode p2 = start.next;
        ListNode p3 = start;
        int index = 0;
        while (p3.next != null) {
            if (p3.val == key) { //假设存在
                break;
            }
            index++;
            p3 = p3.next;
        }
        int val = p3.val;
        while (p2 != null && p2.next != null) {
            if (p2.val <= val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        int tmp = p1.val;
        p1.val = p3.val;
        p3.val = tmp;


        //检测是否 key 前的数据都是很检验的
        p1 = start;
        while(p1.next != null && p1.val != p3.val) {
            System.out.print(p1.val + ",");
            p1 = p1.next;
        }

        return p1;
    }

    public static void reorder(ListNode start, ListNode end, int key) {
//        ListNode mid = partitionInStartItem(start, end);
        // [2,2,5,3,8,4,2,1]

        if (start == null || start == end || end == null) {
            return;
        }

        ListNode mid = partitionInTarget(start, end);
        reorder(start, mid ,key);
        reorder(mid.next, end ,key);
    }

    public static void printList() {
        ListNode head = new ListNode(2);
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(5);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(8);
//        ListNode l5 = new ListNode(4);
//        ListNode l6 = new ListNode(2);
//        ListNode l7 = new ListNode(1);

        // [2,5,3,8,6,7,10,1]
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(1);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

//        ListNode tp = head;
//        tp.next = l3;

        ListNode dummy  = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;

        ListNode tmp = new ListNode(100);
        first.next = tmp;
        tmp.next = l6;

        ListNode p1 = head;
        ListNode p2 = head;

        while(dummy.next != null) {
            dummy = dummy.next;
            System.out.print(dummy.val + ",");
        }

        while(p1.next != null) {
            System.out.print(p1.val + ",");
            p1 = p1.next;
        }
//
//        reorder(p1, p2, 6);
//
//        while(p1.next != null) {
//            System.out.print(p1.val + ",");
//            p1 = p1.next;
//        }
    }

    /**
     * 以第一个元素为数轴元素
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int partitionInFirstItem(int a[], int start, int end) {
        int i = start;
        int val = a[start];//end 等于 length-1
        int j = start+1;
        while (j < end) {
            if (a[j] <= val) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            j++;
        }
        int tmp = a[i];
        a[i] = a[start];
        a[start] = tmp;
        return i;
    }

    /**
     * 以指定的key 划分，大于key的往后，小于key的往前
     * @param a
     * @param key
     * @return
     */
    public static int partitionInTarget(int a[], int key) {
        int index=0;
        while (a[index] != key && index <a.length) {
            index++;
        }
        int i = 0;
        int val = key;//end 等于 length-1
        int j = 0;
        while (j < a.length) {
            if (a[j] <= val) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            j++;
        }
        int tmp = a[i];
        a[i] = a[index];
        a[index] = tmp;
        return i;
    }

    /**
     * 这个key不存在这个
     * @param a
     * @param key
     * @return
     */
    public static int partitionInTarget2(int a[], int key) {
        int index=0;
        while (a[index] != key && index <a.length) {
            index++;
        }

        int i = 0;
        int val = key;//end 等于 length-1
        int j = 0;
        while (j < a.length) {
            if (a[j] <= val) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            j++;
        }
        int tmp = a[i];
        a[i] = a[index];
        a[index] = tmp;
        return i;
    }


    /**
     * 以最后一个元素为数轴元素
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int partitionInLastItem(int a[], int start, int end) {
        int i = start-1;
        int val = a[end];//end 等于 length-1
        int j = start;
        while (j < end) {
            if (a[j] <= val) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            j++;
        }
        int tmp = a[i+1];
        a[i+1] = a[end];
        a[end] = tmp;
        return i+1; //少走一位，所以返回 i+1, i的其实位置从start-1 开始
    }

    public static void quickSort(int a[], int start, int end) {
        if (start < end) {
//            int pos =  partitionInFirstItem(a, start, end);
//            int pos =  partitionInLastItem(a, start, end);
            int pos =  partitionInTarget(a, 2);
            quickSort(a,start, pos-1);
            quickSort(a,pos+1, end);
        }
    }

    public static void printArray(int a[]) {
        for (int i: a) {
            System.out.print(i + ",");
        }
    }

    public static void main(String args[]) {

        if (false){
          int a[] = new int[]{1,3,5,2,4,6};
          quickSort(a,0,5);
          printArray(a);
        }

        if(true) {
            printList();
        }
    }
}
