package com.zrwang.algorithmtest.wanmeitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 坐船问题 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.split(" ");
        int[] weights = new int[str1.length];
        for(int i =0; i < str1.length; i++){
            weights[i] = Integer.parseInt(str1[i]);
        }
        int maxLoad = Integer.parseInt(br.readLine());
        int count = countLeastBoat(weights,maxLoad);
        System.out.println(count);
    }

    private static int countLeastBoat(int[] weights, int maxLoad) {

        int sum = 0;
        int count;

        for (int item:weights){
            sum+=item;
        }

        if (sum % maxLoad == 0){

            count = sum / maxLoad;

        }else{

            count = sum / maxLoad + 1;

        }

        return count;
    }
}
