package com.zrwang.algorithmtest.zhixiantest;

import java.util.Scanner;

/**
 * 考虑使用动态规划进行求解
 */
public class 游戏币组合 {

    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 5, 10};

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入个数n");
        int n = scanner.nextInt();

        System.out.println("请输入总面值m");
        int m = scanner.nextInt();

        int counts = dp(n,m,coins);


    }

    private static int dp(int n, int m, int[] coins) {

        //创建数组用于存储个数
        int[] arr = new int[n];
        int [][] result = new int[coins.length+1][m+1];
        for (int i=0; i <= coins.length;i++){

            result[i][0] =1;

        }
        for (int i = 1; i <=coins.length; i++){

            for (int sum = 1; sum <= m; sum++){
                //单纯使用一种硬币时最大的上线个数
                for (int k = 0; k <= sum/coins[k-1]; k++){

                    result[i][sum] += result[i-1][sum-k*coins[i-1]];

                }

            }

        }
        System.out.println(result[coins.length][m]);

        return 0;
    }
}
