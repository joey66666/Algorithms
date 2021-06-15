#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#
# https://leetcode-cn.com/problems/validate-binary-search-tree/description/
#
# algorithms
# Medium (34.36%)
# Likes:    1094
# Dislikes: 0
# Total Accepted:    284.3K
# Total Submissions: 827K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征：
#
#
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
#
#
# 示例 1:
#
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 输出: true
#
#
# 示例 2:
#
# 输入:
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
# 根节点的值为 5 ，但是其右子节点值为 4 。
#
#
#

# @lc code=start
# 1. Solution1, 中序遍历, Time: O(n), Space: O(n), Runtime: 77%
#   - BST: 中序遍历，结果为递增数组

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         def traverse(self, node: TreeNode, min: int, max: int):
#             if not node:
#                 return
#             if node.left:
#                 traverse(self, node.left, res)
#             res.append(node.val)
#             if node.right:
#                 traverse(self, node.right, res)

#         if not root:
#             return False
#         traverse(self, node, float('-inf'), float('inf'))

# 2. Solution2, 左右子树判断, Time: O(n), Space: O(n), Runtime: 77%
#   - BST: 左子树 < root.val, 右子树 > root.val
#   - traverse(node, min, max)，若 node.val 不在 [min, max] 区间，return False
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def traverse(node, Min=float('-inf'), Max=float('inf')) -> bool:
            if not node:
                return True
            val = node.val
            if val <= Min or val >= Max:
                return False
            if not traverse(node.left, Min, val):
                return False
            if not traverse(node.right, val, Max):
                return False
            return True

        if not root:
            return False
        # left tree < root.val; right tree > root.val
        return traverse(root)

# @lc code=end
