package com;

public class findSmallestNumInRoateArray {

    public static int findSmallestNum(int data[]) {
        if (data == null || data.length <=0 ) return 0; //no num found
        int start=0,end=data.length-1;
        int mid = 0;
        while (data[start] >= data[end]) {
            if (end-start == 1) {
                mid=end;
                break;
            }
            mid = start + (end-start)/2;
            if (data[start] <= data[mid]) {
                start=mid;
            } else if (data[end] >= data[mid]) {
                end=mid;
            }
        }
        return data[mid];
    }

    public static int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String args[]) {
        int data[] = {3,4,5,1,2};
        int data2[] = {1,0,1,1,1};
        System.out.println(findSmallestNum(data));
        System.out.println(findSmallestNum(data2));
        System.out.println(minNumberInRotateArray(data));
    }
}
