package com.zrwang.algorithmtest.SideToOffer;

public class 二叉树的镜像 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(7);
        TreeNode ll1 = new TreeNode(1);
        TreeNode lr1 = new TreeNode(3);
        TreeNode rl1 = new TreeNode(6);
        TreeNode rr1 = new TreeNode(9);
        root.left = l1;
        root.right = r1;
        l1.left = ll1;
        l1.right = lr1;
        r1.left = rl1;
        r1.right = rr1;

        TreeNode treeNode = mirrorTree(root);
        System.out.println(treeNode.val);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if(root.left != null) mirrorTree(root.left);
        if(root.right != null) mirrorTree(root.right);

        TreeNode item ;
        item = root.left;
        root.left = root.right;
        root.right = item;
        return root;
    }
}
