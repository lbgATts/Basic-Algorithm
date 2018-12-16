package com;

public class Coinchange {
    public static int coinChange(int[] coins, int amount) {
        if (coins == null) return -1;
        if (amount < 0) return -1;
        int d[] = new int[amount+1];
        for (int j=1;j<=amount;j++) {
            d[j] = Integer.MAX_VALUE;
            for (int i=0;i<coins.length;i++) {
                if (j-coins[i]>=0 && d[j-coins[i]] != Integer.MAX_VALUE) {
                    d[j] = Math.min(d[j], d[j-coins[i]] + 1);
                }
            }
        }
        return d[amount] == Integer.MAX_VALUE ? -1 : d[amount];
    }

    public static void main(String args[]) {
        int a=coinChange(new int[]{1,2,5},11);
        if(a==3){};
    }
}
