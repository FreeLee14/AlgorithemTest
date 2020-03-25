package com.zrwang.algorithmtest.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//构建一个赫夫曼树,即树的带权路径最短的二叉树也就是最优二叉树
public class HuffManTreeTest {

    public static void main(String[] args) {

        int [] arr = new int[]{7,14,15,25,10,8,23,29};
        Node node = createHuffManTree(arr);
        System.out.println(node.value);
    }

    private static Node createHuffManTree(int[] arr) {

        //首先将这个数组每一个元素作为一个只有根结点的二叉树存储在一个集合中
        List<Node> nodes = new ArrayList<Node>();
        for(int arrs : arr){
            nodes.add(new Node(arrs));
        }
//        System.out.println(nodes);
        while (nodes.size() > 1){
            //将这些二叉树根据权值大小进行排序，这里我们将直接使用collection所提供的排序方法
            //根据得到的排好序的根结点二叉树结合，进行组装赫夫曼数
            Collections.sort(nodes);
            //先定义一个集合下标,定位到最小位置
            int index = 0;
            //获取到最小的两个根节点,作为新的结点的左右结点
            Node left = nodes.get(index);
            Node right = nodes.get(index+1);
            //根据最小的两个结点的权值创建出新的结点，并将最小的两个结点分别作为新结点的左右孩子
            Node newNode = new Node(left.value + right.value);
            newNode.left = left;
            newNode.right = right;
            //将集合中最小的两个值去掉,并添加上新的结点
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(newNode);
        }
        return nodes.get(0);

    }
}
