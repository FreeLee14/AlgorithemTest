package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {

        int[] a = new int[]{10,5,7,5,55,43,28,45};

        System.out.println(Arrays.toString(a));
        BubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void BubbleSort(int []a){

        //外层循环代表一共要进行一次冒泡
        for (int i = 0; i < a.length-1; i++){
            //内部循环为具体的交换动作
            for(int j = 0; j < a.length-1-i; j++){
                if(a[j]>a[j+1]){
                    int temp ;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
