package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceBlankInString {

    /**
     * replace the blank in s with %20
     * @param s
     * @return
     */
    //Mr John Smith -->Mr%20John%20Smith
    static String replaceBlankInString(char[] s) {
        if (s == null || s.length <=0) return null;
        int originStrLen = s.length;
        int numOfBlanks = 0,destStrLen = 0;
        int p1 = originStrLen-1,p2;
        for (int i=0;i<originStrLen;i++) {
            if (s[i] == ' ') {
                numOfBlanks++;
            }
        }
        destStrLen = originStrLen + 2 * numOfBlanks;
        p2 = destStrLen-1;

        char descArr[] = new char[destStrLen];

        System.arraycopy(s,0,descArr,0,originStrLen);
        while (p1 != p2 && p1 >=0) {
            if (s[p1] == ' ') {
                descArr[p2--] = '0';
                descArr[p2--] = '2';
                descArr[p2--] = '%';
            } else {
                descArr[p2--] = s[p1];
            }
            p1--;
        }
        return new String(descArr);
    }

    public static void main(String[] args) {
        System.out.println(replaceBlankInString("Mr John Smith ".toCharArray()));
    }
}
