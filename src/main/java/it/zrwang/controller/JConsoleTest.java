package it.zrwang.controller;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {

    //1：定义一个全局变量查看内存的使用情况
   // public Byte [] b = new Byte[128 * 1024];

    public JConsoleTest() {
        //2：定义一个局部变量
        Byte [] b = new Byte[128 * 1024];
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fill(1000);
    }

    //测试查看堆内存的变化
    private static void fill(int i) {
        List<JConsoleTest> jConsoleTests = new ArrayList<>();
        for (int j = 0; j < i; j++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jConsoleTests.add(new JConsoleTest());
        }
    }
}
