/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode new_head = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = new_head;
            new_head = next;
        }
        return new_head;

    }
}
// @lc code=end

