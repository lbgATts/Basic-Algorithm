package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RecursionPermutation {
    public static ArrayList<String> result = new ArrayList<String>();
    public static HashSet<String> set = new HashSet<String>();

    /**
     * 主函数入口
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请随意输入一串字符串：");
        String inputString = "abc";
        ArrayList<String> result = Permutation(inputString);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    /**
     * 递归函数主入口
     *
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return result;
        else
            Permutation(str, 0, str.length() - 1);
        result.addAll(set);
        return result;
    }

    /**
     * 递归条件函数
     *
     * @param str
     * @param start
     * @param end
     */
    public static void Permutation(String str, int start, int end) {
        char[] array = str.toCharArray();
        String r = null;
        if (start == end) {
            r = String.valueOf(array);
            set.add(r);
        } else {
            for (int i = start; i <= end; i++) {
                char tmp = array[start];
                array[start] = array[i];
                array[i] = tmp;

                Permutation(String.valueOf(array), start + 1, array.length - 1);

                tmp = array[start];
                array[start] = array[i];
                array[i] = tmp;
            }
        }
    }
}
