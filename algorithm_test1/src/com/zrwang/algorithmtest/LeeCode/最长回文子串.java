package com.zrwang.algorithmtest.LeeCode;

/**
 * 5 最长回文子串 难度：中等
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 本题的思路是：使用动态规划
 */
public class 最长回文子串 {

    public static void main(String[] args) {

        String s = "a";

        String result = longestPalindrome(s);

        System.out.println(result);
    }

    private static String longestPalindrome(String s) {

        if (s.length() == 0 || s == "") return "";
        // 初始化最长回文子串
        String max = "";
        int length = s.length();

        boolean[][] arr = new boolean[length + 1][length + 1];

        for (int j = 0; j < length + 1 ; j++){

            for (int i = j; i >= 0; i--){
                // 使用substring时，例如subString（1，1）本身是空串，同时subString(1,2)截取的是自己本身，所以这些都属于回文字符串
                if (i == j || i+1 == j){
                    arr[i][j] = true;
                    // 判断截取字符串的头和尾对应的字符是否相等，同时判断它内部包含的那个子串是否是回文，这样我们就使用了之前保存的数据，形成了动态规划
                }else if (s.charAt(i) == s.charAt(j - 1) && arr[i+1][j-1]){

                    arr[i][j] = true;

                }

                if (arr[i][j] && i < j && max.length() < j - i){

                    max = s.substring(i,j);

                }
            }

        }

        return max;

    }

}
