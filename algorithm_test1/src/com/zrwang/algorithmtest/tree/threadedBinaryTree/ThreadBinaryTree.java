package com.zrwang.algorithmtest.tree.threadedBinaryTree;

import java.util.function.Predicate;

/**
 * 创建一个树对象
 */
public class ThreadBinaryTree {

    //给树绑定根节点
    ThreadTreeNode root;

    //定义一个临时节点存放上一个节点
    ThreadTreeNode pre = null;
    //设置根节点
    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }
    //获取根节点
    public ThreadTreeNode getRoot() {
        return root;
    }
    //中序线索化二叉树--begin
    public  void mThreadTree(){
        middleThreadBinaryTree(root);
    }

    private  void middleThreadBinaryTree(ThreadTreeNode node) {

        if(node == null){
            return;
        }
        //线索化左子树
        middleThreadBinaryTree(node.leftNode);

        //处理前驱节点
        if ( node.leftNode == null){
            //如果当前节点的左节点为空，那么让左节点存储前驱节点（上一个节点）
            node.leftNode = pre;
            //改变当前节点左指针类型,即使当前节点的前驱节点为null也要赋值为1，因为它没有左孩子
            node.leftType = 1;
        }
        //处理后继节点(链表是顺序遍历，我们需要知道下一个节点，才能将当前这个节点链接至上一个节点的后继节点)
        if(pre !=null && pre.rightNode == null){
            //让前驱节点的右节点指向当前节点
            pre.rightNode = node;
            //改变上一个节点右节点指针类型
            pre.rightType = 1;
        }
        //每次结束依次线索化保存当前节点作为下次节点的上一个节点
        pre = node;

        //线索化右子树
        middleThreadBinaryTree(node.rightNode);


    }
    //--end

    //线索化二叉树的遍历（针对中序线索化二叉树进行遍历）
    public void threadIteartor(){
        //用于存储当前节点
        ThreadTreeNode node = root;
        //开始进行节点的遍历
        while (node!=null){
            //开始寻找到最开始的节点，因为是中序遍历所以要先找到最左边的节点
            while (node.leftType == 0){
                node = node.leftNode;
            }
            System.out.println(node.value);
            //如果当前节点的右指针指向后继节点，可能这个后继节点还存在后继节点,所以需要循环遍历当前节点右节点类型是否为1.因为我们是在遍历整个线索化二叉树所以只考虑后继节点
            while(node.rightType == 1 && node.rightNode!=null){
                node = node.rightNode;
                System.out.println(node.value);
            }

            node = node.rightNode;
        }
    }

    //先序遍历
    public void frontShow() {
        if(root != null){
            root.frontShow();
        }
    }

    public void middleShow() {
        if(root != null){
            root.middleShow();
        }
    }

    public void afterShow() {
        if(root != null){
            root.afterShow();
        }
    }

    public ThreadTreeNode frontSearch(int i){
        return root.frontSearch(i);
    }

    public void deleteTree(int i) {
        //在这里先判断是否要删除根节点，如果是则把整个树的指针置空
        if(root.value == i){
            root = null;
        }else{
            root.deleteTree(i);
        }
    }
}
