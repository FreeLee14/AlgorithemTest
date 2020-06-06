package com.zrwang.algorithmtest.LeeCode;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,2,2,3,7};
        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的数字");

        int i = sc.nextInt();*/

        int index = binarySearch(arr ,7);

        System.out.println(index);
    }

    // 此处我直接书写方法
    public static int binarySearch(int[] arr, int target){
        // 获取数组长度
        int len = arr.length;
        // 初始化低位和高位指针
        int low = 0;
        int high = len  - 1;
        // 初始化结果
        int res = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(target == arr[mid]){
                res = mid;
                break;
            }
            if(target > arr[mid]) low = mid + 1;
            if(target < arr[mid]) high = mid - 1;
        }
        // 循环结束两种情况，找到了目标值的索引，没有找到目标值索引
        if(res != -1){
            //不等于-1时说明找到了目标值索引,此时进行判断是否后续还有与之相等的数字，取下界
            for(int i = res; i + 1 < len; i++){
                if(target == arr[i+1]) res = i + 1;
                else break;
            }
        }else{
            int j;
            for(j = 0; j < len; j++){
                if(arr[j] < target) {
                    continue;
                }else break;
            }
            res = j - 1;
        }
        return res;

    }

    /*private static int binarySearch(int[] arr, int i, int j, int length) {

        int start = j;
        int end = length;
        int mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if (arr[mid] == i) break;
            if (i > arr[mid]) start = mid + 1;
            if (i < arr[mid]) end = mid - 1;
        }
        // 开始判断当前mid是否是重复数字的最后一个
        while (mid + 1 < length - 1){
            if (arr[mid] == arr[mid + 1]){
                mid += 1;
            }else{
                break;
            }
        }

        return mid;
    }*/

    /*private static int binarySearch(int[] arr, int i ,int start, int end) {

        int index = (start + end) / 2;

        int middle = arr[index];

        if (start > end){
            return -1;
        }

        if (i == middle)
            return index;

        else if (i < middle){

            return binarySearch(arr,i,start,middle -1);

        } else {

            return binarySearch(arr,i,middle + 1,end);

        }

    }*/


}
