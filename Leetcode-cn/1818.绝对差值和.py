#
# @lc app=leetcode.cn id=1818 lang=python3
#
# [1818] 绝对差值和
#
# https://leetcode-cn.com/problems/minimum-absolute-sum-difference/description/
#
# algorithms
# Medium (39.03%)
# Likes:    77
# Dislikes: 0
# Total Accepted:    17.7K
# Total Submissions: 47.7K
# Testcase Example:  '[1,7,5]\n[2,3,5]'
#
# 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
# 
# 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 ）的 总和（下标从 0 开始）。
# 
# 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
# 
# 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
# 
# |x| 定义为：
# 
# 
# 如果 x >= 0 ，值为 x ，或者
# 如果 x  ，值为 -x
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums1 = [1,7,5], nums2 = [2,3,5]
# 输出：3
# 解释：有两种可能的最优方案：
# - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
# - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
# 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
# 
# 
# 示例 2：
# 
# 
# 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
# 输出：0
# 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
# 
# 
# 示例 3：
# 
# 
# 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
# 输出：20
# 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
# 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
# 
# 
# 
# 
# 提示：
# 
# 
# n == nums1.length
# n == nums2.length
# 1 
# 1 
# 
# 
#

# @lc code=start
# 1. Solution1, 排序+手写二分, Time: O(nlogn), Space: O(n), Runtime: 35%
#   - 核心思想：每次遍历到 i 时，在 nums1 中二分查找最接近 nums2[i] 的值，即可替换的 i，替换后构成最小的差值和，更新该差值，最后结果为 sum - ma
#   - 先对 nums1 进行拷贝并排序，得到 sortNums, 在遍历 nums1 和 nums2 计算总的差值 sum 时，通过对 sortNums 进行二分查找，找到最合适替换 nums[i] 的值, 即最接近 nums2[i] 的值, 再计算新差值，如果大于旧差值，则记录下来，不断更新，增大该差值, 最后结果为 `差值和 - 可减去的最大差值`, 即 `sum - ma`
#   - 注意：每次得到的值可能大于nums2[i]，也可能小于，所以计算两次
class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        def biSec(nums: List[int], target: int) -> int:
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        if nums1 == nums2:
            return 0
        sortNums, n, res, ma, MOD = sorted(nums1), len(nums1), 0, 0, 10 ** 9 + 7

        for i in range(n):
            num1, num2 = nums1[i], nums2[i]
            diff = abs(num1 - num2)
            res = (res + diff) % MOD
            target = biSec(sortNums, num2)
            # target > 0，先看小一位的情况
            if target > 0:
                ma = max(ma, diff - abs(num2 - sortNums[target - 1]))
            # 再看大一位的情况
            if target < n:
                ma = max(ma, diff - abs(sortNums[target] - num2))
        return (res - ma + MOD) % MOD


# 2. Solution2, 库函数二分, Time: O(nlogn), Sapce: O(n), Runtime: 85%
class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:

        if nums1 == nums2:
            return 0
        sortNums, n, res, ma, MOD = sorted(nums1), len(nums1), 0, 0, 10 ** 9 + 7

        for i in range(n):
            num1, num2 = nums1[i], nums2[i]
            diff = abs(num1 - num2)
            res = (res + diff) % MOD
            target = bisect.bisect_left(sortNums, num2)
            # target > 0，先看小一位的情况
            if target > 0:
                ma = max(ma, diff - abs(num2 - sortNums[target - 1]))
            # 再看大一位的情况
            if target < n:
                ma = max(ma, diff - abs(sortNums[target] - num2))
        return (res - ma + MOD) % MOD
# @lc code=end
