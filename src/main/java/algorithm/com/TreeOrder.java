package com;

public class TreeOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <=0) return false;
        int len=sequence.length;
        return checkSeq(sequence,0,len-1);
    }

    //检查这段是不是后序遍历的结构
    public boolean checkSeq(int data[],int start,int end) {
        System.out.println(start + ":" + end);
        if (start >= end) { //这里是为什么？ 这里为什么是大于,这里貌似是一个秘密，如果一开始start<=end 就直接返回了 不会递归
            return true;
        }
        int rootVal = data[end];
        int i=start,j;
        while(i<end && data[i]<rootVal) {
            i++;
        }
        j=i+1;
        while (j<end) {
            if (data[j]<rootVal) return false;
            j++;
        }
        return checkSeq(data,start,i-1) && checkSeq(data,i,end-1);
    }
    public static void main(String args[]) {
        int a[] = {4,7,5,11,13,12,10};
        int b[] = {7,4,6,5};
        System.out.println(new TreeOrder().VerifySquenceOfBST(b));
    }
}
