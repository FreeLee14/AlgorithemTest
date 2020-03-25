package com.zrwang.algorithmtest.tree.binaryTree;

/**
 * 创建一个树对象
 */
public class BinaryTree {

    //给树绑定根节点
    TreeNode root;

    //设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    //获取根节点
    public TreeNode getRoot() {
        return root;
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

    public TreeNode frontSearch(int i){
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
