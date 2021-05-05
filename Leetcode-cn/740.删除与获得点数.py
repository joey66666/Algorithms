#
# @lc app=leetcode.cn id=740 lang=python3
#
# [740] 删除与获得点数
#
# https://leetcode-cn.com/problems/delete-and-earn/description/
#
# algorithms
# Medium (54.20%)
# Likes:    329
# Dislikes: 0
# Total Accepted:    30.5K
# Total Submissions: 49.1K
# Testcase Example:  '[3,4,2]'
#
# 给你一个整数数组 nums ，你可以对它进行一些操作。
# 
# 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
# 1 的元素。
# 
# 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [3,4,2]
# 输出：6
# 解释：
# 删除 4 获得 4 个点数，因此 3 也被删除。
# 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [2,2,3,3,3,4]
# 输出：9
# 解释：
# 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
# 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
# 总共获得 9 个点数。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 1 
# 
# 
#

# @lc code=start
# 1. Solution1, DP, Time: O(n + m), Space: O(m), Runtime: 50%
#   - 使用 `total` 数组，统计每个 `nums[i]` 的收益点数和，即 `次数 * nums[i]`
#   - 在 `total` 上隔一个计算一次最大收益，最大值即为答案
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxVal = max(nums)
        total = [0] * (maxVal + 1)
        for val in nums:
            total[val] += val

        first, second = total[0], max(total[0], total[1])
        for i in range(2, len(total)):
            first, second = second, max(first + total[i], second)
        return second
# @lc code=end

