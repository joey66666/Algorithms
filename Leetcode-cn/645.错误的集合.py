#
# @lc app=leetcode.cn id=645 lang=python3
#
# [645] 错误的集合
#
# https://leetcode-cn.com/problems/set-mismatch/description/
#
# algorithms
# Easy (41.70%)
# Likes:    199
# Dislikes: 0
# Total Accepted:    52.7K
# Total Submissions: 121.7K
# Testcase Example:  '[1,2,2,4]'
#
# 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且
# 有一个数字重复 。
# 
# 给定一个数组 nums 代表了集合 S 发生错误后的结果。
# 
# 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,2,4]
# 输出：[2,3]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1,1]
# 输出：[1,2]
# 
# 
# 
# 
# 提示：
# 
# 
# 2 
# 1 
# 
# 
#

# @lc code=start
# 1. Solution1, 数组模拟Hash, Time: O(n), Space: O(n), Runtime: 55%
#   - 遍历，找到重复的元素，放入res，再找[1,n]中未出现过的元素，放入res
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n == 0:
            return []
        array, res = [0] * n, []
        for num in nums:
            if array[num - 1] != 0:
                res.append(num)
            array[num - 1] += 1
        res.append(array.index(0) + 1)
        return res
# @lc code=end

