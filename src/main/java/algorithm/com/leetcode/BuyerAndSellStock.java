package com.leetcode;

public class BuyerAndSellStock {

    public static int findMaxProfit(int a[]) {
        int curMin = a[0];
        int maxProfit = 0;
        for (int i=1;i<a.length;i++) {
            curMin = Math.min(curMin, a[i]);
            maxProfit = Math.max(maxProfit, a[i] - curMin);
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
    public static void main(String args[]) {
        findMaxProfit(new int[]{7,1,5,3,6,4});
    }
}
