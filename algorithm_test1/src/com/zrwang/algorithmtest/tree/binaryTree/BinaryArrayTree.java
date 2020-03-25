package com.zrwang.algorithmtest.tree.binaryTree;

/**
 * 顺序存储二叉树的遍历
 */
public class BinaryArrayTree {
    //定义一个数组代表顺序存储二叉树
    int [] elements;

    public BinaryArrayTree(int [] elements){
        this.elements = elements;
    }

    //定义前序遍历的方法(需要传入一个开始的索引)
    public void frontShow(int start){
        //判断当前数据是否为空，如果为空则直接返回
        if(elements == null||elements.length == 0){
            return;
        }
        //从根元素开始打印
        System.out.println(elements[start]);
        //开始遍历左孩子
        if(2*start+1 < elements.length){
            frontShow(2*start+1);
        }
        //开始遍历右孩子
        if(2*start+2 < elements.length){
            frontShow(2*start+2);
        }
    }
}
