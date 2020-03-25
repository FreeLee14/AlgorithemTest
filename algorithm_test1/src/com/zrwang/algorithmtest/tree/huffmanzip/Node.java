package com.zrwang.algorithmtest.tree.huffmanzip;

//实现赫夫曼编码所需要创建的结点
public class Node implements Comparable<Node>{

    //定义权值
    int value;
    //定义结点的数据
    Byte data;
    //定义左右孩子
    Node left;
    Node right;

    //定制构造函数，一个结点上需要存在该结点的ASCII码数据以及权值
    public Node(Byte data, int value){

        this.data = data;
        this.value = value;

    }

    @Override
    public int compareTo(Node o) {
        //该公式实现倒序排序
        return o.value - this.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", data=" + data +
                '}';
    }
}
