package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

public class InsertSortTest {

    public static void main(String[] args) {

        int[] arr = new int[]{7,4,3,8,1,2};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 实现直接插入排序
     * @param arr
     * @return
     */
    public static void InsertSort(int[] arr){

        //开始对数组进行遍历,从第二个数字开始对前面的数字进行比较
        for (int i = 1; i < arr.length; i++){
            //将待插入数字存入到一个临时内存中
            int temp = arr[i];
            //进行待插入数字与待插入数字之前的所有数字进行比较的过程,循环的条件需要添加待插入数字要小于待插入数字之前的数字，否则停止对比
            int j ;
            for( j = i-1; j >= 0 && temp < arr[j]; j--){
                //将大于（待插入数字）的数字向前移动一位
                arr[j+1] = arr[j];
            }
            //当对比某个数字时大于等于它,此时将待插入数字放入到该数字之前的位置
            arr[j+1] = temp;
        }
    }
}
