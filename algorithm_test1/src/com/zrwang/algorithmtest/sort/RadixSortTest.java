package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

public class RadixSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{522,10,2,5,165,58,69,42,3,1};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*实现基数排序*/
    public static void RadixSort(int[] arr){
        //进行基数排序前首先需要获得该数组中最大的数字
        int max = Integer.MIN_VALUE;//-2147483648，初始化max为整型最小数字，防止数组中小于0数字的存在
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //获取最大数字的位数
        int max_length = (max + "").length();
        //定义一个临时二维数组，列坐标长度为10，行坐标最长为传入数组的长度，用于存储根据个、十、百位存储的数据
        int[][] temp = new int[10][arr.length];
        //定义一个存储每一个临时数组的列中存在多少行数据的数组
        int [] counts = new int[10];
        //开始进行基数排序
        for(int j = 0,n=1; j < max_length; j++,n*=10){
            for(int i = 0; i < arr.length; i++){
                //定义一个通式能够在三次循环中分别拿出：个、十、百位
                int ys = arr[i]/n%10;
                temp[ys][counts[ys]] = arr[i];
                //存储个数的数组对应的列的坐标开始++
                counts[ys]++;
            }
            //将临时数组中的数据存放回原来的数组,对存放每一列个数的数组进行遍历
            //初始化一个index记录存放至原来数组的索引
            int index = 0;
            for (int i = 0; i < counts.length; i++){
                //当个数不为0时才证明有数据
                if(counts[i] != 0){
                    //将这一列的数据拿出来存放在新的数组中
                    for(int l = 0; l < counts[i]; l++){
                        arr[index] = temp[i][l];
                        index++;
                    }
                    //每转移完一列数据，将对应列的个数置0
                    counts[i] = 0;
                }
            }
        }
    }
}
