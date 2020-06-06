package com.zrwang.algorithmtest.SideToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 结合栈，先进行链表的反转，之后弹出倒数第k个数值
 */
public class 链表中倒数第K个节点 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode kthFromEnd = getKthFromEnd(l1, 2);
        System.out.println(kthFromEnd.val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        if (k > list.size() || k < 0) return null;
        return list.get(list.size() - k);
    }
}

