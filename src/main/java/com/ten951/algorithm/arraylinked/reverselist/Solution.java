package com.ten951.algorithm.arraylinked.reverselist;


//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * 遍历解法
     * 时间复杂度 O(N) 从头到尾一次遍历
     * 空间复杂度 O(1) 无额外空间使用
     * 反转链表
     *
     * @param head 链表
     * @return 链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            /*临时遍历*/
            ListNode temp = curr.next;
            /*当期节点的下一个节点被赋值为前一个节点*/
            curr.next = prev;
            /*prev代表上一个节点*/
            prev = curr;
            /*curr前进*/
            curr = temp;
        }
        return prev;
    }


    /**
     * 递归解法
     * 时间负责度 转换成递归树发现没有分叉 是O(N)
     * 空间负责度 因为递归需要额外的栈空间. 所以也是O(N)
     * 1->2->3->4->null
     * @param head 链表
     * @return 链表
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /*head.next 相当于3节点  curr是4节点*/
        ListNode curr = reverseList2(head.next);
        /*将3.next.next 赋值为head自己*/
        head.next.next = head;
        head.next = null;
        return curr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
