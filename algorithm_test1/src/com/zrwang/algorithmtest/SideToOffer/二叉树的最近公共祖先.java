package com.zrwang.algorithmtest.SideToOffer;


public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode left_1 = new BinaryTreeNode(5);
        BinaryTreeNode right_1 = new BinaryTreeNode(1);
        BinaryTreeNode left_2 = new BinaryTreeNode(6);
        BinaryTreeNode right_2 = new BinaryTreeNode(2);
        BinaryTreeNode left_3 = new BinaryTreeNode(0);
        BinaryTreeNode right_3 = new BinaryTreeNode(8);
        BinaryTreeNode left_4 = new BinaryTreeNode(7);
        BinaryTreeNode right_4 = new BinaryTreeNode(4);

        root.left = left_1;
        root.right = right_1;
        left_1.left = left_2;
        left_1.right = right_2;
        right_2.left = left_4;
        right_2.right = right_4;
        right_1.left = left_3;
        right_1.right = right_3;
        BinaryTreeNode binaryTreeNode = lowestCommonAncestor(root, left_2, right_4);
        System.out.println(binaryTreeNode.val);
    }

    public  static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root,BinaryTreeNode p ,BinaryTreeNode q){

        if (root == null || p == root || q == root) return root;
        BinaryTreeNode left = lowestCommonAncestor(root.left,p,q);
        BinaryTreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
class BinaryTreeNode{

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int x) { val = x; }
}

