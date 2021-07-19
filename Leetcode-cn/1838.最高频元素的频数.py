#
# @lc app=leetcode.cn id=1838 lang=python3
#
# [1838] 最高频元素的频数
#
# https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/description/
#
# algorithms
# Medium (38.05%)
# Likes:    136
# Dislikes: 0
# Total Accepted:    20.8K
# Total Submissions: 49.3K
# Testcase Example:  '[1,2,4]\n5'
#
# 元素的 频数 是该元素在一个数组中出现的次数。
# 
# 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
# 
# 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,4], k = 5
# 输出：3
# 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
# 4 是数组中最高频元素，频数是 3 。
# 
# 示例 2：
# 
# 
# 输入：nums = [1,4,8,13], k = 5
# 输出：2
# 解释：存在多种最优解决方案：
# - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
# - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
# - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [3,9,6], k = 2
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 1 
# 1 
# 
# 
#

# @lc code=start
#### [1838] 最高频元素的频数
# - https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/description/
# 1. Solution1, 滑动窗口, Time: O(nlogn), Space: O(logn), Runtime: 89%
#    - 先排序，右窗口移动，从`r`开始，往左找`r - l`位，假设窗口内全符合条件，计算窗口内有可能全部变成`nums[r]`所需的最小全部元素和`total += (nums[r] - nums[r - 1]) * (r - l)`
#    - 如果`total > k`, 即窗口内`k`不满足，从左边开始收缩窗口，踢出不符合的元素，直到窗口内`total < k`, 即`k`满足为止
#    - 记录过程中产生的最大`res`
class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        l, total, res = 0, 0, 1
        for r in range(1, n):
            total += (nums[r] - nums[r - 1]) * (r - l)
            while total > k:
                total -= nums[r] - nums[l]
                l += 1
            res = max(res, r - l + 1)
        return res
# @lc code=end

