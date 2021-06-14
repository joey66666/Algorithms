#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#
# https://leetcode-cn.com/problems/3sum/description/
#
# algorithms
# Medium (32.32%)
# Likes:    3417
# Dislikes: 0
# Total Accepted:    534.3K
# Total Submissions: 1.7M
# Testcase Example:  '[-1,0,1,2,-1,-4]'
#
# 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
# 且不重复的三元组。
#
# 注意：答案中不可以包含重复的三元组。
#
#
#
# 示例 1：
#
#
# 输入：nums = [-1,0,1,2,-1,-4]
# 输出：[[-1,-1,2],[-1,0,1]]
#
#
# 示例 2：
#
#
# 输入：nums = []
# 输出：[]
#
#
# 示例 3：
#
#
# 输入：nums = [0]
# 输出：[]
#
#
#
#
# 提示：
#
#
# 0
# -10^5
#
#
#

# @lc code=start
# 1. Solution1, 排序+双指针, Time: O(n^2), Space: O(1), Runtime:55%
#   - 关键在于去除重复项
#   1. 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []
#   2. 对数组进行排序
#   3. 遍历排序后数组：
#       - 若 `nums[i]>0`：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
#       - 对于重复元素：跳过，避免出现重复解
#       - 令左指针 `l=i+1`，右指针 `r=n-1`，当 `l<r` 时，执行循环：
#       - 当 `nums[i]+nums[l]+nums[r]==0`, 执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
#       - 若和大于 0，说明 `nums[r]` 太大，r 左移
#       - 若和小于 0，说明 `nums[l]` 太小，l 右移
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if not nums or n < 3:
            return []
        nums.sort()
        res = []
        for i in range(n):
            if nums[i] > 0:
                return res
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, n - 1
            while l < r:
                if nums[i] + nums[l] + nums[r] == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    l, r = l + 1, r - 1
                elif nums[i] + nums[l] + nums[r] < 0:
                    l += 1
                else:
                    r -= 1
        return res

# @lc code=end
