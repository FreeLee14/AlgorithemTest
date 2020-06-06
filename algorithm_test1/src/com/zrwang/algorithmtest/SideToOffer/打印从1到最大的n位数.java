package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class 打印从1到最大的n位数 {

    static int[] count = new int[]{0,9,99,999,9999,99999,999999,9999999,99999999,999999999};
    public static void main(String[] args) {
        int[] ints = printNumbers(2);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] printNumbers(int n) {
        int[] res=  new int[count[n]];
        for (int i = 1; i <= res.length; i++){
            res[i - 1] = i;
        }
        return res;
    }
}
