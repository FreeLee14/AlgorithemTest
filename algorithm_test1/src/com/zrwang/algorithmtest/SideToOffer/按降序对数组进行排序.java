package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 按降序对数组进行排序 {

    public static void main(String[] args) {
        String[] arr = new String[]{"b"};
        String[] res = myFunction(arr);
        String s = Arrays.toString(res);
        System.out.println(s);
    }

    public static String[] myFunction(String[] arr) {
        if (arr.length == 0|| arr == null) return arr;
        int len = arr.length;
        Arrays.sort(arr, 0, len - 1, Comparator.comparingInt(s -> s.codePointAt(0)));
        List<String> strings = Arrays.asList(arr);
        Collections.reverse(strings);
        return (String[]) strings.toArray();
    }
}
