package com.zrwang.algorithmtest.SideToOffer;

/**
 * 小青蛙跳台阶的问题
 * 类型 ：DP类型
 * 使用一维数组缓存我们之前求解的结果
 */
public class 跳台阶 {
    public static void main(String[] args) {

        int i = JumpFloor(10);
        System.out.println(i);
    }
    public static int JumpFloor(int target) {

        int[] dp = new int[target + 1];
        if (target == 0 ) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
