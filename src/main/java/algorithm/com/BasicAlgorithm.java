package com;

import java.util.function.Predicate;

public class BasicAlgorithm {

    /**
     * 最常见的创建方式
     * @param data
     * @param start
     * @param end
     * @return
     */
    static int partition(int data[],int start,int end) {
        int tmp = data[start];
        while(start < end) {
            while(start < end && data[end] >= tmp) end--;
            if(start < end){
                data[start++] = data[end];
            }
            while(start < end && data[start] <= tmp) start++;
            if(start < end){
                data[end--] = data[start];
            }
        }
        data[start] = tmp;
        return start;
    }

    /**
     * 另外一种常见的分割函数，比第一种更优化
     * @param data
     * @param start
     * @param end
     * @return
     */
    static int partition2(int data[],int start,int end) {
        int tmp = data[start];
        int pos = start;
        while(true) {
            //int a[] = {1,3,5,2,4,6,-1};
            while(start < end && data[end]>=tmp)end--;
            System.out.println("start:" + start + " end :" + end);
            if(start >= end){
                break;
            }
            while(start < end &&data[start]<=tmp)start++;
            if(start >= end){
                break;
            }
            int a = data[end];
            data[end] = data[start];
            data[start] = a;
//            System.out.println("start:" + start + " end :" + end);
        }
        int b = data[end];
        data[end] = data[pos];
        data[pos] = b;
        return start;
    }

    static void swap(int a,int b) {
        int tmp=a;
        a = b;
        b = tmp;
    }



    static void printArray(int arr[]) {
        for (int i=0;i<arr.length;i++) {
            if (i+1>=arr.length) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    /**
     * 快速排序
     * @param data
     * @param start
     * @param end
     */
    static void quickSort(int data[],int start,int end) {
        if (data == null || data.length <=0) return;
        if (start < end) {
            int pos = partition2(data,start,end);
            quickSort(data,start,pos-1);
            quickSort(data,pos+1,end);
        }
    }


    /**
     * 大根堆调整
     * 一遍调整后，最大的元素就被放入了数组的最后一个位置
     * length 大小表示 需要维护多大的堆
     * @param arr
     */
    static void adjustMaxHeap(int arr[],int parent,int length) {
        //基本思路 从当前位置往下一直调整堆
        if(arr == null || arr.length<=0) return;
        int child = 2 * parent + 1; //left child
        int tmp = arr[parent];
        while(child < length) {
            if (child+1 < length && arr[child] < arr[child+1]) child++;
            if (arr[child] <= tmp) break;
            arr[parent] = arr[child];
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = tmp;
    }

    /**
     * 小根堆调整
     * @param arr
     * @param parent
     * @param length
     */
    static void adjustMinHeap(int arr[],int parent,int length) {

    }

    /**
     * 堆排序的主方法
     * @param arr
     *
     */
    static void heapSort(int arr[]) {
        if (arr == null || arr.length <=0) {
            return;
        }
        int len = arr.length;
        //从最后一个节点往下开始调整堆，直到从0位置开始往下调整
        for (int i=arr.length/2-1;i>=0;i--) {
            adjustMaxHeap(arr, i, len);
        }

        //这里有个交换过程，是在数组内交换的
        for (int i=len-1;i>0;i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustMaxHeap(arr, 0, i);
        }
    }


    /**
     * topk 问题的 堆排序解法，会造成原来的数组变成无序的
     * @param arr
     * @param k
     */
    static void topK(int arr[], int k) {
        //构建k个元素大小的堆
        for(int i=0;i<k;i++) {
            //这里为什么从 i 开始调整
            // 因为一遍就能找到k个元素中的最大，没有比他更大的，下次放心从 i =1 开始调整
            adjustMaxHeap(arr,i,k);
        }
        for(int i=k;i<arr.length;i++) {
            //这里有个疑惑 为什么arr[0]是当前最大，arr[i] 比他还大
            //因为现在arr[i] 是最大，后面来的arr[j] 可能比arr[i]还大，比如放在arr[1]位置 如果从 1 开始调整
            //将会导致当前最大的arr[j] 不能被放到arr[1],所以从 0 开始从新调整堆
            if (arr[i] < arr[0]) {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
                adjustMaxHeap(arr,0,k-1);
            }
        }
        System.out.println("最小的k个元素:");
        for (int i=0;i<k;i++) {
            if (i+1>=k) System.out.print(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }

    /**
     * 二分找出target的上界，另外一种写法
     * @param arr
     * @param target
     * @return
     */
    static int findLeftBound(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start <= end ) {
            mid = start + (end-start)/2;
            if (arr[mid] >= target) {
                //从mid开始往左，可能连续几个元素相同
                end = mid - 1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    /**
     * 二分找出target的上界
     * @param arr
     * @param target
     * @return
     */
    static int findLeftBound2(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start < end) {
            mid = start + (end-start)/2;
            if (arr[mid] >= target) {
                //从mid开始往左，可能连续几个元素相同
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end;
    }

    /**
     * 二分找出target的下界
     * @return
     */
    static int findRightBound2(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start < end) {
            mid = start + (end-start)/2;
            if (arr[mid] <= target) {
                //右边大 从 mid 开始连续几个相同数字，从mid 开始
                start = mid;
            } else {
                end = mid -1;
            }
        }
        return start;
    }

    /**
     * 二分找出target的下界,另外一种方法
     * @return
     */
    static int findRightBound(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start <= end) {
            mid = start + (end-start)/2;
            if (arr[mid] <= target) {
                //右边大 从 mid 开始连续几个相同数字，从mid 开始
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return end;
    }

    public static void main(String args[]) {
        int a[] = {1,2,2,2,3,4,5};
        System.out.println(findLeftBound(a,2));
        System.out.println(findRightBound(a,2));
    }

    /**
     * 查找最后一个小于target的元素
     * @param arr
     * @param target
     * @return
     */
    public static int findLastLessNum(int arr[], int target) {
        //arr={1,2,2,2,3}
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start < end) {
            mid = start + (end-start)/2;
            if (arr[mid] >= target) {
                end = mid - 1; // 如果 =target 这里的目标是将其放入
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    /**
     * 查找最后一个小于等于target的元素
     * @param arr
     * @param target
     * @return
     */
    public static void findLastLessNum2(int arr[], int target) {

    }

    /**
     * 查找第一个大于等于target的元素
     * @param arr
     * @param target
     * @return
     */
    public static void findFirstGreaterNum2(int arr[], int target) {

    }

    /**
     * 查找第一个大于target的元素
     * @param arr
     * @param target
     * @return
     */
    public static void findFirstGreaterNum3(int arr[], int target) {

    }

    /**
     * 归并排序的简单实现,怎么优化空间复杂度
     * @param arr
     */
    public static void mergeSort(int arr[], int low,int high) {
        int mid = (low + high)/2;
        if (low < high) {
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    /**
     * 对arr 从start 到 mid, mid + 1 到 end 表示的两个数组 进行合并
     * @param arr
     * @param start
     * @param end
     */
    //TODO 怎么优化空间复杂度
    public static void merge(int arr[], int start, int mid, int end) {
        //借助tmp 数组，耗费O(n)的空间复杂度
        int k=0;
        int tmp[] = new int[end-start+1];
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) { //注意这里的 <= 如果
            if (arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (i=0;i<k;i++) {
            arr[start+i] = tmp[i];
        }
    }

    public static void swap(int a[], int start,int end) {
        int tmp = a[start];
        a[start] = a[end];
        a[end] = tmp;
    }

    public static void print(int a[]) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + ",");
        }
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void printList(ListNode root) {
        while (root.next != null) {
            System.out.print(root.val + ",");
            root = root.next;
        }
    }

    /**
     * 使用类似快排 partition 的方式来对单链表排序
     * @param start
     */
    public static void singleListSort(ListNode start, ListNode end) {
        if (start == null || end == null || start == end) {
            return;
        }
        ListNode mid = partition5(start, end);
        singleListSort(start, mid);  //递归没有出口，会死循环下去
        singleListSort(mid.next, end);
    }

    /**
     * 单链表只有一个头结点可用
     * @param startNode
     * @return 返回一个开始分割的点
     */
    public static ListNode partition5(ListNode startNode, ListNode endNode) {
        if (startNode == null) return startNode;
        ListNode first = startNode;
        ListNode end = startNode.next;
        int initialValue = first.val;
        while (end != null && end != endNode.next) { //一直往后
            if (end.val <= initialValue) {
                first = first.next;
                if (first != end) {
                    int tmp = first.val;
                    first.val = end.val;
                    end.val = tmp;
                }
            }
            end = end.next;
        }
        if (first != startNode) {
            int tmp = first.val;
            first.val = startNode.val;
            startNode.val = tmp;
        }
        return first;
    }

    /**
     * 快排的partition 另外一种写法,以尾节点为数轴元素
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition3(int arr[], int low, int high) {
        int p = low;
        int tmp = arr[high];// 以end元素为数轴元素，为什么？😠
        int j = low;
        while (j < high) {
            if (arr[j] <= tmp) {
                swap(arr, j, p++);
            }
            j++;
        }
        swap(arr,p,high); //换到最后，arr[i] 后面全是比arr[end]大的，上次的p已经++，所以这次不用++
        return p;
    }


    /**
     * 快排的partition 另外一种写法,以头节点为数轴元素
     * 有趣的是使用了前后两个指针
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition4(int arr[], int low, int high) {
        int p = low;
        int tmp = arr[low];// 以end元素为数轴元素，为什么？😠
        int j = low+1; //这里从第二个位置开始，就算第一个元素 比 第二个元素大，他们也不会交换，
        while (j <= high) {
            if (arr[j] <= tmp) {
                p++;
                swap(arr, j, p);
            }
            j++;
        }
        swap(arr, p, low); //换到最后，arr[i] 后面全是比arr[end]大的，上次的p已经++，所以这次不用++
        return p;
    }


    public static void quickSort3(int arr[],int start,int end) {
        if (start < end) {
            int pos = partition4(arr, start, end);
            quickSort3(arr, start, pos-1);
            quickSort3(arr, pos+1, end);
        }
    }

    /**
     * 快排的非递归写法
     * @param arr
     */
    public static void quickSortNoRecur(int arr[]) {

    }



    public static void main2(String args[]) {

        //==========快排 topk 问题===========
        int a[] = {1,3,5,2,4,6,-1};
        if (false) {
            quickSort(a,0,a.length-1);
            heapSort(a);
            topK(a,4);
            printArray(a);
        }
        //===============================


        //===========这样可以完成数字交换========
        if (false){
            int b[] = new int[]{2,1};
            swap(b,0,1);
            for (int i=0;i<2;i++) {
                System.out.println(b[i]);
            }
        }
        //===========这样可以完成数字交换=========



        //=========测试二分查找====================
        int arr[] = {1,2,2,2,3,4};
        if (false) {
            System.out.println(findLeftBound(arr,2));
            System.out.println(findRightBound(arr,2));
            System.out.println(findLastLessNum(arr,3));
        }

        //=======================================


        //=========归并排序测试=================
         if (false) {
            int d[] = new int[]{1,3,5,2,4,6};
            mergeSort(d,0,5);
            print(d);
         }
        //====================================


        //=========测试 quickSort3========
        if (true) {
            int c[] = new int[]{1,3,5,2,7,9,8,-1};
            quickSort3(c,0,7); //测试了两种partition方式，分别以头尾开始
            print(c);
        }
        //================================


        //==========测试 快排 单链表=========
        ListNode n1 = new ListNode(2);
        ListNode n12 = new ListNode(1);
        ListNode n13 = new ListNode(3);
        ListNode n16 = new ListNode(6);
        ListNode n17 = new ListNode(7);
        ListNode n18 = new ListNode(-1);

        n1.next= n12;
        n12.next=n13;
        n13.next=n16;
        n16.next=n17;
        n17.next=n18;

        ListNode n11 = n1;
        while (n11.next != null) {
            n11 = n11.next;
        }

        if(false){
            singleListSort(n1, n11);
            printList(n1);
        }
        //================================
    }
}
