package com.zrwang.algorithmtest.recursive;

public class FibonacciTest {

    public static void main(String[] args) {
        System.out.println( Fibonacci(10));
    }

    /**
     * 斐波那契数列问题，1，1，2，3，5，8，13，21（规律就是从第三个数开始等于前两个数之和）适合解答兔子等一系列繁衍问题
     * @param n  代表第几个数字，在兔子繁衍问题中代表第几代
     */
    public static int Fibonacci (int n){

        if(n == 1 || n == 2){
            return 1;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}
