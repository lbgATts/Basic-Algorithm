package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxNumInWindow {

    static List<Integer> list = new ArrayList();
    public static List<Integer> maxNum(int a[], int w) {
        int min = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i=0;i<a.length;i++) {
            start = i;
            end = i +  w-1;
            if (end>=a.length) break;
            for (int j=start;j<= end && end < a.length;j++) {
                if (a[j] >= min) min = a[j];
            }
            list.add(min);
            min = Integer.MIN_VALUE;
        }
        return list;
    }

    static void printList(List<Integer> list) {
        System.out.println();
        for (Integer i : list) {
            System.out.print(i + ",");
        }
    }

    public static void main(String args[]) {
        int a[] = new int[] {2,3,4,2,6,2,5,1};
        int b[] = new int[] {1,3,-1,-3,5,3,6,7};
        printList(maxNum(b,3));
    }
}
