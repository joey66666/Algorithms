#
# @lc app=leetcode.cn id=554 lang=python3
#
# [554] 砖墙
#
# https://leetcode-cn.com/problems/brick-wall/description/
#
# algorithms
# Medium (40.46%)
# Likes:    154
# Dislikes: 0
# Total Accepted:    21.7K
# Total Submissions: 51.5K
# Testcase Example:  '[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]'
#
# 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
# 
# 你现在要画一条 自顶向下 的、穿过 最少
# 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
# 
# 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线
# 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
# 输出：2
# 
# 
# 示例 2：
# 
# 
# 输入：wall = [[1],[1],[1]]
# 输出：3
# 
# 
# 
# 提示：
# 
# 
# n == wall.length
# 1 
# 1 
# 1 
# 对于每一行 i ，sum(wall[i]) 应当是相同的
# 1 
# 
# 
#

# @lc code=start
# 1. Solution1，找反例, HashMap, Time: O(n * m), Space: O(n), Runtime: 84%
#   - 找穿过最少的砖块数量，就是穿过最多的砖缝数量
#   - 对每一层对一块砖，计算一次砖缝到左边界的距离，放入整面墙的HashMap中，Key是砖缝距离，Value是出现次数
#   - 最后结果是 `砖墙高度 - 出现最多的砖缝数`
class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        dic = {}
        rows = len(wall)
        for i in range(rows):
            distance = 0
            for col in range(len(wall[i]) - 1):
                distance += wall[i][col]
                dic[distance] = dic.get(distance, 0) + 1
        big = 0
        for k in dic:
            big = max(big, dic[k])
        return rows - big

# @lc code=end
