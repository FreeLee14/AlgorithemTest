package com.zrwang.algorithmtest.tree.binarysorttree;



public class BinarySortTreeTest {

    public static void main(String[] args) {

//        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        //使用下面这个数组进行测试平衡二叉树(右旋转)
//        int [] arr = new int[]{8, 9, 6, 7, 5, 4};
        //使用下面这个数组进行测试平衡二叉树（左旋转）
//        int[] arr = new int[]{2, 1, 4, 3, 5, 6};
        // 使用下面这个数组进行测试平衡二叉树（双旋转，先左旋后右旋）
        int [] arr = new int[]{8, 9, 5, 4, 6, 7};

        BinarySortTree binarySortTree = new BinarySortTree();
        //遍历数组循环调用创建二叉查找树的方法
        for (int item: arr){
            binarySortTree.add(new Node(item));
        }

        binarySortTree.middleShow();

        System.out.println("----");

        System.out.println(binarySortTree.treeHeight());
        System.out.println(binarySortTree.root.value);
//        Node node = binarySortTree.binarySearch(3);

//        System.out.println(node);
//        binarySortTree.deleteNode(5);
//        binarySortTree.middleShow();
//        System.out.println("--------");
//        binarySortTree.deleteNode(3);
//        binarySortTree.middleShow();

//        binarySortTree.deleteNode(7);
//
//        binarySortTree.middleShow();

    }
}
