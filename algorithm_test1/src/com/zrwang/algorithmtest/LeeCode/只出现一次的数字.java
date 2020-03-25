package com.zrwang.algorithmtest.LeeCode;


import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {

        int [] arr = new int[]{4,1,2,1,2};

        int result = onlyOne(arr);

        System.out.println(result);

    }


    private static int onlyOne(int[] arr) {

        int result = 0;

        //考虑到线性的时间复杂度，同时不额外开辟空间，需要进行位运算，这里采用异或（相同为0，不同为1），这样我们的数组中，相同的数字异或全都为0，而剩下当都的数字再与0异或还是自己本身。

        for (int i = 0; i < arr.length; i++){

            result = result^arr[i];  // 按照这个例子就相当于 4^1^2^1^2  等价于  4^1^1^2^2 = 4^0^0 =4



//            int temp = arr[i];
//
//            arr[i] = arr[i]+1;
//
//            String s = Arrays.toString(arr);
//
//            String value = String.valueOf(temp);
//
//            if (s.indexOf(value) == -1){
//
//                result = Integer.valueOf(value);
//
//                break;
//            }
//
//            arr[i] = temp;


//            int search = Arrays.binarySearch(arr, temp);
//
//            if (search < 0){
//                // 当查询到的索引为负数，则证明这个数字只出现了一次，将这个数据赋值给结果，并直接跳出循环
//                result = temp;
//                break;
//
//            }
//            // 如果不是只出现一次的数字，将数组还原
//            arr[i] = temp;

        }

        return result;
    }
}
