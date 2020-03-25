package com.zrwang.algorithmtest.KuaiShouMianShi;


import java.util.Arrays;
import java.util.Scanner;

/**
 *  1 22 22 33 22 12 45 44 5
 */

public class 数组寻值 {

    public static void main(String[] args) {

        //解题思路，先进行测试最后进行时间复杂度的优化，循环判断
        Scanner in = new Scanner(System.in);

        String strResult = "";
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNext()) {
            strResult = in.nextLine();

            String[] s = strResult.split(" ");

            int [] arr = new int[s.length];

            int[] counts  = new int[s.length];

            String result = "";

            for (int i = 0; i < s.length; i++){

                arr[i] = Integer.valueOf(s[i]);

                Arrays.sort(arr);

                // 要首先判断索引是否有效
                if (Integer.valueOf(s[i]) < arr[arr.length-1]  ){

                    counts[i] = 1;

                    if ( Integer.valueOf(s[i]) < arr[arr.length-2] && arr.length - 2 >=0 ){

                        counts[i] = 0;

                    }

                }

            }
            for (int i = 0; i < counts.length; i++ ){

                if (counts[i] == 1 ){

                    result += i + " ";

                }

            }
            if (result == ""){

                result = "-1";

            }

            System.out.println(result);

        }

    }
}
