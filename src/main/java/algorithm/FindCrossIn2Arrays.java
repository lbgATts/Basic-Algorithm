package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCrossIn2Arrays {

    /**
     * 找到两个数组的交集
     * @param a
     * @param b
     * @return
     */
    static List<Integer> findCross(int a[], int b[]) {
        List<Integer> result = new ArrayList<>();
        if (a == null || a.length <=0) return result;
        if (b == null || b.length <=0) return result;
        //一种思路是找到两个数组中最短的那个数组，然后以这个数组为基，二分查找该元素是否在长数组中，复杂度O(n*lgn)
        //空间复杂度O(max(m,n))
        int lenA = a.length;
        int lenB = b.length;
        int c[] = lenA > lenB ? b : a;
        int d[] = lenA > lenB ? a : b;
        quickSort(d,0,d.length-1);
        for (int i=0;i < c.length;i++) {
            if(binarySearch(c[i], d, 0,d.length-1)) {
                result.add(c[i]);
            }
        }
        result.stream().forEach(System.out::println);
        return result;
    }

    /**
     * check whether k exists in a
     * @param k
     * @param a
     * @return
     */
    static boolean binarySearch(int k, int a[], int left, int right) {
        if (a == null || a.length <=0 || left > right) return false;
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if (a[mid] == k) return true;
            else if (a[mid] < k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = new int[] {4,2,1,3};
        int b[] = new int[]{1,2};
        findCross(a,b);
    }


    /**
     * 对 a 进行快速排序
     * @param a
     */
    static void quickSort(int a[], int start, int end) {
        int pos = partition(a,start,end);
        if (pos != -1) {
            quickSort(a, start, pos-1);
            quickSort(a,pos+1, end);
        }
    }

    /**
     * 总是以头元素为数轴，以尾元素为数轴
     * @param a
     * @param start
     * @param end
     */
    void quickSort2(int a[], int start, int end) {
        int tmp = a[start];
        a[start] = a[end];
        a[end] = tmp;
    }

    static int partition(int a[], int start,int end) {
      if (a == null || a.length <=0) return -1;
      if (start >= end) return -1;
      int tmp = a[start];
      while (start < end) {
        while (start < end && a[end] >= tmp) end--;
        a[start] = a[end];
        while (start < end && a[start] <= tmp) start++;
        a[end] = a[start];
      }
      a[start] = tmp;
      return start;
    }

    static void printList(int a[]) {
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void main2(String[] args) {
        int a[] = new int[]{-1,0,3,2,8,4,9};
        quickSort(a,0,6);
        printList(a);
    }
}
