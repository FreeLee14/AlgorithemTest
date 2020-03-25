package com.zrwang.algorithmtest.sort;

import java.util.Arrays;

/**
 * 堆排序的实现，根据顺序存储二叉树的概念进行堆排序
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 8, 0, 1, 6, 5, 2, 3, 4};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 定义堆排序方法
     * @param arr  传入的数组
     */
    public static void HeapSort(int[] arr){
        //定义开始位置
        int start = (arr.length - 1)/2;
        //通过遍历起始位置调整为大顶堆
        for(int i = start; i > 0; i--){
            maxHeap(arr,arr.length,i);
        }
        //调整为大顶堆之后，把堆顶的数据与堆尾的数据交换,然后再进行调整为大顶堆
        for(int i = arr.length-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i,0);
        }
    }
    /**
     * 定义转换为大顶堆的方法（只是一个最大数字升至堆顶的方法）
     * @param arr       传入要转换为大顶堆的数组
     * @param size      需要调整的数组的规模（也就是数组的长度）
     * @param index     定义遍历的起始位置（最开始为非叶子节点的最后一个节点）
     */
    public static void maxHeap(int[] arr, int size, int index){
        //定义左子节点
        int leftNode = 2*index + 1;
        //定义右子节点
        int rightNode = 2*index + 2;
        //假设index对应的就是最大值的索引
        int max = index;
        //判断左子节点是否大于双亲节点，如果大于则重新给max赋值新的索引
        if(leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        //判断右子节点是否大于双亲结点，如果大于则重新给max赋值新的索引
        if(rightNode < size && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        //判断当前max是否为index
        if(max!=index){
            //不是进行互换位置
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //如果我们调换位置之后影响了被调换位置子节点的子树结构，我们需要进行根据子节点为开始位置进行转换大顶堆操作
            maxHeap(arr,size,max);
        }
    }
}
