package com.zrwang.algorithmtest.LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * leecode周赛
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 *  每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 */
public class 统计作战单位数 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,5,3,4,1};

//        int counts =   numTeams(arr);
        test();

    }

    private static int numTeams(int[] arr) {


        for (int i = 0; i < arr.length; i++){

            for (int j = i; j < arr.length; j++){



            }

        }

        return 0;
    }

    private static void test(){

        HashMap<Integer,String> hashMap = new HashMap<>();

        hashMap.put(1,"12");
        hashMap.put(1,"34");

        for (Map.Entry<Integer,String> item: hashMap.entrySet()){

            System.out.println(item.getValue());

        }

    }
}
