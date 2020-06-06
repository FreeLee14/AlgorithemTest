package com.zrwang.algorithmtest.LeeCode;

import java.util.Stack;

/**
 * 20 难度： 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 *  // 使用栈结构来进行存储判断 ,我们如果判断到左开区间({[直接存入栈中，当判断到右开区间)}]之后，先判断栈顶元素是否为对应的左开区间，如果是则弹出栈顶元素，如果不是对应的左开区间，这个右开区间进入到栈中（而一般出现这种情况也就是不会存在有效字符串）
 *  最后直接判断栈内元素是否为空，为空则是有效字符串
 */
public class 有效的括号 {

    public static void main(String[] args) {

        String s = "[({(())}[()])]";

        boolean b = isValid(s);

        System.out.println(b);

    }

    private static boolean isValid(String s) {


        char[] charArr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char item: charArr){

            if (item == '(')
                stack.add(item);

            if (item == '{')
                stack.add(item);

            if (item == '[')
                stack.add(item);

            if (item == ')'){

                if (stack.size() == 0)
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
                else stack.push(item);

            }
            if (item == ']'){

                if (stack.size() == 0)
                    return false;
                else if (stack.peek() == '[')
                    stack.pop();
                else stack.push(item);

            }
            if (item == '}'){

                if (stack.size() == 0)
                    return false;
                else if (stack.peek() == '{')
                    stack.pop();
                else stack.push(item);

            }

        }

        return stack.isEmpty();
    }
    
    /*private static boolean isValid(String s) {

        boolean flag = true;

        char[] charArr = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        // 如果长度为0 则不进行后续的判断
        if (charArr.length == 1) {

            flag = false;
            return flag;

        }
        // 定义一个counts，即判断没有正常闭合的情况
        int scounts = 0;
        int mcounts = 0;
        int bcounts = 0;


        for (char item: charArr){

            if (item == '('){

                scounts ++;
                stack.push(item);

            }
            if (item == ')'){

                if (stack.size() == 0){
                    flag = false;
                    break;
                }

                if (stack.peek() == ')' || stack.peek() == '(' || stack.peek() == ']' || stack.peek() == '}'){
                    scounts --;
                    stack.push(item);
                }else {

                    flag = false;
                    break;
                }



            }
            if (item == '{'){

                bcounts ++;
                stack.push(item);

            }
            if (item == '}'){

                if (stack.size() == 0){
                    flag = false;
                    break;
                }

                if (stack.peek() == '}' || stack.peek() == '{' || stack.peek() == ']' || stack.peek() == ')'){

                    bcounts --;
                    stack.push(item);

                }else {

                    flag = false;
                    break;
                }



            }
            if (item == '['){

                mcounts ++;
                stack.push(item);

            }
            if (item == ']'){

                if (stack.size() == 0){
                    flag = false;
                    break;
                }

                if ( stack.peek() == ']' || stack.peek() == '[' || stack.peek() == '}' || stack.peek() == ')'){
                    mcounts --;
                    stack.push(item);

                }else {

                    flag = false;
                    break;
                }

            }

        }
        if (bcounts != 0 || scounts != 0 || mcounts != 0){
            flag = false;
        }


        return flag;
    }*/
}
