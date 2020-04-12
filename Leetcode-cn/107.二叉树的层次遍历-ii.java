/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (64.71%)
 * Likes:    219
 * Dislikes: 0
 * Total Accepted:    51.2K
 * Total Submissions: 79.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        else {
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> cur = new ArrayList<>();
            cur.add(root);

            while (!cur.isEmpty()) {
                List<Integer> vals = new ArrayList<>();
                List<TreeNode> next_level = new ArrayList<>();
                for (TreeNode node : cur) {
                    if (node.left != null)
                        next_level.add(node.left);
                    if (node.right != null)
                        next_level.add(node.right);
                    vals.add(node.val);
                }
                res.add(vals);
                cur = next_level;
            }
            Collections.reverse(res);
            return res;
        }
    }
}
// @lc code=end
