package com;

public class ReverseWord2 {
    public String ReverseSentence(String str) {
        char[] cs = str.toCharArray();
        // reverse the whole word
        reverse(cs, 0, cs.length-1);
        int start = 0;
        int end = 0;
        int s=0;
        while (start < cs.length) {
            //跳过空格
            while(start < cs.length && cs[start] == ' ') {
                start++;
            }
            end=start;
            //start 往前移动，end 在后，
            while(start < cs.length && cs[start] != ' ') {
                start++;
                //end++;
            }
            //上述逻辑很简单
            reverse(cs, end, start-1);
            end = start+1;
        }
        return new String(cs);
    }

    //这种翻转  cs 是引用，不会造成交换不生效问题
    void reverse(char[] cs, int start,int end) {
        while(start < end) {
            char tmp = cs[start];
            cs[start] = cs[end];
            cs[end]=tmp;
            start++;
            end--;
        }
    }
}
