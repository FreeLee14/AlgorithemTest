package com.zrwang.test.queue;

import com.zrwang.algorithmtest.queue.MyQueue;

public class MyQueueTest {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.add(3);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(1);

        System.out.println(myQueue.push());
        System.out.println(myQueue.push());
        System.out.println(myQueue.push());
        System.out.println(myQueue.push());
        System.out.println(myQueue.isEmpty());
    }
}
