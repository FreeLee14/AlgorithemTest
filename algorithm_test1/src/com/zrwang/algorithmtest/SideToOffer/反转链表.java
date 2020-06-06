package com.zrwang.algorithmtest.SideToOffer;

import java.util.ArrayList;
import java.util.List;

public class 反转链表 {
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
        ListNode listNode = reverseList(l1);
        System.out.println(listNode.val);
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode(0);
        ListNode item = head;
        ListNode next;
        //采用头插法将链表反转
        while (item != null){
            next = item.next;
            item.next = result.next;
            result.next = item;
            item = next;
        }
        return result.next;
    }
}
