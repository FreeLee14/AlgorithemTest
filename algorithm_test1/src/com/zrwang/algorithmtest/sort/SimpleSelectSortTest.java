package com.zrwang.algorithmtest.sort;


import java.util.Arrays;

public class SimpleSelectSortTest {

    public static void main(String[] args) {

        int[] arr = new int[]{42,52,10,12,4,8,3,7,1};
        SimpleSelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  实现简单选择排序
     */
    public static void SimpleSelectSort(int[] arr){
        //首先遍历数组
        for(int i = 0; i < arr.length; i++ ){
            //从0开始假设为最小数字的索引
            int minIndex = i;
            for(int j = minIndex+1; j < arr.length; j++){
                //开始从认为最小的数字之后开始与之对比，找到后面中更小的数字
                if(arr[minIndex] > arr[j]){
                    //当存在比定义的最小数字还要小的数字，将它的索引赋值给minIndex
                    minIndex = j;
                }
            }
            //经过一次遍历对比获取到最小数字索引，首先需要判断这个索引是否与之前 定义的最小数字的索引i相同，如果相同那么获取到的最小数字其实还是自己本身，如果不同则进行交换位置
            if(i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
    }
}
