package com.zrwang.algorithmtest.tree.binarysorttree;

//创建二叉排序树的类
public class BinarySortTree {

    Node root;

    /**
     * 定义二叉排序树的添加结点的方法（使用递归）
     */
    public void add(Node node){
        //首先判断如果是一颗空树
        if( root == null){
            //将第一个传进来的结点定义为根结点
            root = node;

        }else{

            root.add(node);

        }

    }
    // 中序遍历方法
    public void middleShow(){

        if (root!=null){

            root.middleShow();

        }

    }

    /**
     *  查找二叉查找数的某一个结点
     * @param value
     */
    public Node binarySearch(int value){
        //判断是否有根结点
        if(root == null){
            return null;
        }else {
            return root.binarySearch(value);
        }

    }

    /**
     *  删除二叉排序树的叶子结点
     * @param value
     */
    public void deleteNode(int value){

        if (root == null){
            return;
        }

        //我们需要先查找出这个结点
        Node target = binarySearch(value);
        //如果目标结点为null那就停止
        if (target == null){
            return;
        }

        //之后根据这个结点去查找它的父节点，然后让它的父节点指向它的指针置为null即可
        Node parent = searchParent(value);
        //当我们查找出其父结点之后，我们判断他是父结点的左右孩子的哪一个然后进行置null,并且要先判断当前结点没有孩子结点
        if(parent!=null && target.right==null && target.left==null){
            if(parent.left.value == value){
            // 要删除的结点是父结点的左子节点
                parent.left = null;
            }else if(parent.right.value == value){
            // 要删除的结点是父结点的右子结点
                parent.right = null;
            }
            //要删除的目标结点存在左孩子和右孩子
        }else if(target.left!=null && target.right!=null){
            //删除一个带有两个孩子的结点，需要将它的前驱节点或后继结点替换掉它的位置
            //这里我们使用它的后继结点来替换，这时就需要去删除右子树中最小的结点，并将它的值取出替换开始要删除的结点的权值。
            int min = deleteRightMin(target.right);
            //将值进行替换
            target.value = min;

        }else{
          // 最后这种情况就是当前结点存在左孩子或右孩子
            if (target.left != null){
                //如果要删除结点存在左子节点的时候
                if (parent.left.value == target.value){
                    // 如果当前要删除的结点是它的父结点的左子结点，那么就将父结点的左子结点的指针指向要删除结点的左孩子
                    parent.left = target.left;

                }else{
                    // 如果当前要删除的结点是它的父结点的右子结点，那么就将父结点的右子结点的指针指向要删除的左孩子
                    parent.right = target.left;

                }
            }else{
                //要删除结点有右子结点
                if (parent.left.value == target.value){

                    parent.left = target.right;

                }else {

                    parent.right = target.right;

                }
            }
        }

    }

    /**
     * 删除右子树中最小的结点（前提是已经进行了中序遍历）
     * @param right 目标结点的右子结点
     * @return
     */
    private int deleteRightMin(Node right) {

        Node target = right;

        while (target.left!=null){
            //循环递归的找出当前结点的左子节点的左子节点。。。。
            target = target.left;

        }

        deleteNode(target.value);

        return target.value;
    }


    /**
     * 根据权值查询某个结点的父结点
     * @param value
     * @return
     */
    private Node searchParent(int value) {

        if(root==null) {
           return null;
        }else{
            return root.searchParent(value);
        }
    }

    /**
     * 获取当前树的高度
     * @return
     */
    public int treeHeight(){

        if (root == null){
            return 0;
        }else {
            return root.treeHeight();
        }

    }
}
