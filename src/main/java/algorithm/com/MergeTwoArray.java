package com;

public class MergeTwoArray {

    public static int[] mergeArray(int a[], int b[]) {
        int lenA = a.length;
        int lenB = b.length;
        int i=0,j=0,k=0;
        int c[] = new int[lenA + lenB];
        while(i<lenA && j<lenB) {
            if(a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(i<lenA){
            c[k++] = a[i++];
        }
        while(j<lenB){
            c[k++] = b[j++];
        }
        return c;
    }

    static void print(int a[]){
        for (int i=0;i<a.length;i++){
            if(i+1 >= a.length) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + ",");
            }
        }
    }
    public static void main(String args[]) {
        int a[] = {2,4,8};
        int b[] = {-1,1,5,9};
        print(mergeArray(a,b));
    }
}
