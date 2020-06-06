package com.zrwang.algorithmtest.SideToOffer;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filter {

    public static void main(String[] args) {
        String str = "Abcddsa12>Tets";
        String filter = filter(str);
        System.out.println(filter);
    }
    public static String filter (String str) {
        int index = 0;
        int len = str.length();
        String s = str.toUpperCase();
        StringBuilder sb = new StringBuilder();

        while (index < len){
            try {
                    Double.parseDouble(s.substring(index,index+1));
            }catch (Exception e){
                if (s.substring(index,index+1).codePointAt(0) >= 65 && s.substring(index,index+1).codePointAt(0) <= 90)
                    sb.append(s.substring(index,index+1));
            }
            index++;
        }

        return sb.toString();
    }
}
