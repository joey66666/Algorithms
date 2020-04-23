/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (47.91%)
 * Likes:    539
 * Dislikes: 0
 * Total Accepted:    98K
 * Total Submissions: 199.1K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 *
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int line = grid.length;
        int row = grid[0].length;
        int count = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j, row, line);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void traverse(char[][] grid, int i, int j, int row, int line) {
        if (i >= line || i < 0 || j >= row || j < 0) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        traverse(grid, i - 1, j, row, line);
        traverse(grid, i + 1, j, row, line);
        traverse(grid, i, j - 1, row, line);
        traverse(grid, i, j + 1, row, line);
    }
}
// @lc code=end

