package com.zrwang.algorithmtest.lanqiaobei;

import java.util.HashMap;
import java.util.Scanner;

public class 凯撒密码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i ++){
            int code = str.codePointAt(i);
            code += 3;
            if(code > 122){
                code -= 26;
            }
            char[] chars = Character.toChars(code);
            sb.append(String.valueOf(chars));
        }
        System.out.println(sb.toString());
    }
}
