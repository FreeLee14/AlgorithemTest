package com.zrwang.algorithmtest.tree.huffmantree;

//构建结点类,并实现排序
public class Node implements Comparable<Node> {

    //定义权
    int value;
    //定义左右孩子
    Node left;
    Node right;

    //构建创建结点的构造方法
    public Node(int value){
        this.value = value;
    }
    //重写比较方法
    public int compareTo(Node o) {
        //该公式代表会正序排序
        int i = this.value - o.value;
        return i;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
