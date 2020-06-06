package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 替换空格 {
    public static void main(String[] args) {
        String s = "12 34 123";
        String s1 = replaceSpace(s);
        System.out.println(s1);

    }

    /**
     * 采用直接操作字符的方法
     * @param s
     * @return
     */
    private static String replaceSpace(String s) {
        char[] chars = new char[s.length()*3];
        int size = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else{
                chars[size++] = c;
            }
        }
        String res = new String(chars,0,size);
        return res;
    }

    /*private static String replaceSpace(String s) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(s);
        String res = matcher.replaceAll("%20");

        return res;
    }*/

    /*public static String replaceSpace(String s) {
        String res = s;
        // 遍历整个字符串，遇到空格将替换为%20，但是这种方法不太推荐，可以用正则来进行更加快速的优化
        for(int i = 0; i < s.length(); i++){
            if(s.codePointAt(i) == 32){
                if (i + 1 < s.length()){
                    res = s.replace(s.substring(i,i+1), "%20");
                }else {
                    res = s.replace(s.substring(i),"%20");
                }
            }
        }
        return res;
    }*/

}
