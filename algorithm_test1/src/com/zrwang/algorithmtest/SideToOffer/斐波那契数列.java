package com.zrwang.algorithmtest.SideToOffer;

/**
 * 斐波那契数列是学习递归的一个经典案例，但是可以使用DP来进行更加快速的优化
 * 本次将两种方法都列举出来以供后续复习
 */
public class 斐波那契数列 {
    public static void main(String[] args) {

//        int i = recursive(45);
//        System.out.println(i);

        int j = dp(45);
        System.out.println(j);
    }

    /**
     * DP实现
     * @param i
     * @return
     */
    private static int dp(int i) {

        int[] dp = new int[i + 1];
        if (i == 0) return 0;
        if (i == 1 || i == 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int j = 3; j <= i; j++){
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[dp.length - 1]%1000000007;
    }

    /**
     * 递归实现
     * @param i
     * @return
     */
    private static int recursive(int i) {
        if (i == 0) return 0;
        if (i == 1 || i == 2) return 1;
        return recursive(i - 1) + recursive(i - 2);
    }


}
