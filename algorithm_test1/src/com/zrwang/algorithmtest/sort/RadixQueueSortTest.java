package com.zrwang.algorithmtest.sort;

import com.zrwang.algorithmtest.queue.MyQueue;

import java.util.Arrays;

/**
 * 通过队列实现基数排序
 */
public class RadixQueueSortTest {
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
        //在一个数组中定义10个队列
        MyQueue[] queues = new MyQueue[10];
        //为每一个queue进行初始化
        for(int i = 0; i < queues.length; i++){
            queues[i] = new MyQueue();
        }
        //开始进行基数排序
        for(int j = 0,n=1; j < max_length; j++,n*=10){
            for(int i = 0; i < arr.length; i++){
                //定义一个通式能够在三次循环中分别拿出：个、十、百位
                int ys = arr[i]/n%10;
                //进入到对应的队列当中去
                queues[ys].add(arr[i]);
            }
            //将临时数组中的数据存放回原来的数组,对存放每一列个数的数组进行遍历
            //初始化一个index记录存放至原来数组的索引
            int index = 0;

            for (int i = 0; i < queues.length; i++){
                //当队列不为空时，依次将每个队列中的数据push到原来数组当中
                while (!queues[i].isEmpty()){
                    arr[index] = queues[i].push();
                    index++;
                }
            }
        }
    }
}
