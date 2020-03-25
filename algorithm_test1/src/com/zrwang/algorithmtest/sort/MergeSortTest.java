package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

public class MergeSortTest {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,5,2,4,6,8,10};
        int[] arr = new int[]{10,12,1,2,5,7,87,10,4};
        /*System.out.println(Arrays.toString(arr));
        Merge(arr,0,2,arr.length-1);
        System.out.println(Arrays.toString(arr));*/
        System.out.println(Arrays.toString(arr));
        MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //定义递归的归并排序,从中间坐标开始分两边数组
    public static void MergeSort(int[] arr, int low, int high){
        //定义基线条件
        if(low < high){

            int middle = (low+high)/2;
            //开始递归缩小左边数组的规模
            MergeSort(arr,low,middle);
            //开始递归缩小右边数组的规模
            MergeSort(arr,middle+1,high);
            //调用归并排序方法
            Merge(arr,low,middle,high);

        }
    }

    //首先定义一个归并方法
    public static void Merge(int[] arr,int low, int middle, int high){

        //将一个大数组分为两部分，并分别获取到这两个数组的第一位的坐标
        int i = low;
        int j = middle+1;
        //定义一个临时数组用于存放结果数据
        int[] temp = new int[ (high-low ) + 1 ];
        //定义临时数组的索引
        int index = 0;
        while(i <= middle && j <= high ){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i++;
            }else{
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //如果某一侧的数组内容还有剩余，进行后续的拼接
        while (i <= middle){
            temp[index] = arr[i];
            index++;
            i++;
        }
        while( j <= high ){
            temp[index] = arr[j];
            index++;
            j++;
        }
        //最后我们将临时数组的数据替换到原始数组当中
        for(int t = 0; t < temp.length; t++){
            arr[t+low] = temp[t];
        }
    }
}
