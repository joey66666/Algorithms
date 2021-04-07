#
# @lc app=leetcode.cn id=81 lang=python3
#
# [81] 搜索旋转排序数组 II
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
#
# algorithms
# Medium (37.36%)
# Likes:    404
# Dislikes: 0
# Total Accepted:    94.4K
# Total Submissions: 227.9K
# Testcase Example:  '[2,5,6,0,0,1,2]\n0'
#
# 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
#
# 在传递给函数之前，nums 在预先未知的某个下标 k（0 ）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ...,
# nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如，
# [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
#
# 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值
# target ，则返回 true ，否则返回 false 。
#
#
#
# 示例 1：
#
#
# 输入：nums = [2,5,6,0,0,1,2], target = 0
# 输出：true
#
#
# 示例 2：
#
#
# 输入：nums = [2,5,6,0,0,1,2], target = 3
# 输出：false
#
#
#
# 提示：
#
#
# 1
# -10^4
# 题目数据保证 nums 在预先未知的某个下标上进行了旋转
# -10^4
#
#
#
#
# 进阶：
#
#
# 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
# 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
#
#
#

# @lc code=start
# Solution1, 二分, Time: O(logn), Space: O(1), Runtime: 88%
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0] == target
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return True
            elif nums[left] == nums[mid] and nums[mid] == nums[right]:
                left += 1
                right -= 1
            elif nums[left] <= nums[mid]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1  
        return False

# 暴力, Time: O(n), Space: O(1), Runtime: 71%
# class Solution:
#     def search(self, nums: List[int], target: int) -> bool:
#         for num in nums:
#             if num == target:
#                 return True
#         return False
# @lc code=end
