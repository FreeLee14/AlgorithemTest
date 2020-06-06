package com.zrwang.algorithmtest.LeeCode.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 练习二分查找（使用普通方法和递归分别实现）
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{3,1,56,76,45,65,90,2,24};

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要查找的数字");
        int key = sc.nextInt();

        int index = binarySearch(arr,key);

        System.out.println(index);

    }

    /**
     * 使用递归进行实现
     * @param arr
     * @param key
     * @return
     */
    private static int binarySearch(int[] arr, int key) {

        Arrays.sort(arr);
        int hight = arr.length - 1;
        int low = 0;

        int index = search(arr ,key,low,hight);

        return index;
    }

    private static int search(int[] arr, int key, int low, int hight) {

        if (low > hight) return -1;

        int mid = (low + hight) / 2;

        if (key > arr[mid]) return search(arr,key,mid + 1, hight);
        if (key < arr[mid]) return search(arr,key,low,mid - 1);

        return mid;
    }

   /*   使用一般的思路进行实现
   private static int binarySearch(int[] arr, int key) {

        Arrays.sort(arr);

        int hight = arr.length - 1;
        int low = 0;

        while (low <= hight){

            int mid = (hight + low) / 2;

            if (arr[mid] == key) return mid;

            if (key > arr[mid]) low = mid + 1;
            if (key < arr[mid]) hight = mid - 1;

        }

        return -1;
    }*/

}
