package com.zrwang.algorithmtest.KuaiShouMianShi;

import java.util.Scanner;

/**
 * 给定一个32位int型正整数，我们定义如下操作，取其十进制各位数字的平方和，并不断重复这个操作。如果某次操作完成后得到的结果是1，则返回true；否则继续执行，直到证明永远不会得到结果为1，返回false
 * input:19
 *
 * output:true
 *
 * 原因：
 *
 * 1^2 + 9^2=82
 *
 * 8^2 + 2^2 = 68
 *
 * 6^2 + 8^2 =  100
 *
 * 1^2 + 0^2 + 0^2 = 1
 */
public class 秋招22题 {

    public static void main(String[] args) {

        // 此题需要使用递归来实现

        int [] array = new int[]{};

        Scanner sc = new Scanner(System.in);

        for (int n : array){

            boolean b = recursive(n);

            System.out.println(b);
        }

    }

    // 获取结果的布尔值
    private static boolean b;
    //定义一个常量用来记录递归次数如果超过一百次则没有结果
    private static int i ;

    //将结果的每一位进行平方求和直到结果为1时结束
    private static boolean recursive(int n) {

        int result = 0;
        // 基线条件为结果不为1时继续进行递归
        if ( n != 1 && i < 100){

            String str = String.valueOf(n);

            String [] strArray = str.split("");

//            System.out.println(Arrays.toString(strArray));

            for (String items: strArray){

                int item = Integer.valueOf(items);

                result = item * item + result;
            }

            if (result == 1) {

                b = true;

            }else{

                b = false;

            }
            i++;

            recursive(result);

        }



        return b;
    }
}
