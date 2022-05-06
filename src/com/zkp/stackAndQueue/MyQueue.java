package com.zkp.stackAndQueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
class Test{
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);//1
        System.out.println(myQueue.peek());//1
        myQueue.push(2);//1 2
        System.out.println(myQueue.peek());//1
        System.out.println(myQueue.pop());//1
        System.out.println(myQueue.empty());//f
        myQueue.push(3);//2 3
        System.out.println(myQueue.peek());//2
        System.out.println(myQueue.peek());//2
        System.out.println(myQueue.pop());//2
        System.out.println(myQueue.empty());//f
        System.out.println(myQueue.peek());//3
        System.out.println(myQueue.pop());//3
        System.out.println(myQueue.empty());//t
    }
}
