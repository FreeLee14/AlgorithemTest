package com.zrwang.test.node;

import com.zrwang.algorithmtest.node.LoopNode;

public class LoopNodeTest {

    public static void main(String[] args) {
        //测试循环链表
        LoopNode node1 = new LoopNode(1);
        LoopNode node2 = new LoopNode(2);
        LoopNode node3 = new LoopNode(3);

        node1.after(node2);
        node2.after(node3);

        System.out.println(node1.next().getData());
        System.out.println(node2.next().getData());
        System.out.println(node3.next().getData());
    }


}
