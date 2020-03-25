package com.zrwang.algorithmtest.recursive;

public class HanoiGame {

    public static void main(String[] args) {
        Hanoi(4,'A','B','C');
    }

    //定义汉诺塔游戏的方法

    /**
     *
     * @param n   棋子的个数
     * @param from  起始位置坐标
     * @param in    中间位置坐标
     * @param to    目标位置坐标
     *              注意：起始、中间、目标位置的坐标会随着棋子的运动而进行改变
     */
    public static void Hanoi(int n, char from, char in, char to){
        //当只有一个棋子时，各个坐标位置不用改变，直接将 1 从 A——C
        if(n == 1){
            System.out.println("第1个棋子从 "+from+" 移动到 "+to+" ");
        }else {
            //将除最下面的一个棋子上面的所有棋子移动至中间位置,此时目标位置的坐标为中间位置
            Hanoi(n-1, from, to, in);
            System.out.println("第"+n+"个棋子从 "+from+" 移动到 "+to+" ");
            //中间位置的棋子移动至目标位置,此时方法的起始位置坐标变为中间位置，目标位置的坐标不变，中间位置的坐标变为起始位置
            Hanoi(n-1, in, from, to);
        }
    }
}
