package com.zrwang.algorithmtest.LeeCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leecode周赛
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
public class 找出数组中的幸运数 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,2,2,3,3};
        int luckNumber = findLucky(arr);

        System.out.println(luckNumber);
    }


    private static int findLucky(int[] arr) {

        int luckNumber = 0;

        int[] counts = new int[500];
        List<Integer> list = new ArrayList<>();

        for (int item : arr){

            counts[item]++;

        }
        // 遍历数组，查看索引和数值是否相等
        for (int i = 0; i < counts.length; i++){

            if (counts[i] == 0){
                continue;
            }
            if (i == counts[i]){

                list.add(i);

            }

        }

        if (list.size() != 0){

            Collections.sort(list);

            luckNumber = list.get(list.size()-1);

        }else {

            luckNumber = -1;

        }

        return luckNumber;
    }
}
