/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (39.79%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    35.6K
 * Total Submissions: 88.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 *
 * 输出: 6
 *
 *
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * 输出: 42
 *
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        traverse(root);
        // 使用数组为了保存值，使用变量每次更新迭代，无法保存值
        return max[0];
    }

    int[] max = new int[]{Integer.MIN_VALUE};

    // 以root为顶点直上直下的Path中最大的值
    public int traverse(TreeNode root) {
        int left = root.left != null ? Math.max(traverse(root.left), 0) : 0;
        int right = root.right != null ? Math.max(traverse(root.right), 0) : 0;
        max[0] = Math.max(max[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
// @lc code=end

