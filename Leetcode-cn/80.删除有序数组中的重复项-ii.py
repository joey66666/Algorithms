#
# @lc app=leetcode.cn id=80 lang=python3
#
# [80] 删除有序数组中的重复项 II
#
# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/description/
#
# algorithms
# Medium (57.56%)
# Likes:    483
# Dislikes: 0
# Total Accepted:    118.4K
# Total Submissions: 194.8K
# Testcase Example:  '[1,1,1,2,2,3]'
#
# 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
#
# 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
#
#
#
# 说明：
#
# 为什么返回数值是整数，但输出的答案是数组呢？
#
# 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
#
# 你可以想象内部操作如下:
#
#
# // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
# int len = removeDuplicates(nums);
#
# // 在函数里修改输入数组对于调用者是可见的。
# // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
# for (int i = 0; i < len; i++) {
# print(nums[i]);
# }
#
#
#
#
# 示例 1：
#
#
# 输入：nums = [1,1,1,2,2,3]
# 输出：5, nums = [1,1,2,2,3]
# 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
#
#
# 示例 2：
#
#
# 输入：nums = [0,0,1,1,1,1,2,3,3]
# 输出：7, nums = [0,0,1,1,2,3,3]
# 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
# 不需要考虑数组中超出新长度后面的元素。
#
#
#
#
# 提示：
#
#
# 1
# -10^4
# nums 已按升序排列
#
#
#

# @lc code=start
# 1. Solution1, 双指针，Time: O(n) , Space: O(1), Runtime: 28%
#     - 慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度，即 \textit{nums}[\textit{fast}]nums[fast] 表示待检查的第一个元素，\textit{nums}[\textit{slow} - 1]nums[slow−1] 为上一个应该被保留的元素所移动到的指定位置
#     - 需要检查上上个应该被保留的元素 nums[slow - 2] 是否和当前待检查元素 nums[fast] 相同。当且仅当 nums[slow−2]=nums[fast] 时，当前待检查元素 nums[fast] 不应该被保留（因为此时必然有 nums[slow−2]=nums[slow−1]=nums[fast]）
#     - 最后，slow 即为处理好的数组的长度
# class Solution:
    # def removeDuplicates(self, nums: List[int]) -> int:
    #     length = len(nums)
    #     if length < 2:
    #         return length
    #     slow, fast = 2, 2
    #     while fast < length:
    #         if nums[slow - 2] != nums[fast]:
    #             nums[slow] = nums[fast]
    #             slow += 1
    #         fast += 1
    #     return slow

# 2. Solution2, 双指针优雅版, Time: O(n), Space: O(1), Runtime: 78%
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for n in nums:
            if i < 2 or n > nums[i - 2]:
                nums[i] = n
                i += 1
        return i
# @lc code=end
