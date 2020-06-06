package com.zrwang.algorithmtest.SideToOffer;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        String a = "11231";
        boolean number = isNumber(a);
        System.out.println(number);
    }

    public static boolean isNumber(String s) {
        if (s.endsWith("d") || s.endsWith("f") || s.endsWith("D") || s.endsWith("F")) return false;
        try {
            double v = Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
