import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (71.43%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    80.8K
 * Total Submissions: 113.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
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
     * }
 * }
 */
// 递归
// class Solution {
//    List<Integer> res = new ArrayList<>();
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        if (root.left != null) {
//            postorderTraversal(root.left);
//        }
//        if (root.right != null) {
//            postorderTraversal(root.right);
//        }
//        if (root != null) {
//            res.add(root.val);
//        }
//        return res;
//    }
//}

// 栈实现
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == last) {
                res.add(node.val);
                node = stack.pop();
                last = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return res;
    }
}
// @lc code=end
