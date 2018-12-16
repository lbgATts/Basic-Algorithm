package com;

import java.util.ArrayList;
import java.util.List;

public class BackTrackTest {
    static List<List<Integer>> result=new ArrayList<List<Integer>>();
    public static void backtracking(int n,int k,int start,List<Integer> list){
        if(k<0) return;
        else if(k==0){

            /**
             * k ==0 类似 在分岔路，找了一条路径 并走到了头，标记这条路是 可达的，
             *
             * 然后再回来，回到 回溯点，继续往下探寻
             *
             */


            //k==0表示已经找到了k个数字的组合，这时候加入全局result中
            result.add(new ArrayList(list));

            /**
             *  在 k =0 时候，跳出递归，执行  System.out.println("222222"); ，也就是调到 #27 行执行，
             */

            System.out.println("11111");

        }else{
            for(int i=start;i<=n;i++){
                list.add(i);//尝试性的加入i
                //开始回溯啦，下一次要找的数字减少一个所以用k-1，i+1见后面分析
                backtracking(n,k-1,i+1,list);
                //（留白，有用=。=）
                list.remove(list.size()-1);
                System.out.println("222222");
            }
        }
        // 如果这边有一个 return list, 结果貌似是一样的，
    }

    public static void main(String args[]) {
        List<Integer> list=new ArrayList<Integer>();
        new BackTrackTest().backtracking(4,2,1, list);
    }
 }
