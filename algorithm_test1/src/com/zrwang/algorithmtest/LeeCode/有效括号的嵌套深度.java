package com.zrwang.algorithmtest.LeeCode;

import java.util.Arrays;

/**
 * 1111 难度：中等
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 *
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 *  
 *
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 *
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 *
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 */
public class 有效括号的嵌套深度 {

    public static void main(String[] args) {

        String seq = "(()())";

        int[] result = maxDepthAfterSplit(seq);

        System.out.println(Arrays.toString(result));
    }

    private static int[] maxDepthAfterSplit(String seq) {

        // 将有效括号字符串转换为字符数组
        char[] seqArr = seq.toCharArray();
        // 定义一个中间变量，模拟括号中（）分别位于栈的层数，奇数层的分配给A，偶数层分配给B
        int temp = 0;
        // 定义一个结果数据
        int[] result = new int[seqArr.length];

        for (int i = 0; i < seqArr.length; i++){

            if (seqArr[i] == '('){

                temp++;
                // 判断当前所代表的层数的奇偶性并为结果数据赋值
                result[i] = temp % 2 == 0 ? 1 : 0;

            }else {
                // 如果匹配到了）那么先将当前的深度存在对应的符号上，因为（）是对应出现，所以）应当对应着（的层数，然后进行--操作，进行下一步的判断
                result[i] = temp % 2 == 0 ? 1 : 0;
                temp--;

            }

        }

        return result;
    }
}
