package com.zrwang.algorithmtest.tree.binaryTree;


/**
 * 实现二叉树的遍历（前序、中序、后序）
 */
public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        //创建根节点
        TreeNode root = new TreeNode(1);
        //给树添加根节点
        binaryTree.setRoot(root);
        //创建根节点的左节点
        TreeNode rootLeftNode = new TreeNode(2);
        //创建根节点的右节点
        TreeNode rootRightNode = new TreeNode(3);
        root.setLeftNode(rootLeftNode);
        root.setRightNode(rootRightNode);
        //再给第二层的左右节点分别添加孩子
        TreeNode leftNode2 = new TreeNode(4);
        TreeNode rightNode2 = new TreeNode(5);
        rootLeftNode.setLeftNode(leftNode2);
        rootLeftNode.setRightNode(rightNode2);

        TreeNode leftNode3 = new TreeNode(6);
        TreeNode rightNode3 = new TreeNode(7);
        rootRightNode.setLeftNode(leftNode3);
        rootRightNode.setRightNode(rightNode3);

        //开始进行遍历
        //先序遍历
//        binaryTree.frontShow();
        System.out.println("-------------");
        //中序遍历
//        binaryTree.middleShow();
        System.out.println("-------------");
        //后续遍历
//        binaryTree.afterShow();
        //查找节点的方法
        //前序查找
//        TreeNode treeNode = binaryTree.frontSearch(5);
//        System.out.println(treeNode==rightNode2);
        //删除子树，由于是普通二叉树，所以删除一个带有孩子的子节点，会将这个子节点及其孩子都删除掉
        binaryTree.deleteTree(5);
        binaryTree.frontShow();
    }
}
