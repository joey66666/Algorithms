/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (69.27%)
 * Likes:    850
 * Dislikes: 0
 * Total Accepted:    230.1K
 * Total Submissions: 332.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
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

// 1. Solution1, 迭代, Time: O(n), Space: O(1), Runtime: 100%
//    - 新建一个 `sentinel.next = head` ，使用 `temp` 从 `sentinel` 开始遍历, 遍历结束条件: `temp.next == null || temp.next.next == null`
//    - 令 `node1 = temp.next, node2 = temp.next.next`
//    - 核心:
//       ```java
//       temp.next = node2; 
//       node1.next = node2.next; 
//       node2.next = node1; 
//       temp = node1;
//       ```
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode temp = sentinel;
        while(temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return sentinel.next;
    }
}
// @lc code=end

