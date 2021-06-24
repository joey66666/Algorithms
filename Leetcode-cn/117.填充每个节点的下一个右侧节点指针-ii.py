#
# @lc app=leetcode.cn id=117 lang=python3
#
# [117] 填充每个节点的下一个右侧节点指针 II
#
# https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/description/
#
# algorithms
# Medium (60.04%)
# Likes:    412
# Dislikes: 0
# Total Accepted:    74.1K
# Total Submissions: 123.4K
# Testcase Example:  '[1,2,3,4,5,null,7]'
#
# 给定一个二叉树
# 
# 
# struct Node {
# ⁠ int val;
# ⁠ Node *left;
# ⁠ Node *right;
# ⁠ Node *next;
# }
# 
# 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
# 
# 初始状态下，所有 next 指针都被设置为 NULL。
# 
# 
# 
# 进阶：
# 
# 
# 你只能使用常量级额外空间。
# 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
# 
# 
# 
# 
# 示例：
# 
# 
# 
# 
# 输入：root = [1,2,3,4,5,null,7]
# 输出：[1,#,2,3,#,4,5,7,#]
# 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next
# 指针连接），'#' 表示每层的末尾。
# 
# 
# 
# 提示：
# 
# 
# 树中的节点数小于 6000
# -100 
# 
# 
# 
# 
# 
# 
# 
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# 1. Solution1, 使用next指针BFS，Time: O(n), Space: O(1), Runtime: 61%
#   - 每一横向层抽象成单链表，在上一层为下一层建立 next 指针，建立完一层再继续下一层
#   - 使用`sentinel` node, 判断左右子结点是否存在的情况
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        parent = root
        while parent:
            sentinel = Node(-1)
            pre = sentinel
            while parent:
                if parent.left:
                    pre.next = parent.left
                    pre = pre.next
                if parent.right:
                    pre.next = parent.right
                    pre = pre.next
                parent = parent.next
            parent = sentinel.next
        return root
# @lc code=end

