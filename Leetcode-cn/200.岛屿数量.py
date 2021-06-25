#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (54.07%)
# Likes:    1206
# Dislikes: 0
# Total Accepted:    268.2K
# Total Submissions: 494.6K
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
#
# 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
#
# 此外，你可以假设该网格的四条边均被水包围。
#
#
#
# 示例 1：
#
#
# 输入：grid = [
# ⁠ ["1","1","1","1","0"],
# ⁠ ["1","1","0","1","0"],
# ⁠ ["1","1","0","0","0"],
# ⁠ ["0","0","0","0","0"]
# ]
# 输出：1
#
#
# 示例 2：
#
#
# 输入：grid = [
# ⁠ ["1","1","0","0","0"],
# ⁠ ["1","1","0","0","0"],
# ⁠ ["0","0","1","0","0"],
# ⁠ ["0","0","0","1","1"]
# ]
# 输出：3
#
#
#
#
# 提示：
#
#
# m == grid.length
# n == grid[i].length
# 1
# grid[i][j] 的值为 '0' 或 '1'
#
#
#

# @lc code=start
# 1. Solution1, DFS, Time: O(n^2), Space: O(n), Runtime: 83%
#   - 遇到一个岛屿，消除他的所有边界，计数
#   - 即，遍历，遇到的每个1，DFS，从这个1可DFS到的的所有1，置为0，计数+1，即存在一个岛屿

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(self, grid: List[List[str]], i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
                return
            if grid[i][j] == '0':
                return
            grid[i][j] = '0'
            dfs(self, grid, i - 1, j)
            dfs(self, grid, i, j - 1)
            dfs(self, grid, i + 1, j)
            dfs(self, grid, i, j + 1)
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    dfs(self, grid, i, j)
                    count += 1
        return count

# @lc code=end
