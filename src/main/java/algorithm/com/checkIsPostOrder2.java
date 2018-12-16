package com;

public class checkIsPostOrder2 {
    public static boolean checkIsPostOrder(int a[]) {
        if (a == null || a.length <=0) return false;
        return  checkIsPostOrderCore(a,0,a.length-1);
    }

    //check the pos from start to end is a postorder of a binary tree
    public static boolean checkIsPostOrderCore(int a[], int start,int end) {
        if (start >= end) return true;
        int i=start;
        int j;
        while(i<end && a[i]<a[end]) {
            i++;
        }
        j=i;
        //找到后半部分，如果都是小于这个值，那么肯定是 false
        for (;j<end;j++) {
            if(a[j] < a[end]) return false;
        }
        return checkIsPostOrderCore(a,start,i-1) && checkIsPostOrderCore(a,i,end-1);
    }

    public static void main(String args[]) {
        System.out.println(checkIsPostOrder(new int[]{5,7,6,11,13,12,10}));
    }
}
