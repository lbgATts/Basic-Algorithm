package com;

import java.util.Stack;

public class MinimalStackAndQueue {

    public static Stack<Integer> stack1 = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();
    public static Stack<Integer> stack_support = new Stack<Integer>();

    StringBuffer sb;
    public void push(int value) {
        stack1.push(value);
        if (stack_support.size() == 0 || stack_support.peek() > value)
            stack_support.push(value);
        else
            stack_support.push(stack_support.peek());
    }

    public int pop() {
        //如果stack2为空，则从stack1拿元素中入栈到stack中
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                int element = stack1.pop();
                stack2.push(element);
            }
        }
        // 如果已经没有元素可以出栈了
        if (stack2.size() == 0 && stack_support.size() == 0);
//            throw new Exception("queue is empty.");

        int res = stack2.pop();

        stack_support.pop();
        return res;
    }

    public int min() {
        if (stack2.size() > 0 && stack_support.size() > 0) {
            return stack_support.pop();
        }
        return 0;
    }

}
