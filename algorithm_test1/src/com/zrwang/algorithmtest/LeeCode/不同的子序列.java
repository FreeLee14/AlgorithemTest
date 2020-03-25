package com.zrwang.algorithmtest.LeeCode;

import java.awt.*;
import java.util.Arrays;

/**
 * leecode： 115题  难度： 困难
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * "rabbbit"
 * "rabbit"
 * "babgbag"
 * "bag"
 */
public class 不同的子序列 {

    /**
     * 这个问题是最长公共子字符串的问题，需要用到动态规划进行解决。可理解为前面较大的字符串最多能容纳多少个后面的这个子字符串，与动态规划经典的背包问题和旅游问题一致
     */
    public static void main(String[] args) {

        String s = "babgbag";
        String t = "bag";

        int result = numDistinct(s,t);

        System.out.println(result);

    }

   //使用动态规划进行求解
     private static int numDistinct(String s, String t) {

        String [] arrs = s.split("");
        String [] arrt = t.split("");

        int [][] common = new int[arrt.length+1][arrs.length+1];

        for (int i = 0; i < arrs.length; i++){

            //初始化第一行和第一列 改行都赋值为1 ，第一列不用赋值默认为0
            common[0][i] = 1;

        }

        for (int i = 1; i <= arrt.length; i ++) {

            for (int j = 1; j <= arrs.length; j++) {

                if (arrt[i-1].equals(arrs[j-1])){

                    common[i][j] = common[i-1][j-1] + common[i][j-1];

                }else {

                    common[i][j] = common[i][j-1];

                }

            }

        }

        for (int [] item: common){

            System.out.println(Arrays.toString(item));

        }

        return common[arrt.length][arrs.length];

    }

//    private static int numDistinct(String s, String t) {
//
//        // 将两个字符串转换为数组
//        String [] arrs = s.split("");
//        String [] arrt = t.split("");
//
//        // 创建一个二维数据用于构建动态规划所需要的矩阵
//        int[][] common = new int[arrs.length][arrt.length];
//
//        for (int i = 0; i < arrs.length; i++){
//
//            for (int j = 0; j < arrt.length; j++){
//
//                if (arrs[i].equals(arrt[j]) ){
//
//                    if (i - 1 >= 0 && j - 1 >= 0){
//
//                        common[i][j] = common[i-1][j-1] + 1;
//
//                    }else if (i - 1 >=0 && j - 1 < 0) {
//
//                        common[i][j] = common[i-1][j] + 1;
//
//                    }else if (i - 1 < 0 && j - 1 >= 0) {
//
//                        common[i][j] = common[i][j-1] + 1;
//
//                    }else if (i - 1 < 0 && j -1 < 0){
//
//                        common[i][j] = common[i][j] + 1;
//
//                    }
//
//                }
//
//            }
//
//        }
//
//        int max = 0;
//
//        for (int i = 0; i < arrs.length; i++){
//
//            for (int j = 0; j < arrt.length; j++){
//
//                if (common[i][j] > max){
//                    max = common[i][j];
//                }
//
//            }
//
//        }
//
//        for (int [] item: common){
//
//            System.out.println(Arrays.toString(item));
//
//        }
//
//        return max;
//    }

}
