package com.zrwang.algorithmtest.lanqiaobei;

import java.util.Scanner;

public class yanghui {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要输出的杨辉三角行的层数");
        int i = sc.nextInt();

        yanghui(i);
    }

    private static void yanghui(int n){
        //采用动态规划进行求解
        if (n == 0) System.out.println("");
        int[][] dp = new int[n+1][n+1];
        int length = dp.length;
        dp[0][0] = 1;
        for (int i = 1; i < length; i++){
            for (int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        for (int i = 1; i < length; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
