package com.test.algorithm;

public class AppearOnce3 {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,2,3,3,3};
       System.out.println(appearOnce(nums));

    }

    public static int appearOnce(int[] nums){
        int len = nums.length;
        int[] bits = new int[32];
        for(int i = 0 ; i < len; i++) {
            for(int j = 0; j < 32; j++) {
                bits[j] += ((nums[i] >> j) & 1);
            }
        }


        int result = 0;
        for(int i = 0 ; i < 32; i++){
            if(bits[i] % 3 == 1) {
                result += 1 << i;
            }

        }
        return result;
    }
}