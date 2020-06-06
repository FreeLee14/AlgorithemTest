package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {

        int[] numbers = {3,4,5,1,2};
        int min = minArray(numbers);
        System.out.println(min);
    }

    private static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int mid = (i + j)/2;
            if (numbers[mid] < numbers[j]){
                j = mid;
            }
            if (numbers[mid] > numbers[j]){
                i = mid + 1;
            }
            if (numbers[mid] == numbers[j]){
                j -= 1;
            }
        }
        return numbers[i];
    }


    /**
     * 简单暴力解法（并非本题真正含义）
     * @param numbers
     * @return
     */
    /*public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }*/
}
