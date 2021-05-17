#
# @lc app=leetcode.cn id=993 lang=python3
#
# [993] 二叉树的堂兄弟节点
#
# https://leetcode-cn.com/problems/cousins-in-binary-tree/description/
#
# algorithms
# Easy (51.10%)
# Likes:    63
# Dislikes: 0
# Total Accepted:    8K
# Total Submissions: 15.6K
# Testcase Example:  '[1,2,3,4]\n4\n3'
#
# 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
#
# 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
#
# 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
#
# 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
#
#
#
# 示例 1：
#
#
# 输入：root = [1,2,3,4], x = 4, y = 3
# 输出：false
#
#
# 示例 2：
#
#
# 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
# 输出：true
#
#
# 示例 3：
#
#
#
# 输入：root = [1,2,3,null,4], x = 2, y = 3
# 输出：false
#
#
#
# 提示：
#
#
# 二叉树的节点数介于 2 到 100 之间。
# 每个节点的值都是唯一的、范围为 1 到 100 的整数。
#
#
#
#
#

# @lc code=start
# 1. Solution1, BFS, Time: O(n), Space: O(n), Runtime: 98%
#   - 遍历一遍树，保存到HashSet, K: 节点值, V: 节点深度和父节点
#   - 取HashSet，parent不相等且depth相等
#   - 优化：只存x和y，Space: O(n) -> O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Value:
    def __init__(self, x, parent, depth):
        self.val = x
        self.parent = parent
        self.depth = depth


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        res = {}
        self.build(root, TreeNode(-1), 0, res, x, y)
        return (res[x].depth == res[y].depth) and (res[x].parent != res[y].parent)

    def build(self, root: TreeNode, parent: TreeNode, depth: int, res: dict, x: int, y: int):
        if not root:
            return
        if root.val == x or root.val == y:
            res[root.val] = Value(root.val, parent, depth)
        if root.left:
            self.build(root.left, root, depth + 1, res)
        if root.right:
            self.build(root.right, root, depth + 1, res)
        return

    # @lc code=end
