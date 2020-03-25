package com.zrwang.test.binaryTree;

import com.zrwang.algorithmtest.tree.binaryTree.BinaryArrayTree;

public class BinaryArrayTreeTest {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};
        BinaryArrayTree binaryArrayTree = new BinaryArrayTree(arr);
        binaryArrayTree.frontShow(0);
    }
}
