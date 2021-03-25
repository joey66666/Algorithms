/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (50.44%)
 * Likes:    559
 * Dislikes: 0
 * Total Accepted:    117.7K
 * Total Submissions: 227.5K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 返回同样按升序排列的结果链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围 [0, 300] 内
 * -100 
 * 题目数据保证链表已经按升序排列
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Solution1, Time: O(n), Space: O(1), Runtime: 64%
//    - 从prev开始，后面的next1和next2不能重复，不然全部丢弃
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        while (prev.next != null && prev.next.next != null) {
            ListNode next1 = prev.next, next2 = prev.next.next;
            if (next1.val == next2.val) {
                while (next2 != null && (next1.val == next2.val)) {
                    next1.next = next2.next;
                    next2 = next1.next;
                }
                prev.next = next1.next;
            } else {
                prev = prev.next;
            }
        }
        return sentinel.next;
    }
}
// @lc code=end

