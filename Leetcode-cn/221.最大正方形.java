/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (39.35%)
 * Likes:    296
 * Dislikes: 0
 * Total Accepted:    32.4K
 * Total Submissions: 81.8K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */

// @lc code=start
// dp[i][j]数组用来保存以matrix[i][j]为右下角的最大正方形边长
// if(matrix[i][j] == 1){ 
//      dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]) + 1
// }
// return dp 数组中最大值的 ^2 

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int cols = matrix.length;
        int rows = matrix[0].length;
        int[][] dp = new int[cols][rows];
        int max = 0;

        for (int i = 0; i < cols; i++) {
            dp[i][0] = matrix[i][0] - 48;
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < rows; j++) {
            dp[0][j] = matrix[0][j] - 48;
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return (int) Math.pow(max, 2);
    }
}
// @lc code=end

