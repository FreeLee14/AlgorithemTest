package com.zrwang.algorithmtest.LeeCode;

import java.util.Queue;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 大概题解思路：本题所提供的水壶是没有刻度的，所以两个水壶只有全部装满的状态，和没有水的状态，以及x 向y倒水，x为空或x还有剩余，y没有满或者y被倒满这几种状态 ，不存在给两个水壶进行初始化容量时出现不满的情况
 * 在这里我们可以分析为 ax + by = z 这里通过贝祖定理可知，仅当z是a 和 b的最大公约数的倍数有解，因为这道题可以转换为数学题思路进行解决，针对x 和 y两个变量求最大公约数，最后与z进行判断是否存在倍数关系
 *
 */
public class 水壶问题 {

    public static void main(String[] args) {

        int x = 2;
        int y = 6;
        int z = 5;

        boolean b = canMeasureWater(x, y, z);

        System.out.println(b);
    }

    private static boolean canMeasureWater(int x, int y, int z) {

        int max = x + y;
        // 如果录入的恰好得到的水量大于两个水壶的总和，就直接返回false
        if (z > max){

            return false;

        }
        if (x == 0 && y == 0 && z == 0){

            return true;

        }
        if (x < 0 || y < 0 || z < 0){

            return false;

        }
        //定义一个求解最大公约数的方法
        int i = gcd(x, y);
        if (z % i == 0){

            return true;

        }else {

            return false;
        }
    }

    // 最大公约数方法
    private static int gcd(int x, int y) {

//        int result = 0;
//
//        if( x == y  ){
//
//            result = x;
//
//        }else if (x == 0 && y != 0){
//
//            result = y;
//
//        }else if (x != 0 && y == 0){
//
//            result = x;
//
//        }else {
//            //x与y不相等时
//            if (x > y){
//                // 当x是较大数，y是较小数时
//                while ((x % y) != 0){
//
//                    int temp = y;
//                    y = x % y;
//                    x = temp;
//
//                }
//                result = y;
//
//            }else {
//
//                while ((y % x) != 0){
//
//                    int temp = x;
//                    x = y % x;
//                    y = temp;
//
//                }
//
//                result = x;
//            }
//        }
//        return result;
        // 使用递归的方法进行求解 求最大公约数的思路：被除数为y ，除数为x%y的值，递归进行计算直到y==0时得出最大公约数的值
        if( x == y  ){

            return x;

        }else if (x == 0 && y != 0){

            return  y;

        }else if (x != 0 && y == 0){

            return  x;

        }else {
            if (x > y){

                return y == 0 ? x : gcd(y, x%y);

            }else {

                return x == 0 ? y : gcd(x, y%x);

            }
        }

    }

}
