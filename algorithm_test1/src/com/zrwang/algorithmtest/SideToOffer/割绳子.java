package com.zrwang.algorithmtest.SideToOffer;

public class 割绳子 {

    public static void main(String[] args) {

        int i = cuttingRope(120);
        System.out.println(i);

    }
    public static int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        if(n % 3 == 0) return (int) Math.pow(3, n/3)  ;
        if(n % 3 == 1) return (int)  Math.pow(3, n/3-1)*4 ;
        else return  (int) Math.pow(3, n / 3) * 2 ;
    }
}
