package com.zrwang.algorithmtest.SideToOffer;

import org.jetbrains.annotations.Contract;

public class 树的子结构 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode Al1 = new TreeNode(2);
        TreeNode Ar1 = new TreeNode(3);
        TreeNode Al2 = new TreeNode(4);
        TreeNode Ar2 = new TreeNode(5);

        TreeNode B = new TreeNode(3);
//        TreeNode Bl1 = new TreeNode(1);

        A.left = Al1; A.right = Ar1; Al1.left = Al2; Al1.right = Ar2;
//        B.left = Bl1;
        boolean subStructure = isSubStructure(A, B);
        System.out.println(subStructure);
    }

    private static boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) return false;
        return scanVal(a,b);
    }

    /**
     * 递归匹配b的头节点，匹配到之后再去校验b是否是a的子树结构
     * @param a
     * @param b
     * @return
     */
    private static boolean scanVal(TreeNode a, TreeNode b) {
        if (a == null) return false;
        if(a.val == b.val) if (dfs(a,b)) return true;
        return scanVal(a.left, b) || scanVal(a.right,b);
    }

    /**
     * 进行深度优先搜索，匹配子树结构
     * @param a
     * @param b
     * @return
     */
    private static boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return dfs(a.left,b.left) && dfs(a.right,b.right);
    }


}
