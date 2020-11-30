/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (60.15%)
 * Likes:    282
 * Dislikes: 0
 * Total Accepted:    60.1K
 * Total Submissions: 99.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = head;
        while (prev.next != null && prev.next.val < x) {
            prev = prev.next;
        }
        node = prev;
        while (node.next != null) {
            if (node.next.val < x) {
                ListNode tmp = node.next;
                node.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
                prev = prev.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

