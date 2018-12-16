package com;

class Solution {

    //找最小的数 为什么要用最大的树填充，因为在变幻的过程中，有可能还是小的
    //d[i] = 2, d[i] = -1,  如果设置成 -1 或者 0，最后最小的可能是0  而不是我要的2，
    //如果设置成最大的数，那么最小的肯定是2，不可能超过最大的数
    public int coinChange(int[] coins, int amount) {
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



    public static String reverseStr(String s){
        char[] str = s.toCharArray();
        for(int i=0;i<str.length/2;i++) {
            char tmp = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = tmp;
        }
        return new String(str);
    }


    public static void main(String args[]) {
        System.out.println(reverseStr("abcde"));
    }
}
