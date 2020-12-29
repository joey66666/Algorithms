/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
// class Solution {
//     public ListNode reverseBetween(ListNode head, int m, int n) {

//         // 需逆转长度
//         int change_len = n - m + 1;
//         // 开始逆转的链表头前一个
//         ListNode pre_head = null;
//         // 逆转后链表头
//         ListNode result = head;

//         for (int i = 1; i < m; i++) {
//             pre_head = head;
//             head = head.next;
//         }

//         // 逆转后链表尾
//         ListNode modify_list_tail = head;
//         ListNode new_head = null;

//         for (int i = 1; i <= n - m + 1; i++) {
//             ListNode next = head.next;
//             head.next = new_head;
//             new_head = head;
//             head = next;
//         }
//         modify_list_tail.next = head;
//         if (pre_head != null) {
//             pre_head.next = new_head;
//         } else {
//             result = new_head;
//         }
//         return result;
//     }
// }

class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode node = sentinel;
        for(int i = 1; i < m; i++){
            prev = prev.next;
        }
        node = prev.next;
        for(int j = m; j < n; j++){
            ListNode remove = node.next;
            node.next = remove.next;
            remove.next = prev.next;
            prev.next = remove;
        }
        return sentinel.next;
    }
}
// @lc code=end
