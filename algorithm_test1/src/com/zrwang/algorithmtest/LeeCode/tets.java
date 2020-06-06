package com.zrwang.algorithmtest.LeeCode;

public class tets {

    public static void main(String[] args) {
        tesadsa te = new tesadsa();
        te.fun1(1);
        te.fun2();
        te.fun3();
        float a = 0;
        if (a == 0){
            System.out.println(1);
        }

    }
}
class tesadsa{
    int a = 1;
    int b = 2;

    public void fun1(int a){
        a = 5;
        int b = 10;
        System.out.println(a + "" +b);
    }
    public void fun2(){
        System.out.println(a + "" + b);
        b = 5;
    }
    public void fun3(){
        System.out.println(a + "" + b);
    }
}
