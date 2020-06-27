/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (41.81%)
 * Likes:    532
 * Dislikes: 0
 * Total Accepted:    98.1K
 * Total Submissions: 232.4K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
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
// 1. 快指针指到头时慢指针指到中间
// 2. 反向慢指针到结尾之间的节点
// 3. 逐个比较前一半和反向过的后一半
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        while (prev != null) {
            if (prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
// @lc code=end

