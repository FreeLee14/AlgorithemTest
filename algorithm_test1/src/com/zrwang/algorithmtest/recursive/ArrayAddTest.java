package com.zrwang.algorithmtest.recursive;

public class ArrayAddTest {

    public static void main(String[] args) {

        int[] arr = new int[]{2,4,7,77,1};
        System.out.println(ArrayAdd(arr,0,arr.length-1));
    }

    /**
     *  //利用递归思想进行数组内部元素相加  {2，4，7，77，1}
     * @return
     */
    public static int ArrayAdd(int []arr,int start,int end){

        if(start <= end){
            return  arr[start]+ArrayAdd(arr,start+1,end);
        }else {
            return 0;
        }
    }
}
