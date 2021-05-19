#
# @lc app=leetcode.cn id=1738 lang=python3
#
# [1738] 找出第 K 大的异或坐标值
#
# https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/description/
#
# algorithms
# Medium (60.32%)
# Likes:    69
# Dislikes: 0
# Total Accepted:    24K
# Total Submissions: 36.7K
# Testcase Example:  '[[5,2],[1,6]]\n1'
#
# 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
#
# 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素
# matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
#
# 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
#
#
#
# 示例 1：
#
# 输入：matrix = [[5,2],[1,6]], k = 1
# 输出：7
# 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
#
# 示例 2：
#
# 输入：matrix = [[5,2],[1,6]], k = 2
# 输出：5
# 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
#
# 示例 3：
#
# 输入：matrix = [[5,2],[1,6]], k = 3
# 输出：4
# 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
#
# 示例 4：
#
# 输入：matrix = [[5,2],[1,6]], k = 4
# 输出：0
# 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
#
#
#
# 提示：
#
#
# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 1000
# 0 <= matrix[i][j] <= 10^6
# 1 <= k <= m * n
#
#
#

# @lc code=start
# 1. Solution1, DP, Time: O(m * n), Space: O(m * n), Runtime: 79%
# - https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/zhao-chu-di-k-da-de-yi-huo-zuo-biao-zhi-mgick/
# - https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/chi-xiao-dou-python-jian-ming-jie-ti-si-doktr/
#   - 题意转化为：求【所有子矩阵中第 k 大的异或和】
#   - p[i][j] 表示前缀和，即以matrix[i][j]的子矩阵运算出的异或和
#   - p[i][j] = p[i-1][j] ^ p[i][j-1] ^ p[i-1][j-1] ^ matrix[i-1][j-1]
class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        square = [[0] * (n + 1) for _ in range(m + 1)]
        res = []
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                square[i][j] = square[i - 1][j] ^ square[i][j - 1] ^ square[i - 1][j - 1] ^ matrix[i - 1][j - 1]
                res.append(square[i][j])
        res = sorted(res, reverse=True)
        return res[k - 1]

# @lc code=end
