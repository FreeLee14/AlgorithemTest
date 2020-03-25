package com.zrwang.algorithmtest.KuaiShouMianShi;

import java.util.Arrays;
//[175, 179, 174, 163, 176, 177]

public class 与更高者的距离 {

    public static void main(String[] args) {

        int[] height = new int[]{175, 179, 174, 163, 176, 177};

        int[] result = DistanceToHigher(height);

        System.out.println(Arrays.toString(result));

    }

    private static int[] DistanceToHigher(int[] height) {

        // 创建出一个数组用于存放结果
        int [] result = new int[height.length];

        result[0] = 0;//在此直接将第一位同学的距离赋值为0
        //开始从头遍历每个同学的身高
        for (int i = 1; i < height.length; i++){

            boolean flag = true;

            int index = i;

            while (flag){
                i--;
                if ( i >= 0 && height[index] < height[i]){

                    result[index] = index - i;

                    flag = false;
                }
                //实在是找不到比当前同学要高的，也就是当前的遍历的索引已经到了头，那就直接距离为0
                if (i < 0){

                    result[index] = 0;

                    flag = false;

                }

            }
            i = index;

        }

        return result;
    }
}
