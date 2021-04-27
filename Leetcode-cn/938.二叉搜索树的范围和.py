#
# @lc app=leetcode.cn id=938 lang=python3
#
# [938] 二叉搜索树的范围和
#
# https://leetcode-cn.com/problems/range-sum-of-bst/description/
#
# algorithms
# Easy (78.11%)
# Likes:    217
# Dislikes: 0
# Total Accepted:    83.5K
# Total Submissions: 102.2K
# Testcase Example:  '[10,5,15,3,7,null,18]\n7\n15'
#
# 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
#
#
#
# 示例 1：
#
#
# 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
# 输出：32
#
#
# 示例 2：
#
#
# 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
# 输出：23
#
#
#
#
# 提示：
#
#
# 树中节点数目在范围 [1, 2 * 10^4] 内
# 1
# 1
# 所有 Node.val 互不相同
#
#
#

# @lc code=start
# Definition for a binary tree node.


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# 1. Solution1, Naive DFS, Time: O(n), Space: O(n), Runtime: 48%
# count = 0
# left, right = 0, 0
#
#
# class Solution:
#     def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
#         global left, right
#         left, right = low, high
#         global count
#         count = 0
#         self.traverse(root)
#         return count
#
#     def traverse(self, node: TreeNode):
#         global left, right
#         if node and left <= node.val <= right:
#             global count
#             count += node.val
#
#         if not node:
#             return
#         self.traverse(node.left)
#         self.traverse(node.right)


# 2. Solution2, 优雅 DFS, Time: O(n), Space: O(n), Runtime: 58%
# class Solution:
#     def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
#         if not root:
#             return 0
#         elif root.val > high:
#             return self.rangeSumBST(root.left, low, high)
#         elif root.val < low:
#             return self.rangeSumBST(root.right, low, high)
#         else:
#             return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)

# 3. Solution3, 非递归 BFS, Time: O(n), Space: O(n), Runtime: 58%
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        count = 0
        q = collections.deque([root])
        while q:
            node = q.popleft()
            if not node:
                continue
            elif node.val > high:
                q.append(node.left)
            elif node.val < low:
                q.append(node.right)
            else:
                count += node.val
                q.append(node.left)
                q.append(node.right)
        return count
# @lc code=end
