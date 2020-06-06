package com.zrwang.algorithmtest.bosstest;

import java.util.Stack;

public class 将一个单链表倒置 {

    public static void main(String[] args) {

        ListNode root = new ListNode();
        ListNode next1 = new ListNode();
        ListNode next2 = new ListNode();
        ListNode next3 = new ListNode();

        root.val = 4;
        root.next = next1;
        next1.next = next2;
        next2.next = next3;

        next1.val = 3;
        next2.val = 2;
        next3.val = 1;

        ListNode listNode = revertLinkList(root);

        System.out.println(listNode.val);

    }
    public static ListNode revertLinkList (ListNode root) {
        // write code here

        Stack<Integer> stack = new Stack<>();
        ListNode temp = root;
        // 先将头节点存放在栈中
        stack.push(root.val);
        //借助栈结构来实现链表倒置
        while (temp.next != null){
            // 将下一个节点赋值给
            temp = temp.next;
            stack.push(temp.val);
        }
        temp = root;
        // 重新给链表赋值，首先给头节点赋值
        root.val = stack.pop();

        while (stack.size() != 0){

            temp = temp.next;
            temp.val = stack.pop();
        }

        return root;
    }
}

class ListNode {
 int val;
 ListNode next = null;
}
