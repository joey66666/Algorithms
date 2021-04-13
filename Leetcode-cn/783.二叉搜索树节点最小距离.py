#
# @lc app=leetcode.cn id=783 lang=python3
#
# [783] 二叉搜索树节点最小距离
#
# https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/description/
#
# algorithms
# Easy (59.17%)
# Likes:    178
# Dislikes: 0
# Total Accepted:    59.6K
# Total Submissions: 100.8K
# Testcase Example:  '[4,2,6,1,3]'
#
# 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
#
# 注意：本题与
# 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
# 相同
#
#
#
#
#
# 示例 1：
#
#
# 输入：root = [4,2,6,1,3]
# 输出：1
#
#
# 示例 2：
#
#
# 输入：root = [1,0,48,null,null,12,49]
# 输出：1
#
#
#
#
# 提示：
#
#
# 树中节点数目在范围 [2, 100] 内
# 0
#
#
#
#
#

# @lc code=start
# Definition for a binary tree node
# Solution1, 遍历，放到list，排序后再遍历，Time: O(n), Space: O(n), Runtime: 70%
# class Solution:
#     def minDiffInBST(self, root: TreeNode) -> int:
#         res = []
#         self.traverse(root, res)
#         res = sorted(res)
#         diff = abs(res[0] - res[1])
#         for i in range(len(res)):
#             diff = min(diff, abs(res[i] - res[i - 1]))
#         return diff
#     def traverse(self, root: TreeNode, res: List):
#         if root is None:
#             return
#         else:
#             res.append(root.val)
#         if root.left:
#             self.traverse(root.left, res)
#         if root.right:
#             self.traverse(root.right, res)

# Solution2，中序遍历，遍历过程中记录`pre`并比较, Time: O(n), Space: O(1), Runtime: 96%
#   - 二叉搜索树中序遍历得到的值序列是递增有序的
class Solution:
    res, pre = float('inf'), -1
    
    def minDiffInBST(self, root: TreeNode) -> int:
        # min, pre = sys.maxsize, -1
        self.traverse(root)
        return self.res

    def traverse(self, root: TreeNode):
        if root is None:
            return
        self.traverse(root.left)
        if self.pre != -1:
            self.res = min(self.res, abs(root.val - self.pre))
        self.pre = root.val
        self.traverse(root.right)

# @lc code=end

