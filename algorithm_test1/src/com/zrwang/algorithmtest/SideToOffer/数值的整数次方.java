package com.zrwang.algorithmtest.SideToOffer;

public class 数值的整数次方 {

    public static void main(String[] args) {

        double v = myPow(2.00000, 2);
        System.out.println(v);
    }
    public static double myPow(double x, int n){
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x == 1) return 1;
        long N = n;
        if (N < 0)
            return 1 / myPow(x,N);
        else
            return myPow(x,N);

    }
    public static double myPow(double x, long N){

        if (N == 0) return 1;
        // 如果是偶数
        if ((N % 2) == 0){
            double res = myPow(x,N/2);
            return res * res;
        }else{
            double res = myPow(x,N/2);
            return res * res * x;
        }
    }
}
