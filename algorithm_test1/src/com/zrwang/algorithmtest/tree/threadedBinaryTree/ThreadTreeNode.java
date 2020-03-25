package com.zrwang.algorithmtest.tree.threadedBinaryTree;

/**
 * 创建线索化二叉树节点对象
 */
public class ThreadTreeNode {
    //定义权
    int value;
    //定义左节点
    ThreadTreeNode leftNode;
    //定义右节点
    ThreadTreeNode rightNode;
    //定义一个节点左右链域指向节点的类型，0为指向左右孩子，1为指向前驱或后继节点(默认设置为0)
    int rightType = 0;
    int leftType = 0;
    //初始化节点，给节点赋权
    public ThreadTreeNode(int value){
        this.value = value;
    }
    //设置左节点
    public void setLeftNode(ThreadTreeNode leftNode) {
        this.leftNode = leftNode;
    }
    //设置右节点
    public void setRightNode(ThreadTreeNode rightNode) {
        this.rightNode = rightNode;
    }
    //先序遍历（根-左-右）
    public void frontShow() {
        //先打印中间节点
        System.out.println(value);
        //判断是否有左节点（基准条件）
        if(leftNode!=null){
            leftNode.frontShow();
        }
        //判断是否有右节点
        if(rightNode!=null){
            rightNode.frontShow();
        }
    }

    //中序遍历（左-中-右）
    public void middleShow() {
        //先打印左节点然后打印中间节点最后是右节点，依次递归下去逐层返回打印
        if (leftNode!=null){
            leftNode.middleShow();
        }
        System.out.println(value);
        if (rightNode!=null){
            rightNode.middleShow();
        }
    }

    //后续遍历（左-右-中）
    public void afterShow() {
        //先打印左节点，后打印右节点，最后打印根节点
        if(leftNode!=null){
            leftNode.afterShow();
        }
        if (rightNode!=null){
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    //先序查找
    public ThreadTreeNode frontSearch(int i) {
        //定义一个目标对象
        ThreadTreeNode target = null;
        //首先判断根节点是否为要查找的节点
        if(this.value == i){
            return this;
        }else{
            //判断是否存在左节点
            if(leftNode!=null){
                //通过左节点开始查找，并返回一个目标对象
                target = leftNode.frontSearch(i);
            }
            //如果左节点找到了目标则进行返回
            if(target != null){
                return target;
            }
            if(rightNode!=null){
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }
    //删除子树
    public void deleteTree(int i) {
        //先定义出双亲节点
        ThreadTreeNode parent = this;
        //判断左儿子
        if(parent.leftNode!=null && parent.leftNode.value == i){
            parent.leftNode = null;
            return;
        }
        //判断右儿子
        if(parent.rightNode!=null && parent.rightNode.value == i){
            parent.rightNode = null;
            return;
        }
        //如果第一次没有看到要删除的节点，进行递归检查并删除左子树中的节点
        parent = leftNode;
        if(parent != null){
            parent.deleteTree(i);
        }
        //如果根节点的左儿子子树都没有要删除的节点，递归检查并删除右子树中的节点
        parent = rightNode;
        if(parent != null){
            parent.deleteTree(i);
        }
    }
}
