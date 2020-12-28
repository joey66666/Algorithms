/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (32.79%)
 * Likes:    870
 * Dislikes: 0
 * Total Accepted:    204.5K
 * Total Submissions: 617.9K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return false;
//         List<Integer> list = new ArrayList<Integer>();
//         traverse(root, list);
//         for (int i = 0; i < list.size() - 1; i++) {
//             if (!(list.get(i) < list.get(i + 1))) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public void traverse(TreeNode node, List<Integer> list) {
//         if (node == null) return;

//         // 中序遍历
//         traverse(node.left, list);
//         list.add(node.val);
//         traverse(node.right, list);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    public boolean traverse(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max!= null && val >= max) {
            return false;
        }

        if (!traverse(node.left, min, node.val)) {
            return false;
        }

        if (!traverse(node.right, node.val, max)) {
            return false;
        }
        return true;
    }
}
// @lc code=end



