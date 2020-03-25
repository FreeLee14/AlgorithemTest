package com.zrwang.algorithmtest.zhixiantest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入邀请码16位字符串，如果符合条件输出ok 不符合输出error
 */
public class 邀请码检测 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入字符长度为16位的邀请码");

        String invitedCode = scanner.nextLine();

        if (invitedCode.split("").length > 16){

            //如果检测到当前录入字符串长度大于16则直接输出error
            System.out.println("error");

        }

        //先创建出一个小写字母与数字（1-9）对应的数字字典
        HashMap<Character, Integer> word = new HashMap<Character, Integer>();

        int number = 1;

        for ( int i = 'a' ; i <= 'z'; i++ ) {

            if ( number > 9) {

                number = 1;

            }
            //将类型转换回来
            char c = (char) i;

            word.put(c , number);

            number ++;

        }
        //遍历我们的数据字典
        for (Map.Entry<Character, Integer> item: word.entrySet()){

            System.out.println(item.getKey()+" "+item.getValue());

        }

        // 执行方法
        String result = checkWord(invitedCode, word);

        System.out.println(result);

    }

    private static String checkWord(String invitedCode, HashMap<Character, Integer> word) {

        // 初始化奇数位和 ，偶数位和 以及总和
        Integer oddSum = 0;
        Integer evenSum = 0;
        Integer sum = 0;

        for (int i = invitedCode.length()-1; i >= 0; i--){

            // 定义一个中间变量
            Integer temp = 0;

            //先判断当前字符是否为字母,使用一个中间变量存储当前的要进行计算的数字
            if (Integer.valueOf(invitedCode.charAt(i)) >= 97){

                temp = word.get(invitedCode.charAt(i));


            }else {

                temp = Integer.valueOf(invitedCode.substring(i,i+1));

            }
            //判断奇数偶数位
            if ((i + 1) % 2 == 1){
                //如果是奇数则进行直接相加
                oddSum += temp;

            }else if ((i + 1) % 2 == 0){
                //如果是偶数位则进行×2，并判断结果是否大于两位数如果大于则-9
                temp *= 2;
                if (temp  > 9){

                    temp -= 9;
                    evenSum += temp;

                }else {

                    evenSum += temp;

                }

            }

        }

        sum = oddSum + evenSum;

        if (sum % 10 ==0){

            return "ok";

        }else {

            return "error";

        }

    }

}
