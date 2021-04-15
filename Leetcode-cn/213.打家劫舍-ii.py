#
# @lc app=leetcode.cn id=213 lang=python3
#
# [213] 打家劫舍 II
#
# https://leetcode-cn.com/problems/house-robber-ii/description/
#
# algorithms
# Medium (42.08%)
# Likes:    612
# Dislikes: 0
# Total Accepted:    107.9K
# Total Submissions: 256.4K
# Testcase Example:  '[2,3,2]'
#
# 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
# ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
#
# 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
#
#
#
# 示例 1：
#
#
# 输入：nums = [2,3,2]
# 输出：3
# 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
#
#
# 示例 2：
#
#
# 输入：nums = [1,2,3,1]
# 输出：4
# 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
# 偷窃到的最高金额 = 1 + 3 = 4 。
#
# 示例 3：
#
#
# 输入：nums = [0]
# 输出：0
#
#
#
#
# 提示：
#
#
# 1
# 0
#
#
#

# @lc code=start

# 1. Solution1, DP, Time: O(n), Space: O(n), Runtime: 83%
#   - 不同时触发首尾：拆成两个数组，[0, n - 1], [1, n]，取两个数组dp的最大值
#   - n == 1: 返回, n == 2: 取最大值返回
#   - dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
class Solution:
    def rob(self, nums: List[int]) -> int:
        def steal(start: int, end: int, nums: List[int]) -> int:
            res = [nums[start], max(nums[start], nums[start + 1])]
            for i in range(start + 2, end + 1):
                res.append(max(nums[i] + res[-2], res[-1]))
            return res[-1]

        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums[0], nums[1])
        else:
            return max(steal(0, len(nums) - 2, nums), steal(1, len(nums) - 1, nums))

# 2. Solution2, 优化DP, 两个变量存储过程中的结果，Time: O(n), Space: O(1), Runtime: 95%
#   - 过程中只需要保存dp数组最后两个数，用变量代替
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         def steal(start: int, end: int, nums: List[int]) -> int:
#             first = nums[start]
#             second = max(nums[start], nums[start + 1])
#             for i in range(start + 2, end + 1):
#                 first, second = second, max(second, first + nums[i])
#             return second
#
#         if len(nums) == 1:
#             return nums[0]
#         elif len(nums) == 2:
#             return max(nums[0], nums[1])
#         else:
#             return max(steal(0, len(nums) - 2, nums), steal(1, len(nums) - 1, nums))
# @lc code=end
