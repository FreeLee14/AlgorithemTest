package com.zrwang.algorithmtest.LeeCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 887 难度：困难  原Google面试题
 */
public class 鸡蛋掉落 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入鸡蛋个数");
        int K = sc.nextInt();
        System.out.println("请输入楼层高度");
        int N = sc.nextInt();

        int result = dp(K , N);

    }

    static Map<Integer,Integer> memo = new HashMap<>();
    private static int dp(int k, int n) {

        if (k == 1) return n;
        if (n == 0) return 0;



        return 0;
    }
}
