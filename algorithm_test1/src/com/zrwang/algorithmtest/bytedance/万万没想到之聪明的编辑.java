package com.zrwang.algorithmtest.bytedance;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：
 *
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 * 我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
 * ……
 * 万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……
 *
 * 请听题：请实现大锤的自动校对程序  // 该题应当使用正则表达式去解答
 */
public class 万万没想到之聪明的编辑 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入要校验的字符串个数");

        int counts = scanner.nextInt();

        System.out.println("请输入要校验的字符串");

        while (counts-- >= 0){

            String inputStr = scanner.nextLine();

            String result = schedulStr(inputStr);

            System.out.println(result);

        }
    }

    private static String schedulStr(String inputStr) {
        // 使用正则表法是进行替换
//       return inputStr.replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2");

        //使用反向引用 匹配所有的两个以上连续的字符串例如一串连续的oooooooooo这种疯狂无脑的东西
        Pattern p1 = Pattern.compile("(.)\\1+");
        //使用反向引用 匹配类似于AABB这种组合的字符串  AABB CCDD按照这种格式进行匹配
        Pattern p2 = Pattern.compile("(.)\\1(.)\\2");

        Matcher m1 = p1.matcher(inputStr);
        // 第一次替换，将存在连续两个以上的字符串全部替换为这个符号本身的两位大小例如woooooooow 使用这个替换就直接替换为woow
        // 反向引用数据也就是使用p1中第一个括号中匹配到的内容
        String s = m1.replaceAll("$1$1");

        Matcher m2 = p2.matcher(inputStr);
        // 这个主要是将类似于AABB替换为AAB，这里使用反向引用p2中第一个括号匹配到的数据和第二个括号匹配到的数据
        String s1 = m2.replaceAll("$1$1$2");


        return s;

    }
}
