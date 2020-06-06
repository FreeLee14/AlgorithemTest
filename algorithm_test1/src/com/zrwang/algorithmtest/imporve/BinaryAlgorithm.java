package com.zrwang.algorithmtest.imporve;


/**
 * 此类用于练习所有有关二进制位操作，以及相关的算法题
 */
public class BinaryAlgorithm {

    public static void main(String[] args) {

        /**
         * 使用二进制位操作交换两个变量的数值
         */
        int a = 7;
        int b = 8;
//        swap(a,b);

        /**
         * 消除二进制位中的最后一位，常用于计算整型数字二进制位中有多少个1
         */
//        deleteLast(a);
        /**
         * 进行整数二进制位中第i位和第j位的位置互换
         */
        int i = 0 , j = 1;
//        swapBinary(a, i, j);
        /**
         * 将一个整数的二进制位进行倒置，这个题需要循环利用到交换i j 两位的方法
         */
//        binaryReverse(a);
        /**
         * 对于32位和64位的整型数字，其中用二进制位表示时存在多少个1称为它的权重k，设存在S（k）包含着所有权重为k的32或64位的数字（k！=0&&k！= 64），这时我们给定一个数字x
         * x存在于S（k）中，那么需要找到一个y，y属于S（k）同时y！=x，那么要保证|y - x|最小。
         */
//        int min_abs = find_min_abs(a);
//        System.out.println(min_abs);

        /**
         * 求解最大公约数
         */
        int gcd = gcd(10,5);
        System.out.println(gcd);

    }

    private static int gcd(int a, int b) {

        return a == 0 ? b : gcd(b % a , a);
    }

    /**
     *  根据规律可知，从0 1 开始尝试交换，如果交换完之后还是本身，那么进行1 2 开始交换，这样交换之后的可保证x与y的差值最小，当然只针对x本身进行操作权重肯定时一致的
     */
    private static int find_min_abs(int a) {

        int i = 0;
        int result = 0;
        while (i < Integer.SIZE - 1){
            if (swapBinary(a,i,i+1) != a){
                result = swapBinary(a,i,i+1);
                break;
            }
            i++;
        }

        return result;
    }

    /**
     * 将一个整数的二进制位进行倒置，这个题需要循环利用到交换i j 两位的方法
     */
    private static void binaryReverse(int a) {

        System.out.println("倒置前：" + Integer.toBinaryString(a));
        int i = 0;
        int j = Integer.SIZE - 1;

        while (i < j){

            a = swapBinary(a, i, j);
            i ++;
            j --;
        }

        System.out.println("倒置后:"+ Integer.toBinaryString(a));
    }

    /**
     * 进行整数二进制位中第i位和第j位的位置互换
     */
    private static int swapBinary(int a, int i, int j) {
        System.out.println("交换i和j位前："+ Integer.toBinaryString(a));
        //先判断第i位和第j位经过移位后是否相等，如果相等则没有必要进行交换
        if (((a >> i) & 1) != ((a >> j) & 1) ){
            a ^= (1 << i) | (1 << j);
        }
        System.out.println("交换i和j位后："+ Integer.toBinaryString(a));
        return  a;
    }

    /**
     * 消除二进制位中的最后一位
     */
    private static void deleteLast(int a) {

        System.out.println("消除前：" + Integer.toBinaryString(a));
        a &= (a - 1);
        System.out.println("消除后：" + Integer.toBinaryString(a));
    }

    /**
     * 使用二进制位操作交换两个变量的数值
     */
    private static void swap(int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }
}
