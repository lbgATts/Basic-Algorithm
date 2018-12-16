package com;

public class ReverseWord {
    public String ReverseSentence(String str) {
        if (str == null) return null;
        String newStr = reverse(str,0,str.length()-1);

        //翻转其中空格分开的单词
        char cs[] = newStr.toCharArray();
        int len = cs.length;
        int startIdx = 0;
        int endIdx=0;
        while(startIdx < len) {
            if (cs[startIdx] != ' ') {
                startIdx++;
                endIdx++;
            } else if (cs[endIdx] == ' ' || endIdx == len) {
                System.out.println(startIdx + ":" +endIdx);
                newStr = reverse(newStr, startIdx, endIdx-1);
                endIdx++;
                startIdx = endIdx;
            } else {
                endIdx++;
            }
        }
        return newStr;
    }
    public String reverse(String s, int start, int end) {
        char[] cs = s.toCharArray();
        while(start < end) {
            char tmp = cs[start];
            cs[start] = cs[end];
            cs[end] = tmp;
            start++;
            end--;
        }
        return new String(cs);
    }
    //两种翻转方法都可以
    public String reverseWord(String s, int start,int end){
        char[] cs = s.toCharArray();
        int len = end-start;
        for (int i=start;i<len/2;i++) {
            char tmp = cs[i];
            cs[i] = cs[len-1-i];
            cs[len-1-i] = tmp;
        }
        return new String(cs);
    }

    public static void main(String args[]) {
        String s = "student. a am";
        System.out.println(new ReverseWord().ReverseSentence(s));
    }
}
