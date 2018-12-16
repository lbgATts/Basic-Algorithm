package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class HuiWenPartition {
    public static List<List<String>> partition(String s) {
        List<String> path = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        partition(path,res,s,0);
        return res;
    }

    public static void partition(List<String> path, List<List<String>> res, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList(path)); // 这里为什么是 new ArrayList(path) ?
            return;
        }
        for (int i=start;i<s.length();i++) {
            if (isPalindrome(s,start,i)) {
                path.add(s.substring(start,i+1));
//                print("1---->" ,path);
                partition(path,res,s,i+1);
//                print("2---->",path);
                path.remove(path.size()-1); //这里为什么？
            }
        }
    }

    static void print(String prefix, List<String> list) {
        for (String i :list) {
            System.out.print(prefix + i + ",");
        }
        System.out.println("-----------");
    }

    public static boolean isPalindrome(String s, int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String args[]) {
        List<List<String>> ret = partition("abab");
        for (List<String> s : ret) {
            for (String a :s ) {
                System.out.print(a + ",");
            }
            System.out.println("-----------");
        }
    }
}
