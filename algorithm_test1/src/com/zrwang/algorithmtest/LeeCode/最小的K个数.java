package com.zrwang.algorithmtest.LeeCode;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class 最小的K个数 {

    public static void main(String[] args) {

        int [] arr = new int[]{4,5,1,6,2,7,3,8};

        int k = 2;

        int [] result = findLeast(arr,k);

        System.out.println(Arrays.toString(result));

    }

    private static int[] findLeast(int[] arr, int k) {

        int [] result = new int[k];

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < result.length; i++){

            result[i] = arr[i];

        }

        return result;
    }
}
