package com.zrwang.algorithmtest.bosstest;

import java.util.Scanner;

public class 求一个长整数二进制表现形式中1的个数 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int counts = getByteOneCounts(a);
            System.out.println(counts);
        }
    }

    private static int getByteOneCounts(int a) {

        if (a == 0) return 0;

        int count = 0;

        while (a > 0){

            count++;
            // 每次与本身-1进行与位运算会消除最右边的一个1。消除了多少次就代表有多少个1
            a &= (a - 1);

        }

        return count;
    }

   /* private static int getByteOneCounts(int a) {

        int[] arr = new int[255];
        int index = 0;
        int counts = 0;
        // 按照除2取余的方法求出我们所需要的二进制编码
        while (a / 2 != 0){

            arr[index] = a % 2;

            a = a / 2;

            index++;

        }
        // 一旦等于0 后跳出最后一位必定是1，所以后续加上这个1
        counts += 1;
        for (int item: arr){
            if (item == 1)
                counts++;
        }

        return counts;
    }*/
}
