package com.zrwang.algorithmtest.lanqiaobei;

import java.util.Scanner;
public class 反倍数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc2.nextLine();
        String[] s = str.split(" ");
        int res = 0;

        for(int i = 1; i <= n; i++ ){
            if(i % Integer.valueOf(s[0]) != 0 && i % Integer.valueOf(s[1]) != 0 && i % Integer.valueOf(s[2]) != 0){
                res++;
            }
        }
        System.out.println(res);
    }

}
