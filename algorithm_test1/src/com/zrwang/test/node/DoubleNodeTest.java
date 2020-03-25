package com.zrwang.test.node;

import com.zrwang.algorithmtest.node.DoubleNode;

public class DoubleNodeTest {

    public static void main(String[] args) {

        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.after(node2);
        node2.after(node3);

        System.out.println(node1.getNext().getDate());
        System.out.println(node1.getPre().getDate());
        System.out.println(node2.getPre().getDate());
        System.out.println(node2.getNext().getDate());
        System.out.println(node3.getPre().getDate());
        System.out.println(node3.getNext().getDate());
    }
}
