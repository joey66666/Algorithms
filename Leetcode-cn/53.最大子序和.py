#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
#
# https://leetcode-cn.com/problems/maximum-subarray/description/
#
# algorithms
# Easy (54.61%)
# Likes:    3430
# Dislikes: 0
# Total Accepted:    570.6K
# Total Submissions: 1M
# Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
#
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
# 输出：6
# 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1]
# 输出：1
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [0]
# 输出：0
# 
# 
# 示例 4：
# 
# 
# 输入：nums = [-1]
# 输出：-1
# 
# 
# 示例 5：
# 
# 
# 输入：nums = [-100000]
# 输出：-100000
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# -10^5 
# 
# 
# 
# 
# 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
# 
#

# @lc code=start
# 1. Solution1, DP, Time: O(n), Space: O(n), Runtime: 99%
#   - DP化：DP数组保存过程中可能的最大和，DP[i] 表示直到 i 可以构成的最大和
#   - 初始条件：dp[0] = nums[0]
#   - 状态转移：如果dp[i - 1] > 0，表示加上 nums[i] 是正收益，否则是负收益，从 nums[i] 重新开始累加
#       if dp[i - 1] > 0, dp[i] = dp[i - 1] + nums[i]
#             else dp[i] = nums[i]
#   - 结束条件：return max(dp)
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            if dp[i - 1] > 0:
                dp[i] = dp[i - 1] + nums[i]
            else:
                dp[i] = nums[i]
        return max(dp)
        
# @lc code=end

