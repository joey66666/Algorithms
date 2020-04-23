/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (65.22%)
 * Likes:    451
 * Dislikes: 0
 * Total Accepted:    79.1K
 * Total Submissions: 121K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid[0].length;
        int line = grid.length;
        int[][] dp = new int[line][row];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < line; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < row; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < line; i++) {
            for (int j = 1; j < row; j++) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        }
        return dp[line - 1][row - 1];
    }
}
// @lc code=end

