package com.zrwang.algorithmtest.wanmeitest;

import java.util.*;

public class 礼物盒子嵌套 {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int x= reader.nextInt();
        int[][] array = new int[x][2];

        for (int i=0; i <x;i++){
            for (int j = 0; j < 2; j++){
                array[i][j] = reader.nextInt();
            }
        }

        System.out.println(maxEnvelopes(array));
    }

    private static int maxEnvelopes(int[][] array) {

        Arrays.parallelSort(array, Comparator.comparingInt(x -> x[0]));

        Stack<String> stack = new Stack<>();
        String temp = array[array.length-1][0] + " " + array[array.length - 1][1];

        stack.push(temp);
        int count = 0;
        int index = array.length - 2;
        if (array.length == 0) return 0;
        while (index >= 0){

            String peek = stack.peek();
            String[] s = peek.split(" ");
            if (array[index][0] < Integer.valueOf(s[0]) && array[index][1] < Integer.valueOf(s[1])){

                stack.push(array[index][0] + " " +array[index][1]);

            }
            index --;
        }

        return stack.size();
    }

}
