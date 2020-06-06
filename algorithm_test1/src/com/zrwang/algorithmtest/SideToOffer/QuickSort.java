package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4,1,5,2,10,17,8};

        QuickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] arr, int start, int end){

        // 开始位置索引小于结束位置索引才可进行快速排序
        if(start < end ){
            // 定义标准值(默认采用开始位置作为标准值)
            int stand = arr[start];
            // 定义低位和高位指针
            int low = start;
            int high = end;

            while (low < high){

                while (low < high && arr[high] >= stand) high --;
                arr[low] = arr[high];

                while (low < high && arr[low] <= stand) low++;
                arr[high] = arr[low];

            }
            // 此时跳出循环时low == high,将标准值放入到该位置
            arr[low] = stand;
            // 递归调用自身依次对以中间为基准的左右两边的数组进行快排
            QuickSort(arr,start,low);
            QuickSort(arr,low+1,end);
        }
    }
}
