package com.zrwang.algorithmtest.SideToOffer;


import java.util.List;

public class 合并两个排序的链表 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(8);
        ListNode l8 = new ListNode(9);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode listNode = mergeTwoLists(l1, l5);
        System.out.println(listNode.val);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode(0);
        // item为遍历的指针
        ListNode item = res;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                item.next = l1;
                l1 = l1.next;
            }else {
                item.next = l2;
                l2 = l2.next;
            }
            // 指针移动到下一位
            item = item.next;
        }
        item.next = l1 != null ? l1:l2;
        return res.next;
    }
}
