import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.45%)
 * Likes:    503
 * Dislikes: 0
 * Total Accepted:    161K
 * Total Submissions: 225.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
     * int val; 
     * TreeNode left; 
     * TreeNode right; 
     * TreeNode(int x) { 
     * val = x; 
 *  } 
 * }
 */
// 递归版本
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        if (root == null) return null;
        else {
            res.add(root.val);
        }
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }
}

// 非递归，栈实现
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node = root;
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            res.add(node.val);
//            node = node.right;
//        }
//        return res;
//    }
//}
// @lc code=end
