package com.ten951.algorithm.arraylinked.swappairs;


//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表

/**
 * @author Darcy
 * @date 2019-11-24 11:57
 */
public class Solution {

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head 链表
     * @return 新的
     */
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        /*-1->1->2->3->4*/
        ListNode tem = pre;
        while (tem.next != null && tem.next.next != null) {
            /*1 -> 2 -> 3 -> 4  慢指针*/
            ListNode start = tem.next;
            /*2 -> 3 -> 4  块指针*/
            ListNode end = tem.next.next;
            /*-1 -> 2 -> 3 -> 4  tem链表*/
            tem.next = end;
            /* 1 -> 3 -> 4 start链表*/
            start.next = end.next;
            /* 将tem和start 连接起来      这里写成 tem.next.next = start 也是可以的*/
            end.next = start;
            /*慢指针前进*/
            tem = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode pre1 = new ListNode(1);
        ListNode pre2 = new ListNode(2);
        ListNode pre3 = new ListNode(3);
        ListNode pre4 = new ListNode(4);
        pre1.next = pre2;
        pre2.next = pre3;
        pre3.next = pre4;

        ListNode listNode = new Solution().swapPairs(pre1);
        System.out.println("listNode = " + listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
