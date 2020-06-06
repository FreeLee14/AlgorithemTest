package com.zrwang.algorithmtest.SideToOffer;

public class 正则表达式匹配 {

    public static void main(String[] args) {

        int a = 3;
        int b = 4;
//        test(a++,b++);

        test1(10000);
    }

    public static void test(int a,int b){
        System.out.println(a * b);
    }

    public static void test1 (int n){
        int ret = 0;
        while (n > 0){

            ret += n/5;
            n /= 5;

        }
        System.out.println(ret);
    }
}
