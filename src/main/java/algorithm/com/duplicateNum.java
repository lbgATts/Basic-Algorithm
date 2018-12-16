package com;

import java.util.HashMap;

public class duplicateNum {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length <=0 ) return false;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i=0;i<numbers.length;i++) {
            Integer count = map.get(numbers[i]);
            if (count != null) {
                map.put(numbers[i], count++);
                if (count > 1) {
                    duplication[0] = numbers[i];
                    return true;
                }
            } else {
                map.put(numbers[i], 1);
            }
        }
        return false;
    }

    public static void main(String args[]) {

    }
}
