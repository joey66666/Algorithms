#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#
# https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
#
# algorithms
# Medium (64.61%)
# Likes:    1038
# Dislikes: 0
# Total Accepted:    313.1K
# Total Submissions: 484.7K
# Testcase Example:  '[3,2,1,5,6,4]\n2'
#
# 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
#
# 示例 1:
#
# 输入: [3,2,1,5,6,4] 和 k = 2
# 输出: 5
#
#
# 示例 2:
#
# 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
# 输出: 4
#
# 说明:
#
# 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
#
#

# @lc code=start
# 1. Solution1, 暴力，排序后返回, Time: O(nlogn), Space: O(n), Runtime: 81%
#   - Time: O(nlogn) 和 Space: O(n) 都是python 自带 sorted() 方法的 Time Sort 的开销
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if n == 0:
            return n
        nums = sorted(nums)
        return nums[-k]

# 2. Solution2, 使用自带堆, Time: O(n), Space: O(n), Runtime: 91%
#   - 开销是构建堆和在堆查找的开销
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        return heapq.nlargest(k, nums)[k - 1]

# @lc code=end
