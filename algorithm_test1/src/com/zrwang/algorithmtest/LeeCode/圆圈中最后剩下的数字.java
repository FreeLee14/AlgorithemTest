package com.zrwang.algorithmtest.LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 */
public class 圆圈中最后剩下的数字 {

    public static void main(String[] args) {

        int n = 5, m = 2;

        int lastNUmber = lastRemaining(n,m);

        System.out.println(lastNUmber);

        test();
    }

    public static int lastRemaining(int n, int m) {

        // 将这组数存放在数组集合当中
        List<Integer> arr = new ArrayList<>(n);
        // 初始化要被删除元素的下标
        int index = 0;

        for (int i = 0; i < n; i++)
            arr.add(i);

        while (n > 1){

            index = (index + m -1) % n;
            arr.remove(index);
            n--;

        }

        return arr.get(0);
    }

    public static void test(){

        List<Integer> test = new ArrayList<>();

        for (int i = 0; i < 6; i++)
            test.add(i);
        test.remove(2);
        /*for (int item: test)
            System.out.println(item);*/
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));

    }

}

