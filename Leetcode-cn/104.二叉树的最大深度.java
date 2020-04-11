/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (72.74%)
 * Likes:    501
 * Dislikes: 0
 * Total Accepted:    155.3K
 * Total Submissions: 213.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// Solution1 借助Helper函数
// class Solution {
//     public int maxDepth(TreeNode root) {

//         return traverse(root);
//     }

//     public int traverse(TreeNode node) {
//         if (node == null)
//             return 0;
//         else if (node.left == null && node.right == null)
//             return 1;
//         int left = traverse(node.left);
//         int right = traverse(node.right);

//         return 1 + Math.max(left, right);

//     }
// }

// Solution2，Helper函数内嵌
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
// @lc code=end
