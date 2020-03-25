package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,2,1,0,10};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * zrwang
     * @param arr 传入数组参数
     * @param start     开始的起始位置
     * @param end       结束位置
     *                  快速排序方法实现
     */
    public static void QuickSort(int []arr, int start, int end){

        //递归的结束条件判断(基线条件)
        if(start < end){
            //首先取出数组的标准数
            int standard = arr[start];
            //定义low和high的索引，最一开始low所指向的是标准数
            int low = start;
            int high = end;
            //开始进行快速排序,条件必须满足low的索引小于high的索引（递归条件）
            while(low < high){
                //从high开始与标准数进行对比
                while ( low < high && standard <= arr[high]){
                    high --;
                }
                //如果一旦标准数大于high指针所指向的数字，则将low指针所指向的数替换为high指针指向的数
                arr[low] = arr[high];
                //此时开始进行low指针的移动，与标准数开始对比，当比标准数小时low++
                while (low < high && arr[low] <= standard){
                    low ++;
                }
                //如果一旦标准数小于low指针所指向的数字，则将high指针指向的数字替换为low指针指向的数字
                arr[high] = arr[low];
            }
            //当low = high时将标准数放入该位置
            arr[low] = standard;
            //以上为一次快速排序过程，以第一次的标准数为界限，左边为小于标准数的数组，右边为大于标准数的数组，递归调用自己，重新进行排序
            //将左边数组递归快速排序
            QuickSort(arr,start,low);
            //将右边的数组递归快速排序
            QuickSort(arr,low+1,end);
        }
    }
}
