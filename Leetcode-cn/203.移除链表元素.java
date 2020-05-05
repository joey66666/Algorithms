/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (45.27%)
 * Likes:    380
 * Dislikes: 0
 * Total Accepted:    75.1K
 * Total Submissions: 165.9K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 *
 */

// @lc code=start


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode start = new ListNode(0);
        ListNode prev = start;
        prev.next = head;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        return start.next;
    }
}

// @lc code=end

