#
# @lc app=leetcode.cn id=852 lang=python3
#
# [852] 山脉数组的峰顶索引
#
# https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/description/
#
# algorithms
# Easy (70.26%)
# Likes:    178
# Dislikes: 0
# Total Accepted:    57.7K
# Total Submissions: 80.7K
# Testcase Example:  '[0,1,0]'
#
# 符合下列属性的数组 arr 称为 山脉数组 ：
# 
# arr.length >= 3
# 存在 i（0 < i < arr.length - 1）使得：
# 
# arr[0] < arr[1] < ... arr[i-1] < arr[i] 
# arr[i] > arr[i+1] > ... > arr[arr.length - 1]
# 
# 
# 
# 
# 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i +
# 1] > ... > arr[arr.length - 1] 的下标 i 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：arr = [0,1,0]
# 输出：1
# 
# 
# 示例 2：
# 
# 
# 输入：arr = [0,2,1,0]
# 输出：1
# 
# 
# 示例 3：
# 
# 
# 输入：arr = [0,10,5,2]
# 输出：1
# 
# 
# 示例 4：
# 
# 
# 输入：arr = [3,4,5,1]
# 输出：2
# 
# 
# 示例 5：
# 
# 
# 输入：arr = [24,69,100,99,79,78,67,36,26,19]
# 输出：2
# 
# 
# 
# 
# 提示：
# 
# 
# 3 
# 0 
# 题目数据保证 arr 是一个山脉数组
# 
# 
# 
# 
# 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
# 
#

# @lc code=start
# 1. Solution1, 单指针, Time: O(n), Space: O(1), Runtime: 91%
#   - 从左到右遍历，找最大值位变小的前一位，即最大值，即山峰
# class Solution:
#     def peakIndexInMountainArray(self, arr: List[int]) -> int:
#         n = len(arr)
#         if n < 3:
#             return 0
#         init = arr[0]

#         for i in range(1, n):
#             if arr[i] > init:
#                 init = arr[i]
#             if arr[i] < init:
#                 return i - 1

# 2. Solution2, 二分查找, Time: O(logn), Space: O(1), Runtime: 91%
#   - 左右之间二分，即寻找最小的 i，使 `arr[i] > arr[i + 1]`
#   - 若 `arr[mid] > arr[mid + 1]`，即`[mid, right]`见为递减，即答案在`[left, mid]`中，反之则在`[mid, right]`中
class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        n = len(arr)
        if n < 3:
            return 0
        left, right, res = 0, n, 0
        while left <= right:
            mid = (left + right) // 2
            if arr[mid] > arr[mid + 1]:
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res
# @lc code=end



