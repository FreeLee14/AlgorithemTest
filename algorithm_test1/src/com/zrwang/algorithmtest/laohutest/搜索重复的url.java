package com.zrwang.algorithmtest.laohutest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 搜索重复的url {

    public static void main(String[] args) {

        String urlStr = "http://192.168.130.45/。。";

        searchDuplicate(urlStr);
    }

    private static void searchDuplicate(String urlStr) {

        Pattern p = Pattern.compile("(http://\\d{1,3}.\\d{1,3}.\\d{1,3}/\\w+?)\\1+");

        Matcher m = p.matcher(urlStr);

        while (m.find()){

            m.group();

        }

    }
}
