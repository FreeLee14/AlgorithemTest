package com.zrwang.algorithmtest.queue;

/**
 * 实现队列
 */
public class MyQueue {

    int[] elements;

    public MyQueue (){
        elements = new int[0];
    }

    //入队
    public void add(int element){
        //定义一个新的数组
        int[] newArr = new int[elements.length+1];
        //将原来数组的值依次赋值给新的数组
        for(int i = 0; i < elements.length; i++){
            newArr[i] = elements[i];
        }
        //再将新添加的数据放在数组最后一位
        newArr[elements.length] = element;
        elements = newArr;
    }
    //出队
    public int push(){
        //获取到要出队的值
        int push = elements[0];
        //先定义一个新的数组
        int[] newArr = new int[elements.length-1];
        //将出队后的元素重新赋值给新的数组中
        for(int i = 0; i < newArr.length; i++){
            newArr[i] = elements[i+1];
        }
        elements = newArr;
        return push;
    }
    //判断是否为空
    public boolean isEmpty(){
        return elements.length == 0;
    }

}
