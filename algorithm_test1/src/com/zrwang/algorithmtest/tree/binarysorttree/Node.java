package com.zrwang.algorithmtest.tree.binarysorttree;

import javax.sound.midi.Soundbank;

/**
 * @author zrwang
 * 创建结点
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value){

        this.value = value;

    }

    //定义得出二叉树高度的方法(思想便是，获取左右子树中最高的那一个，然后这个子树的高度+1即为整个树的高度)
    public int treeHeight(){

        return Math.max(left==null?0:left.treeHeight(), right==null?0:right.treeHeight())+1;

    }
    // 获取当前左子树的高度
    public int leftTreeHeight(){
        if (left==null){
            return 0;
        }else {
            return left.treeHeight();
        }
    }
    // 获取当前右子树的高度
    public int rightTreeHeight(){
        if (right==null){
            return 0;
        }else {
            return right.treeHeight();
        }
    }

    /**
     * 构建二叉查找树添加结点的方法
     * 2020.03.04 补充构建过程中将二叉树转变为平衡二叉树
     * @param node  传入的结点
     */
    public void add(Node node) {

        if (node == null){
            return;
        }
        //如果传入的结点值小于当前节点值，则放在左边
        if (node.value < this.value){
            //判断当前结点是否有左孩子
            if(this.left == null ){
                //如果没有，直接将传入节点赋值为当前结点的左孩子
                this.left = node;
            }else {
                //如果有，则对当前的左孩子进行递归
                this.left.add(node);
            }
        }
        //如果传入的结点值大于当前结点值，则放在右边
        if (node.value > this.value){
            //判断当前结点是否有右孩子
            if (this.right == null ){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
        // 转换为二叉排序树之后，我们进行其左右子树的高度差，看看需不需要执行单旋转操作转换为平衡二叉树（也就是红黑树）
        // 首先是左左情况，然后向右旋转
        if (leftTreeHeight() - rightTreeHeight() > 1){
            // 判断当前结点是否存在左子结点，然后判断是否是左子节点的左子树高度小于右子树
            if(left!=null && left.leftTreeHeight() < left.rightTreeHeight()){
                //先对这样的左子树进行左旋转，会得到一个适合右旋转的二叉排序树
                left.leftRotate();
                // 进行右旋转
                rightRotate();
            }else {
                // 只进行单旋转的情况
                rightRotate();
            }

        }
        // 若是右右情况，需要进行左旋转
        if (leftTreeHeight() - rightTreeHeight() < -1){
            leftRotate();
        }
    }

    /**
     * 进行左旋转
     */
    private void leftRotate() {

        //首先将当前结点赋值给一个新的结点
        Node newLeft = new Node(this.value);
        //之后将原来当前结点的左节点赋值给新结点的左节点
        newLeft.left = this.left;
        //将当前结点的右结点的左节点赋值给新结点的右节点
        newLeft.right = this.right.left;
        //将当前结点设置为它的右节点
        this.value = this.right.value;
        //将当前结点的右子树设置为原来右节点的右子树
        this.right = this.right.right;
        //将当前结点的左子树设置为新生成的树
        this.left = newLeft;
    }

    /**
     * 进行右旋转
     */
    private void rightRotate() {

        //首先获取当前结点，以及其右结点，还有当前结点的左节点的右节点，组成一个新的二叉树
        Node newRight = new Node(this.value);

        newRight.right = right;

        newRight.left = left.right;

        //把当前结点设置为当前结点的左节点
        this.value = left.value;
        //把当前结点的左节点设置为原来结点的左节点的左节点
        this.left = left.left;
        //把当前结点的右子结点设置为新生成的结点
        this.right = newRight;
    }

    /**
     * 中序遍历二叉查找树
     */
    public void middleShow() {

        if (left != null){
            left.middleShow();
        }

        System.out.println(this.value);

        if (right != null){

            right.middleShow();

        }

    }

    /**
     * 定义二叉查找树的方法
     * @param value  需要查询结点的权值
     * @return
     */
    public Node binarySearch(int value) {

        //判断传入的权值与当前结点的权值是否一致
        if(this.value == value){
            return this;
        }

        if(this.value > value && this.left!=null){
            //如果传入的权值小于当前结点的权值，就去左子树进行查找
            return this.left.binarySearch(value);
        }else if(this.value < value && this.right!=null) {
            //如果传入的权值大于当前结点的权值，就去右子树进行查找
            return this.right.binarySearch(value);
        }else {
            return null;
        }

    }

    /**
     * 根据权值查询某个结点的父结点
     * @param value
     * @return
     */
    public Node searchParent(int value) {

        //判断当前调用这个方法的结点的左右孩子是否等于传入的参数，如果是那么当前结点就是这个要查询结点的父结点
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
            return this;
        }
        //判断当前结点的值如果大于传入的参数值，就去左子树进行递归查找
        if(this.value > value && this.left != null){
            return this.left.searchParent(value);
        }else if(this.value < value && this.right != null){
            //当前结点的值小于传入的参数值，就去右子树进行递归查找
            return this.right.searchParent(value);
        }else {
            return null;
        }
    }
}
