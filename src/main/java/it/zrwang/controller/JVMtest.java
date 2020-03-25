package it.zrwang.controller;

import it.zrwang.domain.TvDemo;

import java.util.ArrayList;
import java.util.List;

/*
*   模拟内存溢出场景，同时使用内存分析器进行性能分析
* */
public class JVMtest {

    public static void main(String[] args) {
        //创建一个arraylist集合
        List<TvDemo> tvDemos = new ArrayList<>();
        while (true){
            tvDemos.add(new TvDemo());
        }
    }


}
