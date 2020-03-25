package com.zrwang.algorithmtest.sort;


import java.util.Arrays;

public class ShellSortTest {

    public static void main(String[] args) {

        int [] arr = new int[]{3, 4, 10, 2, 1, 9, 0};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 实现希尔排序
     * @param arr
     */
    public static void ShellSort(int []arr){

        //首先需要确定好步长d，进行划分小组
        for(int d = arr.length/2; d > 0; d/=2 ){
            //开始遍历划分好的数组: 将获取到的步长作为开始值，是由于获取到的步长的值是第一组第二个数的索引，i++代表着之后的数字也一直是它们所在组的第二个数字，当然如果剩余的最后一个数字则为第一组的最后一位数字 ，进行与本组的对比（直接插入排序的思想）
            for(int i = d; i < arr.length; i++){
                int temp = arr[i];
                //对按照步长划分好的数组进行内部遍历,进行插入排序
                int j ;
                for (j = i-d; j >= 0 && temp < arr[j]; j-=d){
//                    if(arr[j] > temp){
//                        int temp = arr[j+d];
                    arr[j+d] = arr[j];
//                        arr[j] = temp;
//                    }
                }
                arr[j+d] = temp;
            }
        }
    }
}
