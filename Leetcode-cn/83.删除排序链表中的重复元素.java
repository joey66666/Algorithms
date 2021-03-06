/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (49.85%)
 * Likes:    285
 * Dislikes: 0
 * Total Accepted:    89.6K
 * Total Submissions: 179.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
// 1. Solution1, 一次遍历, Time: O(n), Space: O(1), Runtime: 100%
//    - 注意边界，判断null
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            while (next != null && next.val == p.val) {
                next = next.next;
            }
            p.next = next;
            p = p.next;
        }
        return head;
    }
}
// @lc code=end
