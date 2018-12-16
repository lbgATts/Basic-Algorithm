package com.test.algorithm;

import java.util.Arrays;

public class SumWithGivenTwoNums {

    public static void main(String args[]) {
        int[] data = {1,3,6,4,2,7};
        int data1[] = {1,2,3,4,5,6,7,8};
        Arrays.sort(data); // [1,2,3,4,6,7]
//        printPairSums(data, data.length, 7);
        multiNums(15);

        System.out.println(0x8000000000000000L);
    }

    private static void printPairSums(int data[], int size, int sum) {
        int first = 0;
        int last = size - 1;
        int s = 0;
        while (first < last) {
            s = data[first] + data[last];
            if (data[first] == sum) {
                System.out.println("------- [" + data[first] + "] = " + sum) ;
            }
            if (data[last] == sum) {
                System.out.println("------- [" + data[last] + "] = " + sum);
            }

            if (s == sum) {
                System.out.println("------- [" + data[first] + "," + data[last] + "] = " + sum);
                first++;
                last--;
            } else if (s < sum) {
                first++;
            } else {
                last--;
            }
        }
    }

    static void multiNums(int target) {
        int start = 1;
        int end = 2 ;
        int sum = start + end;
        while (end <= (target+1)/2) {
            while(sum > target) {
                sum -= start;
                start++;
            }
            if (sum == target) {
                for (int i=start;i<=end;i++) {
                    System.out.print(i + ",");
                }
                System.out.println();
            }
            end++;
            sum += end;
        }
    }
}
