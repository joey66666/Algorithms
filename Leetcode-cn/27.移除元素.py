#
# @lc app=leetcode.cn id=27 lang=python3
#
# [27] 移除元素
#
# https://leetcode-cn.com/problems/remove-element/description/
#
# algorithms
# Easy (57.91%)
# Likes:    520
# Dislikes: 0
# Total Accepted:    160.3K
# Total Submissions: 276.8K
# Testcase Example:  '[3,2,2,3]\n3'
#
# 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
#
# 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
#
# 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
#
#
#
# 示例 1:
#
# 给定 nums = [3,2,2,3], val = 3,
#
# 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
#
# 你不需要考虑数组中超出新长度后面的元素。
#
#
# 示例 2:
#
# 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
#
# 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
#
# 注意这五个元素可为任意顺序。
#
# 你不需要考虑数组中超出新长度后面的元素。
#
#
#
#
# 说明:
#
# 为什么返回数值是整数，但输出的答案是数组呢?
#
# 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
#
# 你可以想象内部操作如下:
#
# // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
# int len = removeElement(nums, val);
#
# // 在函数里修改输入数组对于调用者是可见的。
# // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
# for (int i = 0; i < len; i++) {
# print(nums[i]);
# }
#
#
#

# @lc code=start
# 1. Solution1, 排序后双指针遍历，移动到左和右区间，继续遍历，右覆盖左, Time: O(nlogn), Space: O(1), Runtime: 60%
# class Solution:
#     def removeElement(self, nums: List[int], val: int) -> int:
#         nums.sort()
#         n = len(nums)
#         if n == 0:
#             return n
#         left, right = 0, 0
#         while right < n and nums[right] != val:
#             right += 1
#         left = right
#         while right < n and nums[right] == val:
#             right += 1
#         while right < n:
#             nums[left] = nums[right]
#             left += 1
#             right += 1
#         return left

# 2. Solution2, 优化1，用自带的nums.index()先拿到左指针位置, Time: O(n), Space: O(1), Runtime: 94%
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        nums.sort()
        n = len(nums)
        if val not in nums:
            return n
        left, right = nums.index(val), nums.index(val)
        while right < n and nums[right] == val:
            right += 1
        while right < n:
            nums[left] = nums[right]
            left += 1
            right += 1
        return left

# 3. Solution3, 双指针从左开始遍历，赋值非 val 的数值, Time: O(n), Space: O(1), Runtime: 60%
#   - 右指针走，if nums[right] != val, nums[left] = nums[right]
# class Solution:
#     def removeElement(self, nums: List[int], val: int) -> int:
#         n = len(nums)
#         if n == 0:
#             return n
#         left = 0
#         for right in range(n):
#             if nums[right] != val:
#                 nums[left] = nums[right]
#                 left += 1
#         return left


# 4. Solution4, 双指针从左右往中间逼近，不用考虑顺序，所以可以把末尾那段逆向赋值到val段，Time: O(n), Space: O(1), Runtime: 60%
# class Solution:
#     def removeElement(self, nums: List[int], val: int) -> int:
#         n = len(nums)
#         if n == 0:
#             return n
#         left, right = 0, n
#         while left < right:
#             if nums[left] == val:
#                 nums[left] = nums[right - 1]
#                 right -= 1
#             else:
#                 left += 1
#         return left

# @lc code=end
