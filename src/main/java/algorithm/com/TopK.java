package com;

import java.util.ArrayList;
public class TopK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length <=0 || k < 0 || k > input.length) return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0,end=input.length-1;
        int index = partition(input,start,end);
        while(index != k-1) {
            if (index > k-1) {
                end = index - 1;
                index = partition(input,start,end);
            } else {
                start = index + 1;
                index = partition(input,start,end);
            }
        }
        for (int i=0;i<k;i++) {
            list.add(input[i]);
            System.out.println(input[i]);
        }
        return list;
    }
    public int partition(int data[],int start,int end) {
        int tmp = data[start];
        while(start < end) {
            while(start <end && data[end] >= tmp) {
                end--;
            }
            data[start]=data[end];
            while(start <end && data[start] <= tmp) {
                start++;
            }
            data[end]=data[start];
        }
        data[start]=tmp;
        return start;
    }

    public static void main(String args[]){
        int a[] = {4,5,1,6,2,7,3,8};
        new TopK().GetLeastNumbers_Solution(a,4);
    }
}
