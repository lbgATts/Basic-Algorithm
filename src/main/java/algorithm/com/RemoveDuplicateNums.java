package com;

public class RemoveDuplicateNums {
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        print(nums);
        return i;
    }

    public static void print(int a[]) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

    public static void main(String args[]) {
        int a[] = new int[] {1,1,1,2,2,3};
        removeDuplicates(a);
    }
}
