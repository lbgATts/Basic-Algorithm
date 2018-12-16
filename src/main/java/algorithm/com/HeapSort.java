package com;

import java.util.Queue;

public class HeapSort {

    public static void print(int data[]){
        for(int i=0;i<data.length;i++){
            if (i+1>=data.length) {
                System.out.println(data[i]);
            } else
                System.out.print(data[i] + ",");
        }
    }


    //从一个父节点开始往下调整
    //调整大根堆
    public static void adjustMaxHeap(int data[], int parent, int length){
        int tmp = data[parent];
        int child = 2 * parent + 1;
        while(child < length) {
//        for(int child = 2 * parent; child < length ; child *= 2) {
            if(child+1 < length && data[child] < data[child+1]){
                child++;//如果右孩子比左孩子还大，那么肯定先定位大的元素 然后尝试将大元素跟父节点交换
            }
            if (tmp >= data[child]) {
                break;
            }
            data[parent] = data[child];
            parent = child;
            child = 2 * child + 1;
        }
        data[parent] = tmp;
    }

    //调整小根堆
    public static void adjustMinHeap(int data[], int parent, int length){
        int tmp = data[parent];
        int child = 2 * parent + 1;
        while(child < length) {
            if (child + 1 < length && data[child] > data[child+1]){
                child++;
            }
            if (data[child] >= tmp) break;
            data[parent] = data[child];
            parent = child;
            child = 2 * child + 1;
        }
        data[parent] = tmp;
    }

    //对一个数组做大根堆堆排序
    public static void heapSort(int data[]) {
        //将原先打乱的数组表示的大根堆，重现调整，重最后一个点的父节点开始
        // (length-1)/2 就是最有一个节点的父节点
        for(int i = data.length/2-1;i>=0;i--) {
//            adjustMaxHeap(data, i, data.length);
            adjustMinHeap(data,i,data.length);
        }

        //真正的排序过程
        //只需要排序 n-1 趟就可以了
        for(int i= data.length-1;i>0;i--){
            int tmp = data[i];
            data[i] = data[0];
            data[0] = tmp;

            //交换顺序后，重新调整对
            //重新调整堆，交换后就从0位置开始调整堆
//            adjustMaxHeap(data, 0, i);
            adjustMinHeap(data,0,i);
            print(data);
        }
    }


    //top k 问题：
    //(1) 最小k，构成大根堆
    //(2) 最大k  构成小根堆


    //最大k问题
    public static void topk_biggest(int d[], int size, int k) {
        for (int i=0;i<k;i++) {
            adjustMinHeap(d,i,k);
        }
        for(int i=k;i<size;i++){
            if (d[i] > d[0]) {
                int tmp = d[0];
                d[0] = d[i];
                d[i] = tmp;
                adjustMinHeap(d,0,k);
            }
        }
        System.out.println("最大k个元素:");
        for (int i=0;i<k;i++) {
            if (i+1>=k) System.out.print(d[i]);
            else System.out.print(d[i] + ",");
        }
    }

    //最小k问题
    public static void topk_smallest(int d[],int size, int k){
        for (int i=0;i<k;i++) {
            adjustMaxHeap(d,i,k);
        }
        //[10,4,5,20,         80,60,70]
        for(int i=k;i<size;i++){
            if (d[i] < d[0]) {
                int tmp = d[0];
                d[0] = d[i];
                d[i] = tmp;
                adjustMaxHeap(d,0,k);
            }
        }
        System.out.println("最小k个元素:");
        for (int i=0;i<k;i++) {
            if (i+1>=k) System.out.println(d[i]);
            else System.out.print(d[i] + ",");
        }
    }


    public static void main(String args[]) {
        int a[] = {1,100,-2,7,3,5,9,4,8,-1};
        topk_smallest(a,a.length,4);
        topk_biggest(a,a.length,4);
//        heapSort(a);
    }
}


//参考文献: https://www.cnblogs.com/zhonghuasong/p/6553931.html,https://blog.csdn.net/lhj884/article/details/47128259=
