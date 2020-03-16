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


 // solution 1, 头插法,head不动
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null) {
//             return head;
//         }
//         ListNode new_head = head;
//         while (head.next != null) {
//             ListNode next = head.next;
//             head.next = head.next.next;
//             next.next = new_head;
//             new_head = next;
//         }
//         return new_head;

//     }
// }

// solution 2, 头插法，head 动
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode new_head = null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=new_head;
            new_head=head;
            head=next;
        }
        return new_head;

    }
}
// @lc code=end

