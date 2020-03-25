package com.zrwang.algorithmtest.graph;

//图的顶点类
public class Vertex {

    private String value;
    //添加一个访问的标识，已经访问过设定为true 默认值为false
    public boolean visited;

    public Vertex(String value){

        this.value = value;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return value;

    }
}
