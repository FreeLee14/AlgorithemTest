package com.zrwang.algorithmtest.lanqiaobei;

import java.util.Arrays;
import java.util.Scanner;

public class 螺旋矩阵定位 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入矩阵的行列值");
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 使用两个临时变量存储我们一开始的行列值
        int tempN = n;
        int tempM = m;
        // 请输入最后要输出的位置
        int i = sc2.nextInt();
        int j = sc2.nextInt();
        int count = 0;
        int sum = n * m;
        int[][] a = new int[n][m];
        // 初始化我们的行类指针
        int col = 0;
        int row = 0;
        while (count < sum ){
            // 从左向右 （行指针不动，列指针向右移动，会影响列指针的起始位置）
            for (; col < m && count < sum; col++){
                a[row][col] = ++count;
            }
            // 由于col多加了一位所以要给它减1
            col -= 1;
            // 从上到下（由于上一行已经被占据，所以行指针的位置要+1，会影响行指针的起始位置）
            for (row += 1; row < n && count < sum;row++ ){
                a[row][col] = ++count;
            }
            // 由于row多加了一位所以要给它减1
            row -= 1;
            // 从右到左（由于我们前一列已经被占据，所以起始位置要 - 1，并且终止条件是总列数（之前的临时值）- 现在可填充的列数）
            for (col -= 1;col >= tempM - m && count < sum; col--){
                a[row][col] = ++count;
            }
            // 当填充完此行，总行数-1
            n -= 1;
            // 因为col多减了一位，所以+1恢复
            col += 1;
            // 从下到上（由于我们上一行已经占据了一行，所以起始位置要-1，并且终止条件是总行数（之前的临时值）- 现在可填充行数）
            for (row -= 1;row >= tempN - n && count < sum;row--){
                a[row][col] = ++count;
            }
            // 当这一列进行填充完毕后，我们的总列数-1
            m -= 1;
            // 恢复多减一位的列数
            row += 1;
            // 由于行数已经又被占据一列，所以下一次while循环开始前col+1
            col += 1;
        }

        for (int[] item: a){
            System.out.println(Arrays.toString(item));
        }
    }
}
