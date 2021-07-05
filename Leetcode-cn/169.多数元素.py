#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (66.12%)
# Likes:    1048
# Dislikes: 0
# Total Accepted:    335.7K
# Total Submissions: 507K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
# 
# 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：[3,2,3]
# 输出：3
# 
# 示例 2：
# 
# 
# 输入：[2,2,1,1,1,2,2]
# 输出：2
# 
# 
# 
# 
# 进阶：
# 
# 
# 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
# 
# 
#

# @lc code=start
# 1. Solution1, Hash, Time: O(n), Space: O(n), Runtime: 30%
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dic = {}
        for num in nums:
            if num in dic:
                dic[num] = dic[num] + 1
            else:
                dic[num] = 1
        count, res = 0, 0
        for key in dic.keys():
            if dic[key] > count:
                count = dic[key]
                res = key
        return res

# 1.1. Solution1.1, 高级版, Time: O(n), Space: O(n), Runtime: 87% 
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counts = collections.Counter(nums)
        return max(counts.keys(), key=counts.get)

# 3. Solution2, 摩尔投票法, Time: O(n), Space: O(1), Runtime: 95%
#  - 假设 nums[0] 为最多元素，遍历，相同 + 1，不同 - 1
#  - 若归零，则前面其他和本身数量相等，对冲抵消，指针当下指向另一个数，换成另一个数，对后面继续遍历比较
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        start, count = nums[0], 1
        for i in range(1, len(nums)):
            if nums[i] == start:
                count += 1
            else:
                count -= 1
            if count == 0:
                start = nums[i]
                count = 1
        return start
# @lc code=end

