package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubString {


    //动态规划求最长的回文字符串的长度
    public static String longestLengthOfPalindromeDP(String src) {
        boolean dp[][] = new boolean[src.length()][src.length()];
        int maxLength = 0;
        int curLen = 0;
        int maxStrStartIdx = 0;
        int maxStrEndIdx = 0;
        for (int i =0;i < src.length() ;i++) {
            for (int j=0;j<=i;j++) {
                curLen = (i-j+1);
                if (i-j<=1) dp[j][i] = (src.charAt(i) == src.charAt(j));
                else {
                    dp[j][i] = (dp[j+1][i-1] && src.charAt(i) == src.charAt(j));
                }
                if(dp[j][i] && maxLength < curLen) {
                    maxLength = curLen;
                    maxStrStartIdx = j;
                    maxStrEndIdx = i;
                }
            }
        }
        System.out.println("len:" + maxLength);
        return src.substring(maxStrStartIdx, maxStrEndIdx+1);
    }


    public int minCut(String s) {
        // 回文划分问题
        // 设 cut[i] 表示从i~length-1 位置的最小划分数，
        // 状态转移方程 cut[i] = Math.min(cut[i], cut[j+1]+1) dp[i][j]=1 (如果substring(i,j+1) 是回文串，那么cut[i] 就是当前跟上一个的           // cut[j+1]+1,  +1 表示 既然 substring(i,j+1) 是回文字符串，那么cut[i] 就是cut[j+1]的基础上加上这个[i][j]的一个划分)
        if (s == null || s.equals("")) return 0;
        int length = s.length();
        int dp[][] = new int[length][length]; //下标都是从 0~length-1,
        int cut[] = new int[length+1]; // 这里的下标 因为要保存length个结果，所以数组要开 length+1 个这么大,0~length-1,length-1~length-1
        for (int i=length-1;i>=0;i--) {
            // 往前推
            cut[i] = Integer.MAX_VALUE; //最极端的情况是单个字符切分
            for (int j=i;j<length;j++) {
                if (s.charAt(i) == s.charAt(j) &&( j-i<=1||dp[i+1][j-1] == 1)) { // 剩下 ab 这样的子串也是回文 dp[i+1][j-1] 判断不行
                    dp[i][j] = 1;
                    cut[i] = Math.min(cut[i], cut[j+1]+1);
                }
            }
        }
        return cut[0]-1; // 为什么 -1 ？不明白了
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }

    public void generateOneByOne(String sublist, List<String> list, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateOneByOne(sublist + "(", list, left - 1, right);
        }
        if (right > 0) {
            generateOneByOne(sublist + ")", list, left, right - 1);
        }
        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }
    }

    public static String longestLengthOfPalindrome(String src) {
        int pre,next;
        int maxLength=Integer.MIN_VALUE;
        int curLen=0;
        char[] data = src.toCharArray();
        int maxStrStartIdx = 0;
        int maxStrEndIdx = 0;
        for (int i = 0;i < data.length; i++) {
            pre = i-1;
            next = i+1;
            //针对奇数长度的回文字符串
            while (pre >=0 && next < data.length && data[pre] == data[next]) {
                curLen = next - pre + 1;
                if(curLen > maxLength) {
                    maxLength = curLen;
                    maxStrStartIdx = pre;
                    maxStrEndIdx = next;
                }
                pre--;
                next++;
            }
            pre = i;
            next = i+1;
            while (pre >=0 && next < data.length && data[pre] == data[next]) {
                curLen = next - pre + 1;
                if(curLen > maxLength){
                    maxLength = curLen;
                    maxStrStartIdx = pre;
                    maxStrEndIdx = next;
                }
                pre--;
                next++;
            }
        }
        System.out.println("length:" + maxLength);
        return src.substring(maxStrStartIdx, maxStrEndIdx + 1);
    }

    public static void main(String args[]) {
        System.out.println(longestLengthOfPalindromeDP("babad"));
    }
}
