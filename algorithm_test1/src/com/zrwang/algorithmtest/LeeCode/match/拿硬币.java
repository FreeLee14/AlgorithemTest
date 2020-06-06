package com.zrwang.algorithmtest.LeeCode.match;

public class 拿硬币 {

    public static void main(String[] args) {

        int[] coins = {2,3,10};
        int i = minCount(coins);
        System.out.println(i);

    }
    public static int minCount(int[] coins) {

        int count = 0;
        for(int item: coins){
            if(item % 2 == 0){
                count += item/2;
            }else if(item % 2 == 1){
                count += (item/2 + 1);
            }
        }
        return count;
    }
}
