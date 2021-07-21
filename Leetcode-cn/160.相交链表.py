#
# @lc app=leetcode.cn id=160 lang=python3
#
# [160] 相交链表
#
# https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
#
# algorithms
# Easy (60.73%)
# Likes:    1273
# Dislikes: 0
# Total Accepted:    296.1K
# Total Submissions: 486.8K
# Testcase Example:  '8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3'
#
# 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
# 
# 图示两个链表在节点 c1 开始相交：
# 
# 
# 
# 题目数据 保证 整个链式结构中不存在环。
# 
# 注意，函数返回结果后，链表必须 保持其原始结构 。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
# skipB = 3
# 输出：Intersected at '8'
# 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
# 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
# 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
# 
# 
# 示例 2：
# 
# 
# 
# 
# 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
# 1
# 输出：Intersected at '2'
# 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
# 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
# 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
# 
# 
# 示例 3：
# 
# 
# 
# 
# 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
# 输出：null
# 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
# 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
# 这两个链表不相交，因此返回 null 。
# 
# 
# 
# 
# 提示：
# 
# 
# listA 中节点数目为 m
# listB 中节点数目为 n
# 0 
# 1 
# 0 
# 0 
# 如果 listA 和 listB 没有交点，intersectVal 为 0
# 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB +
# 1]
# 
# 
# 
# 
# 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# 1. Solution1, 双指针先走到平齐再一起走，Time: O(n), Space: O(1), Runtime: 97%
#   - 计算长度差，长的先走到两边平齐，再一起走，相交则return，走到头不相交return null 
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        pA, pB = headA, headB
        sub = 0
        while pA.next:
            pA = pA.next
            sub += 1
        while pB.next:
            pB = pB.next
            sub -= 1
        pA, pB = headA, headB

        # A比B多, A先走
        if sub > 0:
            while sub:
                pA = pA.next
                sub -= 1
        elif sub < 0:
            sub = abs(sub)
            while sub:
                pB = pB.next
                sub -= 1
        while pA:
            if pA == pB:
                return pA
            pA = pA.next
            pB = pB.next
        return
 

# 2. Solution2, 双指针在两个链表上交叉循环遍历，Time: O(m + n), Space: O(1), Runtime: 99%
#   - a，b不为空往后走，若一个为空则从另一条链重新走
#   - a.next == null ? a = headB : a = a.next
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        pA, pB = headA, headB
        while pA != pB:
            if not pA:
                pA = headB
            else:
                pA = pA.next
            if not pB:
                pB = headA
            else:
                pB = pB.next
        return pA
# @lc code=end

