#
# @lc app=leetcode.cn id=363 lang=python3
#
# [363] 矩形区域不超过 K 的最大数值和
#
# https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
#
# algorithms
# Hard (35.77%)
# Likes:    97
# Dislikes: 0
# Total Accepted:    3.7K
# Total Submissions: 10K
# Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
#
# 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
# 
# 示例:
# 
# 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
# 输出: 2 
# 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
# 
# 
# 说明：
# 
# 
# 矩阵内的矩形区域面积必须大于 0。
# 如果行数远大于列数，你将如何解答呢？
# 
# 
#

# @lc code=start
# 1. Solution1, 有序集合, Time: O(m^2nlogn), Spac: O(n), Runtime:
#   - https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/ju-xing-qu-yu-bu-chao-guo-k-de-zui-da-sh-70q2/
#   - 其实就是暴力，在每一行的上下边界内，对每一列进行计算方格满足条件的值，进而遍历矩阵内每一个方格
#   - 将：寻找矩阵内部矩形区域的不超过 k 的最大数值和 的问题 -> 转化成：计算每组最大区间和, 找到不大于 k 的区间和
class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        ans = float("-inf")
        m, n = len(matrix), len(matrix[0])

        for i in range(m):  # 枚举上边界
            total = [0] * n
            for j in range(i, m):  # 枚举下边界
                for c in range(n):
                    total[c] += matrix[j][c]  # 更新每列的元素和

                totalSet = SortedList([0])
                s = 0
                for v in total:
                    s += v # s: 矩阵和
                    lb = totalSet.bisect_left(s - k)
                    if lb != len(totalSet):
                        ans = max(ans, s - totalSet[lb])
                    totalSet.add(s)

        return ans        
# @lc code=end

