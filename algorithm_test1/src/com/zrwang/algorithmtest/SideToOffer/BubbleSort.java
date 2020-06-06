package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{7,6,8,10,14,15,20,1};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {

        int length = arr.length;

        for (int i = 0; i < length - 1; i++){
            for (int j = 0 ; j < length - 1 - i; j++){
                if (arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
