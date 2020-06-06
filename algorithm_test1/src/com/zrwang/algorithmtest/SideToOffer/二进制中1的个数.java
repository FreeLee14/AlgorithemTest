package com.zrwang.algorithmtest.SideToOffer;

/**
 * 这道题考察的是位运算
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {
        int i = hammingWeight(-8);
        System.out.println(i);
    }
    public static int hammingWeight(int n) {

        if (n == 0) return 0;
        int count = 0;
        // 这里的循环判断要写成！=0 因为负数也要进行计算呀
        while (n != 0){
            count++;
            n &= (n - 1);
        }

        return count;
    }
}
