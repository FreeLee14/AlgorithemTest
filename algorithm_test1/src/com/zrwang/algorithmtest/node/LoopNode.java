package com.zrwang.algorithmtest.node;

/**
 * @author zrwang
 * 循环链表的实现
 */
public class LoopNode {

    //定义下一个节点为当前节点
    LoopNode next = this;
    //定义节点内容
    int data;
    //定义构造方法
    public LoopNode(int data){
        this.data = data;
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode node){
        //取出当前节点的下一个节点信息，作为插入节点的下一个节点信息
        LoopNode nodeNext = next;
        //将插入节点作为当前节点的下一个节点
        this.next = node;
        //插入节点的下一个节点为当前节点之前的下一个节点信息
        node.next = nodeNext;
    }

    public int getData(){
        return this.data;
    }
    //获取下一个节点
    public LoopNode next(){
        return this.next;
    }
}
