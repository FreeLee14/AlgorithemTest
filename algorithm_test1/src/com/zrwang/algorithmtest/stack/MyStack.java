package com.zrwang.algorithmtest.stack;

import java.util.Arrays;

public class MyStack {

    int [] stack;

    public MyStack(){
        //初始化栈的长度
        stack = new int[0];

    }


    // 入栈方法
    public void push(int params){
        //先创建出一个新的数组
        int [] newStack = new int[stack.length+1];
        //将原来数组中的数据依依对应填入新的数组中
        for (int i = 0; i < stack.length; i++){

            newStack[i] = stack[i];

        }
        //将新的数组的最后一位存入传进来的参数
        newStack[newStack.length-1] = params;
        //将旧的数组替换为新的数组
        stack = newStack;

    }
    //出栈时后进先出，所以弹出的数据应该为数组的最后一位
    public int pop () {
        //弹栈时如果栈为空，则抛出一个异常
        if (stack == null){
            throw new RuntimeException("stack is null");
        }

        //先创建出一个新的数组
        int[] newStack = new int[stack.length - 1];

        for (int i = 0; i < stack.length-1; i++){

            newStack[i] = stack[i];

        }
        //记录一下要弹出的数据的信息
        int popParam = stack[stack.length-1];
        //将旧的数组赋值为新的数组
        stack = newStack;

        return popParam;
    }
    //查看栈顶元素
    public int peek(){

        if(stack==null){
            return 0;
        }else{

            return stack[stack.length-1];

        }

    }

    /**
     * 判断当前栈是否为空
     * @return 是空返回true 不是空返回false
     */
    public boolean isEmpty () {
        if(stack == null || stack.length == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
