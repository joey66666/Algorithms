// Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
// We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.


// Example 1:
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
// Output: true
// Explanation:
// The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
// Other valid sequences are:
// 0 -> 1 -> 1 -> 0
// 0 -> 0 -> 0

// Example 2:
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
// Output: false
// Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.

// Example 3:
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
// Output: false
// Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.

// Constraints:
// 1 <= arr.length <= 5000
// 0 <= arr[i] <= 9
// Each node's value is between [0 - 9].


import com.sun.jdi.connect.Connector;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// 必须从root开始，到leaf结束
// 两种情况
//    1. 当前节点value != arr[i], return false;
//    2. arr到达末尾，树未遍历到leaf, return false;
// 遍历左右子树，root为根有一棵为true则存在序列
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        if (arr == null || arr.length == 0) return false;
        return traverse(root, arr, 0);
    }

    public boolean traverse(TreeNode root, int[] arr, int i) {
        if (root == null) return false;
        if (root.val != arr[i]) return false;
        if (i == arr.length - 1) return root.left == null && root.right == null;
        return traverse(root.left, arr, i + 1) || traverse(root.right, arr, i + 1);
    }
}
