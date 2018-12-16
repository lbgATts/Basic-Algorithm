package com;

public class FindNumNotGreaterThanTarget {
    public static int findTargetIndex2(int arr[], int target) {
        if (arr == null || arr.length <=0) return -1;
        int start=0,end=arr.length-1;
        int mid;
        while (start < end) {
//            System.out.println(start + ":" + end);
            mid = start + (end-start)/2;
//            System.out.println("mid:" + mid);
            if (arr[mid] <= target){
                start = mid+1;
//                System.out.println("start:" + start);
            }
            else if (arr[mid] < target) end = mid-1;
        }
        if (arr[end] == target) {
            System.out.println(end-1);
            return end-1;
        }else {
            System.out.println(end);
            return end;
        }
    }


    public static void findLowBound(int arr[], int target) {
//        if (arr == null || arr.length <=0) return -1;
//        int start=0,end=arr.length-1;
//        int mid;
//        while
    }


    public static void main(String args[]) {
        findTargetIndex2(new int[]{1,2,3}, 2);
        findTargetIndex2(new int[]{1,1,1}, 1);
        findTargetIndex2(new int[]{1,2,3,4,5}, 5);
        String a = "       abc   ";
        String b = "abc";
        a = a.trim();
        System.out.println(a.equals(b));
    }

}
