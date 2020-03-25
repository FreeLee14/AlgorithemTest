package com.zrwang.algorithmtest.graph;

import com.zrwang.algorithmtest.stack.MyStack;

//图的实现
public class Graph {

    private Vertex [] Vertex;
    //创建邻接矩阵
    public int [][] adjMat;
    //创建一个变量记录当前索引值
    private int currentIndex = 0;
    //创建一个变量用于bfs时记录下标
    private int index = 0;

    public Graph(int size){

        Vertex = new Vertex[size];
        adjMat = new int[size][size];

    }

    //添加顶点的方法
    public void addVertex(Vertex v){

        Vertex[currentIndex++] = v;

    }

    //连通这个图的方法，添加边
    public void addEdge(String v1, String v2){

        //首先我们先获取要添加这两个顶点值的索引
        int index1 = 0;

        for (int i = 0; i < Vertex.length; i++){

            if(v1.equals(Vertex[i].getValue())){
                index1 = i;
            }
        }

        int index2 = 0;

        for (int i = 0; i < Vertex.length; i++){

            if(v2.equals(Vertex[i].getValue())){

                index2 = i;

            }
        }
        adjMat[index1][index1] = 1;
        adjMat[index2][index2] = 1;
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;

    }

    //深度优先搜索的算法实现  bfs
    public void bfs () {

        //  首先我们先创建出一个栈用于存储已经访问过的元素
        MyStack stack = new MyStack();
        //  在开始时第一个元素就会被我们所访问，所以将第一个元素压入栈中，并给它标记已经访问
        Vertex[0].visited = true;

        stack.push(0);
        //打印顶点的值
        System.out.println(Vertex[0].getValue());
        //开始进行遍历
        out:while (!stack.isEmpty()){
            // 开始遍历顶点数组
            for(int i = index+1; i < Vertex.length; i++){
                // 因为currentIndex的默认值为0所以我们从A开始根据邻接矩阵找它后面连通的顶点
                if(adjMat[index][i] == 1 && Vertex[i].visited == false){
                    // 如果找到连通的顶点，并且该节点还未被访问，首先将该顶点的位置压入栈中，并标记以访问
                    stack.push(i);
                    Vertex[i].visited = true;
                    System.out.println(Vertex[i].getValue());
                    // 如果我们找到了连通点后，跳出内部循环，从外部循环开始，这时currentIndex为已经找到顶点的位置,并且也是为了防止找到后还要执行下方的弹栈操作
                    continue out;
                }

            }
            //先进行弹栈
            stack.pop();
            //如果一条路径已经到头，这时需要进行回退上一个顶点，开始搜寻上一个顶点的其他连通顶点
            if(!stack.isEmpty()){
                //之后将栈顶元素的位置赋值给索引，作为新的位置开始
                index = stack.peek();
            }

        }

    }
}
