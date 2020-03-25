package com.zrwang.algorithmtest.node;

/**
 * @author zrwang
 *  双向循环链表的实现
 */
public class DoubleNode {

    //开始进行初始化，一个双向链表的中只有一个节点时，该节点存储的上一个节点位置信息是自己本身，存储的下一个节点的信息也是自己本身
    DoubleNode pre = this;

    DoubleNode next = this;
    //定义节点内容
    int date;

    public DoubleNode(int date){
        this.date = date;
    }

    public DoubleNode getPre(){
        return this.pre;
    }

    public DoubleNode getNext(){
        return this.next;
    }

    public int getDate(){
        return this.date;
    }

    public void after(DoubleNode node){

        //先获取当前节点原本的下一个节点
        DoubleNode nodeNext = this.next;
        //当前节点的下一个节点为插入节点
        this.next = node;
        //插入节点的上一个节点信息为当前节点
        node.pre = this;
        //插入节点的下一个节点为当前节点原本的下一个节点
        node.next = nodeNext;
        //让当前节点原本下一个节点的上一个节点信息存储变为插入节点
        nodeNext.pre = node;

    }

}
