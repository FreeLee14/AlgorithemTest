package com.zrwang.algorithmtest.lanqiaobei;

import java.util.Scanner;

public class 杨辉三角形 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要打印的层数");
        int n = scanner.nextInt();

        yanghui(n);
    }

    private static void yanghui(int n) {

        // 维护一个二维矩阵,行列长度分别+1方便进行存储数据
        int[][] res = new int[n+1][n+1];
        //初始化第一个格子的值都为1
        res[0][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i ; j++){
                // 当前位置的值为上一格和左前格子的数字之和
                res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
            }
        // 输出打印有效格子显示杨辉三角形
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }



    }
}
