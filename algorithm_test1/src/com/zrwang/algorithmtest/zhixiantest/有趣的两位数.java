package com.zrwang.algorithmtest.zhixiantest;


/**
 * 有数学家发现⼀一些两位数很有意思，比如，
 * 34 * 86 = 43 * 68
 * 也就是说，如果把他们的十位数和个位数交换，二者乘积不变。
 * 编程求出满足该性质的两位数组合。
 * 提示，暴力解法非最优解
 */
public class 有趣的两位数 {

    public static void main(String[] args) {


        for (int i =10; i < 100; i ++){

            //i的个位和十位
            int ige = i % 10;
            int ishi = i / 10;
            for (int j = 10; j < 100; j++){

                int jge = j % 10;
                int jshi = j / 10;

                if (ige * 2 == jshi && ishi * 2 == jge){

                    System.out.println(i +" "+j);

                }

            }

        }


    }
}
