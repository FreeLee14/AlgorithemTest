package com.zrwang.algorithmtest.SideToOffer;

public class 删除链表节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode listNode = deleteNode(head, 1);
        System.out.println(head.toString());
    }
    public static ListNode deleteNode(ListNode head, int val){
        if (head == null) return head;
        if (head.val == val) return head.next;
        // 将链表赋值给新的参数
        ListNode node = head;
        while (node != null){
            if(node.next != null && node.next.val == val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };

 }
