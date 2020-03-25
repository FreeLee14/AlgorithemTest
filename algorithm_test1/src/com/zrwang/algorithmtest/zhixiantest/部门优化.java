package com.zrwang.algorithmtest.zhixiantest;

import java.util.Arrays;

/**
 * 每月进行依次部门优化，十年一共进行120次，由于每次调优的操作是重复的，所以根据时间进行分而治之的策略，初步考虑使用递归进行实现，保持时间复杂度为O（n）
 */
public class 部门优化 {

    public static void main(String[] args) {

        int [] group = new int[]{10, 7, 5, 4};

        int mouth = 120;
        // 将调整的数组与时间作为参数
        int [] result = optimizeDepartment(group , mouth);

        System.out.println(Arrays.toString(result));
    }

    private static int[] optimizeDepartment(int[] group, int mouth) {

        int[] result = new int[4];

        //递归的基线条件
        if (mouth > 0){

            int max = group[0];

            int maxIndex = 0;
            // 开始寻找人数最多的那一组
            for (int i = 1; i < group.length; i++){

                if (group[i] > max){

                    maxIndex = i;

                }

            }
            // 已经找出人数最多的项目的索引以及人数，进行部门优化调整
            for (int i = 0; i < group.length; i++){

                //如果是人数最多的项目组，则减少三个人
                if (i == maxIndex) {

                    group[maxIndex] -= 3;

                }else {
                    //剩余的进行每组添加一人
                    group[i] += 1;

                }
                //并将结果存储在新的数组中
                result[i] = group[i];

            }

            mouth--;
            //进行递归调用
            optimizeDepartment(result , mouth);

        }

        return result;

    }
}
