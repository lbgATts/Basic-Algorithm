package com;

public class QuickSort {

    public static int partition(int data[], int start, int end) {
        if (data == null) return -1;
        int tmp = data[start];
        while(start < end) {
            while(start < end && data[end] >= tmp) end--;
            data[start] = data[end];
            while(start < end && data[start] <= tmp) start++;
            data[end] = data[start];
        }
        data[start] = tmp;
        return start;
    }

    public static void quickSort(int data[], int start, int end) {
        if (start >= end) {
            return;
        }
        int pos = partition(data, start, end);
        if (pos < 0) return;
        quickSort(data, start, pos-1);
        quickSort(data, pos+1, end);
    }

    public static void print(int data[]) {
      if (data == null) return;
      for (int i=0;i<data.length;i++) {
        System.out.println(data[i]);
      }
    }

    public static void main(String args[]) {
        int a[] = {1,7,3,5,9,4,8};
        quickSort(a, 0, 6);
        print(a);
    }
}
