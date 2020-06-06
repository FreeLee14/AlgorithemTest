package com.zrwang.algorithmtest.SideToOffer;

import java.util.HashMap;

/**
 * 给出前序和中序遍历，构建出原本的二叉树
 */
public class 重建二叉树 {
    static HashMap<Integer, Integer> dic = new HashMap<>();
    static int[] po;
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    static TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        // 给当前的根节点赋值
        TreeNode root = new TreeNode(po[pre_root]);
        // 通过前序遍历数组中的根结点，定位中序遍历对应根结点的位置（不止是root还有各个左右子树的根结点）
        int i = dic.get(po[pre_root]);
        // in_left和i-1 是在中序遍历中
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}

class TreeNode{

    TreeNode node;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x){
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "node=" + node +
                ", val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
